package com.example.reciteword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.reciteword.utils.RequestParamUtil;

import org.xutils.http.RequestParams;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        RequestParams admin = RequestParamUtil.getLoginInfoParams("admin", "123456");
//        Log.i(TAG, admin.toString());
    }
}
