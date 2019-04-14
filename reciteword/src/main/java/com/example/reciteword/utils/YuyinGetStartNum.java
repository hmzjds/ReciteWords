package com.example.reciteword.utils;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by android_home on 2018/10/30.
 */

public class YuyinGetStartNum {

    public static int getStarNum(String originResult, String finalResult) {
        int num = 0;
        long correctNum = 0;
        String[] orginArray = originResult.split(" ");
        String[] resultArray = finalResult.split(" ");
        for (int i = 0; i < resultArray.length; i++) {
            String result = resultArray[i].trim();
            for (int j = 0; j < orginArray.length; j++) {
                if (result.equals(orginArray[j].trim())) {
                    correctNum++;
                    break;
                }
            }
        }
        String str = String.valueOf(orginArray.length);
        long data = Long.parseLong(str);
        num = (int) (correctNum * 1.0f / data * 100);
        return num;
    }

    public static int getStar(int num) {
        int star = 0;
        if (num >= 0 && num < 30) {
            star = 1;
        } else if (num >= 30 && num < 60) {
            star = 2;
        } else if(num >= 60){
            star = 3;
        }
        return star;
    }
}
