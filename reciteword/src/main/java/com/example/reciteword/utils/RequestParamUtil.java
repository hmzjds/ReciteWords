package com.example.reciteword.utils;

import android.util.Log;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

/**
 * Created by android_home on 2018/9/6.
 * http://192.168.1.192:30014/fuqiangyingyu/api.html
 */

public class RequestParamUtil {
    //http://192.168.1.192:30014/fuqiangyingyu/app/getUerClass.action
//            public static final String IP = "http://192.168.1.192:30014/fuqiangyingyu/app/";//测试地址
    public static final String IP = "http://118.31.11.36:8181/fuqiangyingyu/app/";//外网地址
    //  外网地址
    //    public static final String IP = "http://118.31.11.36:8181/fuqiangyingyu/app/";//外网

    /**
     * 登录参数
     *
     * @param loginName
     * @param password
     * @return RequestParams
     */
    public static RequestParams getLoginInfoParams(String loginName,
                                                   String password) {
        RequestParams params = new RequestParams(IP + "login.action");
        params.addBodyParameter("loginName", loginName);
        params.addBodyParameter("password", password);
        return params;
    }

    public static RequestParams getMovieListParams(String videoType, String page, String size) {
        RequestParams params = new RequestParams(IP + "videoList.action");
        params.addBodyParameter("videoType", videoType);
        params.addBodyParameter("page", page);
        params.addBodyParameter("size", size);
        return params;
    }

    /**
     * 金山词霸接口
     *
     * @param word
     * @return
     */
    public static RequestParams getDictionaryParams(String word) {
        RequestParams params = new RequestParams("http://dict-co.iciba.com/api/dictionary.php?");
        params.addBodyParameter("w", word);
        params.addBodyParameter("type", "json");
        params.addBodyParameter("key", "14D883AE9C9A2E0208F92AF028F7A198");
        return params;
    }

    /**
     * 发布朋友圈
     * articleAdd.action
     */
    public static RequestParams getShareDynamicParams(String userId, String moduleId, String unitId,
                                                      String typeId, String content, String soundPath, String names) {
        RequestParams params = new RequestParams(IP + "articleAdd.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        params.addBodyParameter("typeId", typeId);
        params.addBodyParameter("title", "");
        params.addBodyParameter("content", content);
        params.setMultipart(true);
        params.addBodyParameter(names, new File(soundPath));
        return params;
    }

    /**
     * 获取班级列表
     */
    public static RequestParams getClassListParams() {
        RequestParams params = new RequestParams(IP + "getUerClass.action");
        return params;
    }

    /**
     * 获取朋友圈列表
     */
    public static RequestParams getDynamicListParams(String classId, String moduleId, String unitId, String typeId, String userId, String page, String size) {
        RequestParams params = new RequestParams(IP + "articleList.action");
        params.addBodyParameter("classId", classId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        params.addBodyParameter("typeId", typeId);
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("page", page);
        params.addBodyParameter("size", size);
        return params;
    }

    /**
     * 点赞
     */
    public static RequestParams getZanParams(String userId, String articleId) {
        RequestParams params = new RequestParams(IP + "articleLikeAdd.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("articleId", articleId);
        return params;
    }

    /**
     * 取消点赞
     */
    public static RequestParams getCancelZanParams(String userId, String articleId) {
        RequestParams params = new RequestParams(IP + "articleLikeRemove.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("articleId", articleId);
        return params;
    }

    /**
     * 添加评论
     */
    public static RequestParams getSendCommentParams(String userId, String articleId, String content) {
        RequestParams params = new RequestParams(IP + "commentAdd.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("articleId", articleId);
        params.addBodyParameter("content", content);
        return params;
    }

    /**
     * 删除朋友圈参数
     *
     * @param userId
     * @param articleId
     * @return RequestParams
     */
    public static RequestParams getDelDynamicParams(int userId, int articleId) {
        RequestParams params = new RequestParams(IP + "articleRemove.action");
        params.addBodyParameter("userId", String.valueOf(userId));
        params.addBodyParameter("articleId", String.valueOf(articleId));
        return params;
    }

    /**
     * 获取单词词组点击量
     */
    public static RequestParams getWordClickNumParams(String userId, String moduleId, String unitId, String type, String content) {
        RequestParams params = new RequestParams(IP + "addWordClick.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        params.addBodyParameter("type", type);
        params.addBodyParameter("content", content);
        return params;
    }

    /**
     * 获取单词词组点击量前五
     */
    public static RequestParams getTopFiveDataParams(String classId, String moduleId, String unitId) {
        RequestParams params = new RequestParams(IP + "getWordTopFive.action");
        params.addBodyParameter("classId", classId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        return params;
    }

    /**
     * 下载视频
     */
    public static RequestParams getMovieVideoParams(String videoId) {
        RequestParams params = new RequestParams(IP + "downloadVideoById.action");
        params.addBodyParameter("videoId", videoId);
        //        params.setSaveFilePath(FilePathUtil.FILM_DIR + videoName + ".mp4");
        return params;
    }

    /**
     * 个人数据列表
     */
    public static RequestParams getPersonalDataParams(String userId, String moduleId, String unitId) {
        RequestParams params = new RequestParams(IP + "getPersonalCompletion.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        return params;
    }

    public static RequestParams getCompletionDataParams(String classId) {
        RequestParams params = new RequestParams(IP + "getCompletion.action");
        params.addBodyParameter("classId", classId);
        return params;
    }

    public static RequestParams getDownloadExcelParams(String classId) {
        RequestParams params = new RequestParams(IP + "downloadExcel.action");
        params.addBodyParameter("classId", classId);
        return params;
    }

    public static RequestParams getRecordParams(String records) {
        RequestParams params = new RequestParams(IP + "addRecord.action");
        params.addBodyParameter("records", records);
        return params;
    }

    public static RequestParams getAddStarParams(String userId, String moduleId, String unitId, String content, String amount) {
        RequestParams params = new RequestParams(IP + "addStars.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        params.addBodyParameter("content", content);
        params.addBodyParameter("amount", amount);
        return params;
    }

    public static RequestParams getStarParams(String userId, String moduleId, String unitId) {
        RequestParams params = new RequestParams(IP + "getStars.action");
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("moduleId", moduleId);
        params.addBodyParameter("unitId", unitId);
        return params;
    }


    public static void submitData(String records) {
        x.http().post(RequestParamUtil.getRecordParams(records), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    boolean success = jsonObject.optBoolean("success");
                    if (success) {
                        Log.i("--sub success:", "-->>>>>>>>>>>>>>>>>>>");
                        FileUtil.deleteFile(FilePathUtil.RECORD_FILE + FilePathUtil.RECORD_FILE_NAME);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
