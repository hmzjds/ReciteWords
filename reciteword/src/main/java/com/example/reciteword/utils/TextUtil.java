package com.example.reciteword.utils;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by android_home on 2018/9/6.
 */

public class TextUtil {

    /**
     * 截取||后面的字幕
     *
     * @param str
     * @return
     */
    public static String cutoutStrLatter(String str) {
        if (str != null) {
            String strName = "";
            int beginIndex = str.lastIndexOf("||") + 2;
            strName = str.substring(beginIndex, str.length());
            return strName;
        }
        return str;
    }

    /**
     * 截取||前面角色名字
     *
     * @param str
     * @return
     */
    public static String cutoutStrFront(String str) {
        String strName = "";
        int endIndex = str.lastIndexOf("||");
        strName = str.substring(0, endIndex);
        return strName;
    }


    public static String trimPunctuation(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char punct[] = {',', '.', '!', '?', ';', '，', '。', '！', '？', '；', '、', '~', '.', '…'};
            boolean need_filter = false;
            for (int j = 0; j < punct.length; ++j) {
                if (punct[j] == str.charAt(i)) {
                    need_filter = true;
                    break;
                }
            }
            if (!need_filter) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static String getName(String url) {
        int index = url.lastIndexOf("_");
        int lastIndex = url.lastIndexOf(".");
        String name = url.substring(index + 1, lastIndex);
        return name;
    }

    public static String getFrontName(String url) {
        int lastIndex = url.lastIndexOf("_");
        String name = url.substring(0, lastIndex);
        return name;
    }

    public static String getPcmName(String url) {
        int lastIndex = url.lastIndexOf(".");
        String name = url.substring(0, lastIndex);
        return name;
    }


    public static String getNum(String num) {
        int index = num.lastIndexOf(".");
        String data = num.substring(index + 1);
        return data;
    }

    public static String getRecordName(String name) {
        int lastIndex = name.indexOf("_");
        String title = name.substring(lastIndex + 1, name.length());
        return title;

    }

    public static String getLevelNum(String level) {
        String levelId = "";
        if (level.equals("level1")) {
            levelId = "1";
        } else if (level.equals("level2")) {
            levelId = "2";
        } else if (level.equals("level3")) {
            levelId = "3";
        } else if (level.equals("level4")) {
            levelId = "4";
        } else if (level.equals("level5")) {
            levelId = "5";
        } else {
            levelId = "6";
        }
        return levelId;
    }

    public static String getUnitNum(String unit) {
        String unitId = "";
        if (unit.equals("unit 1")) {
            unitId = "1";
        } else if (unit.equals("unit 2")) {
            unitId = "2";
        } else if (unit.equals("unit 3")) {
            unitId = "3";
        } else if (unit.equals("unit 4")) {
            unitId = "4";
        } else if (unit.equals("unit 5")) {
            unitId = "5";
        } else if (unit.equals("unit 6")) {
            unitId = "6";
        } else if (unit.equals("unit 7")) {
            unitId = "7";
        } else {
            unitId = "8";
        }
        return unitId;
    }

}
