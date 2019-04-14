package com.example.reciteword.utils;

import android.text.TextUtils;


public class YuyinUtils {

	/**
	 * 反转字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseStr(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

//	public static void speak(String clickText) {
//		speak(clickText, null);
//	}
//
//	public static void speak(String clickText, MyApplication.OnSpeechFinishListener finishListener) {
//		// 需要合成的文本text的长度不能超过1024个GBK字节。
//		System.out.println("传入单词" + clickText);
//		if (TextUtils.isEmpty(clickText)) {
//			clickText = "Hello world";
//			// textView.setText(text);
//		}
//		MyApplication.speak(clickText, finishListener);
//	}
}
