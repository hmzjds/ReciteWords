package com.example.reciteword.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.List;

/**
 * Created by android_home on 2018/9/6.
 */

public class JsonUtil {
    private String json;

    public static JsonUtil init(String json) {

        return new JsonUtil(json);
    }

    private JsonUtil(String json) {
        json = json.replace("NOIMAGE", "");
        this.json = json;
    }

//    public List<Symbols> parseSymbols() {
//        Gson gson = new Gson();
//        List<Symbols> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<Symbols>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public User parseUser() {
//        if (TextUtils.isEmpty(json)) {
//            return null;
//        }
//        Gson gson = new Gson();
//        User user = gson.fromJson(json, User.class);
//        return user;
//    }
//
//    public List<MovieInfo> parseMovieInfos() {
//        Gson gson = new Gson();
//        List<MovieInfo> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<MovieInfo>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ClassInfo> parseClassInfos() {
//        Gson gson = new Gson();
//        List<ClassInfo> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<ClassInfo>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<DynamicInfo> parseDynamicInfos() {
//        Gson gson = new Gson();
//        List<DynamicInfo> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<DynamicInfo>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<Top5Info.WordGroupTopFiveBean> parseScentenceInfos() {
//        Gson gson = new Gson();
//        List<Top5Info.WordGroupTopFiveBean> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<Top5Info.WordGroupTopFiveBean>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<Top5Info.WordTopFiveBean> parseWordInfos() {
//        Gson gson = new Gson();
//        List<Top5Info.WordTopFiveBean> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<Top5Info.WordTopFiveBean>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<PersonalDataInfo> parsePersonalDataInfos() {
//        Gson gson = new Gson();
//        List<PersonalDataInfo> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<PersonalDataInfo>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ManageDataInfo> parseManagementDataInfos() {
//        Gson gson = new Gson();
//        List<ManageDataInfo> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<ManageDataInfo>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public List<StarNum> parseStarInfos() {
//        Gson gson = new Gson();
//        List<StarNum> list = null;
//        try {
//            list = gson.fromJson(json, new TypeToken<List<StarNum>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

}
