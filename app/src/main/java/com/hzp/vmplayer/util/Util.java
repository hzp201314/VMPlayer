package com.hzp.vmplayer.util;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;

import com.hzp.vmplayer.bean.MusicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wschun on 2016/9/30.
 */

public class Util {
    private static final String TAG ="Util" ;

    public static void printCursor(Cursor cursor){
        if (cursor==null)
            return;

        Log.i(TAG, "printCursor: 条目个数"+cursor.getCount());


        while (cursor.moveToNext()){
            Log.i(TAG, "==============================================");
            int columnCount = cursor.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String value=cursor.getString(i);
                String name=cursor.getColumnName(i);
                Log.i(TAG, "printCursor: name="+name+";value="+value);
            }
        }

    }

   public static String formatName(String name){
       if (!TextUtils.isEmpty(name)){
           int i = name.indexOf(".");
           String newName=name.substring(0,i);
           return newName;
       }
       return "";
   }

    public static List<MusicBean> getMusicList(Cursor cursor) {
        List<MusicBean> musicBeanList=new ArrayList<>();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()){
            MusicBean musicBean = MusicBean.fromCursor(cursor);
            musicBeanList.add(musicBean);
        }


        return musicBeanList;
    }

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        int width = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
        return width;
    }
    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        int height = ((Activity) context).getWindowManager().getDefaultDisplay().getHeight();
        return height;
    }

    public static String getSystemversion(){
        return android.os.Build.VERSION.RELEASE;
    }
    public static String getPhoneModel(){
        return android.os.Build.MODEL;
    }

    public static String formatDuration(long duration) {
        int HOUR = 60 * 60 * 1000;//xiaosh
        int MINUTE = 60 * 1000;//分钟
        int SECOND = 1000;//秒
        //计算小时
        int hour = (int) (duration / HOUR);
        long remain = duration % HOUR;
        //计算分钟
        int minute = (int) (remain / MINUTE);
        remain = remain % MINUTE;
        //计算秒
        int second = (int) (remain / SECOND);

        if (hour==0){
            return  String.format("%02d:%02d",minute,second);
        }else {
            return  String.format("%02d:%02d:%02d",hour,minute,second);
        }
    }

    /**
     *
     * @param picH 图片的高度
     * @param picW 图片的宽度
     * @param context
     * @return 计算出来的图片控件宽高，x 为宽度，y 为高度
     */
    public static Point computeImgSize(int picW, int picH, Context context){
        int imgW = getScreenWidth(context);
        int imgH = picH * imgW / picW;
        return new Point(imgW,imgH);
    }
}
