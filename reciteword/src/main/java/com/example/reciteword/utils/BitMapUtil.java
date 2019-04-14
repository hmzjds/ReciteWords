package com.example.reciteword.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by android_home on 2018/11/28.
 */

public class BitMapUtil {
    // 饿汉式
    private static BitMapUtil instance = new BitMapUtil();

    private BitMapUtil(){}

    public static BitMapUtil getInstance(){
        return instance;
    }

    /*
    *    get image from network
    *    @param [String]imageURL
    *    @return [BitMap]image
    */
    public Bitmap returnBitMap(String url){
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
