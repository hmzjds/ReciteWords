package com.example.reciteword.utils;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SpUtil {

	public static final String SP_USER = "userSp";
	public static final String USE_NAME = "login_name";
	public static final String USE_PWD = "password";
	public static final String USER_ID = "user_id";
	public static final String CLASS_ID="class_id";
	public static final String SP_LOGIN = "loginSp";
	public static final String SP_POSITION = "positionSp";
	public static final String POSITION = "posiotion";
	

	public static final void saveComprehensionAnswer(Activity context, String content, int userId) {
		 context.getPreferences(Context.MODE_PRIVATE).edit().putString(userId + "", content).apply();
	}

	public static final String getComprehensionAnswer(Activity context, int userId) {
		return context.getPreferences(Context.MODE_PRIVATE).getString(userId + "", "");
	}

	public static final boolean saveStr(Context context, String spName, String userName, String userPwd,
			String userId, String classId) {
		return context.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putString(USE_NAME, userName)
				.putString(USE_PWD, userPwd).putString(USER_ID, userId).putString(CLASS_ID, classId).commit();
	}

	public static final boolean savePwd(Context context, String spName, String userPwd, String userId) {

		return context.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putString(USE_PWD, userPwd)
				.putString(USER_ID, userId).commit();
	}
	
	public static final boolean setPostion(Context context, String spName, String pos) {
		return context.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putString(POSITION, pos).commit();
	}

	public static final String getStr(Context context, String spName, String key, String defValue) {
		return context.getSharedPreferences(spName, Context.MODE_PRIVATE).getString(key, defValue);
	}

	public static final boolean setObject(Context context, String spName, Object object)
			throws IllegalAccessException, IllegalArgumentException {
		Editor editor = context.getSharedPreferences(spName, Context.MODE_PRIVATE).edit();
		Class<? extends Object> class1 = object.getClass();
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String type = field.getType().toString();
			if (type.endsWith("String")) {
				editor.putString(field.getName(), field.get(object).toString());
			} else if (type.endsWith("int") || type.endsWith("Integer")) {
				editor.putInt(field.getName(), field.getInt(object));
			} else if (type.endsWith("long") || type.endsWith("Long")) {
				editor.putLong(field.getName(), field.getLong(object));
			} else if (type.endsWith("float") || type.endsWith("Float")) {
				editor.putFloat(field.getName(), field.getFloat(object));
			} else if (type.endsWith("boolean") || type.endsWith("Boolean")) {
				editor.putBoolean(field.getName(), field.getBoolean(object));
			}

		}
		return editor.commit();
	}

	public static final <T extends Object> T getObject(Context context, String spName, Class<T> clazz) {
		SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
		T object = null;
		try {
			object = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				String type = field.getType().toString();
				if (type.endsWith("String")) {
					field.set(object, sp.getString(fieldName, ""));
				} else if (type.endsWith("int") || type.endsWith("Integer")) {
					field.setInt(object, sp.getInt(fieldName, Integer.valueOf(0)));
				} else if (type.endsWith("long") || type.endsWith("Long")) {
					field.setLong(object, sp.getLong(fieldName, 0));
				} else if (type.endsWith("float") || type.endsWith("Float")) {
					field.setFloat(object, sp.getFloat(fieldName, 0));
				} else if (type.endsWith("boolean") || type.endsWith("Boolean")) {
					field.setBoolean(object, sp.getBoolean(fieldName, false));
				}
			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	// public static final User getUser(Context context) {
	// return getObject(context, SP_USER, User.class);
	// }
	// public static final boolean setUser(Context context, User user) throws
	// IllegalAccessException, IllegalArgumentException {
	// return setObject(context, SP_USER, user);
	// }
	//
	public static final void setSocketToekn(Context context, String token) {
		context.getSharedPreferences(SP_USER, Context.MODE_WORLD_READABLE).edit().putString("token", token).commit();
	}

	public static final String getSocketToken(Context context) {
		return context.getSharedPreferences(SP_USER, Context.MODE_WORLD_READABLE | Context.MODE_MULTI_PROCESS)
				.getString("token", "");
	}

	public static boolean hasLogin(Context context) {
		return context.getSharedPreferences(SP_LOGIN, Context.MODE_PRIVATE).getBoolean("isLogin", false);
	}

	public static final boolean setLoginFlag(Context context, boolean login) {
		return context.getSharedPreferences(SP_LOGIN, Context.MODE_PRIVATE).edit().putBoolean("isLogin", login)
				.commit();
	}

}
