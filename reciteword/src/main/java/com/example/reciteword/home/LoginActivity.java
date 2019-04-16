package com.example.reciteword.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reciteword.R;
import com.example.reciteword.base.BaseActivity;
import com.example.reciteword.bean.UserBean;
import com.example.reciteword.utils.JsonUtil;
import com.example.reciteword.utils.RequestParamUtil;
import com.example.reciteword.utils.SpUtil;
import com.example.reciteword.widget.LoadingDialog;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @ViewInject(R.id.name_et)
    EditText nameEt;
    @ViewInject(R.id.password_et)
    EditText passwordEt;
    @ViewInject(R.id.keep_password)
    CheckBox keepPassword;
    @ViewInject(R.id.login_bt)
    Button loginBt;
    @ViewInject(R.id.forget_password)
    TextView forgetOassword;
    @ViewInject(R.id.iv_delName)
    ImageView iv_delName;
    @ViewInject(R.id.iv_delPwd)
    ImageView iv_delPwd;

    String name;
    String password;

    @Override
    protected void initdata() {
        UserBean userBean = getUser();
        if (userBean != null) {
            nameEt.setText(userBean.getT_code());
            if (userBean.isKeepInfo() && !TextUtils.isEmpty(userBean.getPassword())) {
                passwordEt.setText(userBean.getPassword());
                keepPassword.setChecked(true);
            }
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        x.view().inject(this);
        loginBt.setOnClickListener(this);
        nameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (nameEt.getText().toString().length() == 0) {
                    iv_delName.setVisibility(View.INVISIBLE);
                } else {
                    iv_delName.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (passwordEt.getText().toString().length() == 0) {
                    iv_delPwd.setVisibility(View.INVISIBLE);
                } else {
                    iv_delPwd.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    //登录按钮的判断方法
    private boolean veryfication() {
        name = nameEt.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            nameEt.setError(getString(R.string.enterAccount));
            return false;
        }
        password = passwordEt.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            passwordEt.setError(getString(R.string.pleaseEnterpwd));
            return false;
        }
        if (password.length() < 6) {
            passwordEt.setError(getString(R.string.enterMoreSixNumber));
            return false;
        }
        return true;
    }

    //登录按钮
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                if (veryfication()) {
//                    final LoadingDialog loadingDialog = new LoadingDialog(this, "正在登录...", R.mipmap.ic_dialog_loading);
//                    loadingDialog.show();
                    UserBean user = new UserBean();
                    user.setKeepInfo(keepPassword.isChecked());
                    user.setT_code(nameEt.getText().toString().trim());
                    user.setUsername(nameEt.getText().toString().trim());
                    user.setPassword(passwordEt.getText().toString().trim());

                    if (user != null) {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }
//                    x.http().post(RequestParamUtil.getLoginInfoParams(name, password), new Callback.CommonCallback<String>() {
//
//                        private String userInfo;
//
//                        @Override
//                        public void onSuccess(String result) {
//                            Log.i("--result", "--" + result);
//                            try {
//                                JSONObject jsonObject = new JSONObject(result);
//                                if (jsonObject.getBoolean("success")) {
//                                    userInfo = jsonObject.getString("user");
//                                    Gson gson = new Gson();
//                                    UserBean user = gson.fromJson(userInfo, UserBean.class);
//                                    user.setKeepInfo(keepPassword.isChecked());
//                                    user.setT_code(nameEt.getText().toString().trim());
//                                    if (user != null) {
//                                    putUser(user);
//                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                    finish();
//                                    }
//                                } else {
//                                    Toast.makeText(LoginActivity.this,"连接失败...", Toast.LENGTH_SHORT).show();
//
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        public void onError(Throwable ex, boolean isOnCallback) {
//                            Toast.makeText(LoginActivity.this,"服务器连接失败...", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onCancelled(CancelledException cex) {
//                        }
//
//                        @Override
//                        public void onFinished() {
//                            loadingDialog.dismiss();
//                        }
//                    });
                }
                break;
        }
    }

    //安卓app常用方法 按两下后退 退出app
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showToast(getString(R.string.pressOutAPP));
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
        }
        return false;
    }

    //用户信息
    public void putUser(UserBean user) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(user);
        SpUtil.putString(this, "user", jsonStr);
    }

    public UserBean getUser() {
        String jsonStr = SpUtil.getString(this, "user");
        Gson gson = new Gson();
        UserBean user = gson.fromJson(jsonStr, UserBean.class);
        return user;
    }
}
