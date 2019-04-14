package com.example.reciteword.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by android_home on 2018/9/3.
 */

public class FileUtil {

    public static List<String> getPictures(final String strPath) {
        List<String> list = new ArrayList<String>();
        File file = new File(strPath);
        File[] allfiles = file.listFiles();
        if (allfiles == null) {
            return null;
        }
        for (int i = 0; i < allfiles.length; i++) {
            final File fi = allfiles[i];
            if (fi.isFile()) {
                int idx = fi.getPath().lastIndexOf(".");
                if (idx <= 0) {
                    continue;
                }
                String suffix = fi.getPath().substring(idx);
                if (suffix.toLowerCase().equals(".jpg") || suffix.toLowerCase().equals(".jpeg")
                        || suffix.toLowerCase().equals(".bmp") || suffix.toLowerCase().equals(".png")
                        || suffix.toLowerCase().equals(".gif")) {
                    list.add(fi.getPath());
                    Collections.sort(list);
                }
            }
        }
        return list;
    }


    public static String readTxtFile(final String filePath) {
        final StringBuffer sb = new StringBuffer();
        //        new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "GBK");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    sb.append(lineTxt + "\r\n");
                }
                read.close();
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> readAllRoleName(File file) {
        List<String> list = new ArrayList<>();
        try {
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "GBK");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                read.close();
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param time
     * @return
     * @description 时间轴转换为毫秒
     * @version 1.0
     * @author xq
     * @update 2015年10月22日 下午1:25:10
     */
    private static int TimeToMs(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int mintue = Integer.parseInt(time.substring(3, 5));
        int scend = Integer.parseInt(time.substring(6, 8));
        int milli = Integer.parseInt(time.substring(9, 12));
        int msTime = (hour * 3600 + mintue * 60 + scend) * 1000 + milli;
        return msTime;
    }

    // 遍历文件夹中所有文件
    public static List<String> getFileName(String path) {
        File file = new File(path);
        ArrayList<String> list = new ArrayList<String>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory()) {
                    list.add(f.getName());
                }
            }
        }
        return list;
    }


    /**
     * 截取_后面的字符
     *
     * @param str
     */
    public static String interceptStr(String str) {
        String strName = "";
        int beginIndex = str.lastIndexOf("_") + 1;
        int endIndex = str.lastIndexOf(".");
        strName = str.substring(beginIndex, endIndex);
        return strName;
    }

    /**
     * 根据文件后缀筛选文件，返回文件名字数组
     *
     * @param dir    文件夹
     * @param suffix 后缀
     * @return
     */
    public static String[] listFileForSuffix(File dir, final String suffix) {
        String[] fileNames = {};
        if (dir.isDirectory()) {
            fileNames = dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    return filename.toUpperCase().endsWith(suffix.toUpperCase());
                }
            });

        }
        return fileNames;
    }


    // 遍历文件夹中所有文件目录
    public static ArrayList<File> listChildDirectory(String path) {
        File file = new File(path);
        ArrayList<File> list = new ArrayList<File>();
        if (file.exists()) {
            String[] strs = file.list();
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; i++) {
                File file2 = new File(path + "/" + strs[i]);
                if (file2.isDirectory()) {
                    list.add(file2);
                }
            }
        }
        return list;
    }

    /**
     * 获取应用专属缓存目录 android 4.4及以上系统不需要申请SD卡读写权限
     * 因此也不用考虑6.0系统动态申请SD卡读写权限问题，且随应用被卸载后自动清空 不会污染用户存储空间
     *
     * @param context 上下文
     * @param type    文件夹类型 可以为空，为空则返回API得到的一级目录
     * @return 缓存文件夹 如果没有SD卡或SD卡有问题则返回内存缓存目录，否则优先返回SD卡缓存目录
     */
    public static File getCacheDirectory(Context context, String type) {
        File appCacheDir = getExternalCacheDirectory(context, type);
        if (appCacheDir == null) {
            appCacheDir = getInternalCacheDirectory(context, type);
        }

        if (appCacheDir == null) {
            Log.e("getCacheDirectory", "getCacheDirectory fail ,the reason is mobile phone unknown exception !");
        } else {
            if (!appCacheDir.exists() && !appCacheDir.mkdirs()) {
                Log.e("getCacheDirectory", "getCacheDirectory fail ,the reason is make directory fail !");
            }
        }
        return appCacheDir;
    }

    /**
     * 获取SD卡缓存目录
     *
     * @param context 上下文
     * @param type    文件夹类型 如果为空则返回
     *                /storage/emulated/0/Android/data/app_package_name/cache
     *                否则返回对应类型的文件夹如Environment.DIRECTORY_PICTURES 对应的文件夹为
     *                .../data/app_package_name/files/Pictures
     *                {@link Environment#DIRECTORY_MUSIC},
     *                {@link Environment#DIRECTORY_PODCASTS},
     *                {@link Environment#DIRECTORY_RINGTONES},
     *                {@link Environment#DIRECTORY_ALARMS},
     *                {@link Environment#DIRECTORY_NOTIFICATIONS},
     *                {@link Environment#DIRECTORY_PICTURES}, or
     *                {@link Environment#DIRECTORY_MOVIES}.or 自定义文件夹名称
     * @return 缓存目录文件夹 或 null（无SD卡或SD卡挂载失败）
     */
    public static File getExternalCacheDirectory(Context context, String type) {
        File appCacheDir = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            if (TextUtils.isEmpty(type)) {
                appCacheDir = context.getExternalCacheDir();
            } else {
                appCacheDir = context.getExternalFilesDir(type);
            }

            if (appCacheDir == null) {// 有些手机需要通过自定义目录
                appCacheDir = new File(Environment.getExternalStorageDirectory(),
                        "Android/data/" + context.getPackageName() + "/cache/" + type);
            }

            if (appCacheDir == null) {
                Log.e("getExternalDirectory", "getExternalDirectory fail ,the reason is sdCard unknown exception !");
            } else {
                if (!appCacheDir.exists() && !appCacheDir.mkdirs()) {
                    Log.e("getExternalDirectory", "getExternalDirectory fail ,the reason is make directory fail !");
                }
            }
        } else {
            Log.e("getExternalDirectory",
                    "getExternalDirectory fail ,the reason is sdCard nonexistence or sdCard mount fail !");
        }
        return appCacheDir;
    }

    /**
     * 获取内存缓存目录
     *
     * @param type 子目录，可以为空，为空直接返回一级目录
     * @return 缓存目录文件夹 或 null（创建目录文件失败） 注：该方法获取的目录是能供当前应用自己使用，外部应用没有读写权限，如
     * 系统相机应用
     */
    public static File getInternalCacheDirectory(Context context, String type) {
        File appCacheDir = null;
        if (TextUtils.isEmpty(type)) {
            appCacheDir = context.getCacheDir();// /data/data/app_package_name/cache
        } else {
            appCacheDir = new File(context.getFilesDir(), type);// /data/data/app_package_name/files/type
        }

        if (!appCacheDir.exists() && !appCacheDir.mkdirs()) {
            Log.e("getInternalDirectory", "getInternalDirectory fail ,the reason is make directory fail !");
        }
        return appCacheDir;
    }

    public static String getPcmFileAbsolutePath(String filePath, String fileName) {
        File dir = new File(filePath, "pcm");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, fileName).getAbsolutePath();
    }

    public static String getWavFileAbsolutePath(String path, String fileName) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, fileName).getAbsolutePath();
    }


    /**
     * 根据文件开头筛选文件，返回文件名字数组
     *
     * @param dir    文件夹
     * @param prefix 前缀
     * @return
     */
    public static String[] listFileforStart(File dir, final String prefix) {
        String[] fileNames = {};
        if (dir.isDirectory()) {
            fileNames = dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    return filename.toUpperCase().startsWith(prefix.toUpperCase());
                }
            });
        }
        return fileNames;
    }

    public static void writeDataToTxt(Context context, String userId, String moduleName, String moduleId, String unitId,
                                      String type, String shijianchuo, String number) {
        StringBuffer stringBuffer = new StringBuffer().append(userId + "#").append(moduleName + "#").append(moduleId + "#").
                append(unitId + "#").append(type + "#")
                .append(shijianchuo + "#").append(number).append("\r\n");
        String data = stringBuffer.toString();
        File file = new File(FilePathUtil.RECORD_FILE + FilePathUtil.RECORD_FILE_NAME);
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    FileWriter fileWriter = new FileWriter(file, true);
                    bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(data);
                } else {
                    Log.i("--create file failed:", "--文件创建失败");
                }
            } else {
                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param path 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

//    public static List<RecordInfo> readRecordInfos(Context context) {
//        File file = new File(FilePathUtil.RECORD_FILE + FilePathUtil.RECORD_FILE_NAME);
//        List<RecordInfo> recordInfos = new ArrayList<RecordInfo>();
//        if (file.isFile() && file.exists()) {
//            try {
//                InputStreamReader reader = new InputStreamReader(
//                        new FileInputStream(file), "GBK");
//                BufferedReader bufferedReader = new BufferedReader(reader);
//                String line = null;
//                while ((line = bufferedReader.readLine()) != null) {
//                    String[] info = line.split("#");
//                    RecordInfo recordInfo = new RecordInfo();
//                    recordInfo.setUserId(Integer.parseInt(info[0]));
//                    recordInfo.setModuleName(info[1]);
//                    recordInfo.setModuleId(Integer.parseInt(info[2]));
//                    recordInfo.setUnitId(Integer.parseInt(info[3]));
//                    recordInfo.setType(Integer.parseInt(info[4]));
//                    recordInfo.setShijianchuo(info[5]);
//                    recordInfo.setNumber(Integer.parseInt(info[6]));
//                    recordInfos.add(recordInfo);
//                }
//            } catch (Exception e) {
//                // TODO: handle exception
//            }
//        }
//        return recordInfos;
//    }

}
