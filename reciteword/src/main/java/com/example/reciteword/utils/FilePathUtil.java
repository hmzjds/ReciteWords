package com.example.reciteword.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by android_home on 2018/9/3.
 */

public class FilePathUtil {

    //https://pro.modao.cc/app/R2i5IYjC2tP6Kei16urwYZkDWwVxsNJ#screen=sA22B81744C1529374254154
    /**
     * 文件目录
     */
    public static final String SDPATH = Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/";
    public static final String DIR = "FQEnglish/";

    public static final String FILM_DIR = SDPATH + DIR + "Film/";
    public static final String MANAGEMENT_DIR = SDPATH + DIR + "Management/";
    public static final String RECORD_FILE = SDPATH + DIR + "RecordFile/";
    public static final String WORD = SDPATH + DIR + "Word/";

    public static final String LEVEL_1_DIR = SDPATH + DIR + "level1/";
    public static final String LEVEL_2_DIR = SDPATH + DIR + "level2/";
    public static final String LEVEL_3_DIR = SDPATH + DIR + "level3/";
    public static final String LEVEL_4_DIR = SDPATH + DIR + "level4/";
    public static final String LEVEL_5_DIR = SDPATH + DIR + "level5/";
    public static final String LEVEL_6_DIR = SDPATH + DIR + "level6/";

    public static final String FILM_DESCRIPTION_DIR = "About the film";

    public static final String CULTURE_DIR = "About the culture";

    public static final String CHARACTERS_DIR = "About the characters";

    public static final String READY_GO_DIR = "Ready Go";

    public static final String LETS_CREATE = "Let's create";

    public static final String LETS_DUB = "Let's dub";

    public static final String LETS_THINK = "Let's think";

    public static final String LETS_LEARN = "Let's learn";

    public static final String UNIT_IMG_DIR = "unit img";

    public static final String NEW_WORDS = "New  Words";
    public static final String DIALOGUE = "Dialogue";
    public static final String SONG = "Song";

    public static final String DESCRIPTION = "description.txt";
    public static final String POSTER_NAME1 = "poster1.PNG";
    public static final String POSTER_NAME2 = "poster2.PNG";

    public static final String SCENE_VIDEO_NAME = "scene.mp4";
    public static final String SCENE_SUBTITLE_NAME = "scene.srt";
    public static final String SCENE_SEEK_TO_TIME = "scene.txt";

    public static final String SONG_VIDEO_NAME = "song.mp4";
    public static final String SONG_SUBTITLE_NAME = "song.srt";

    public static final String WORD_TXT="word.txt";

    /**
     * Dub模块下,角色头像文件名
     */
    public static final String LEARN_ROLE_HEADFACE = "role.PNG";
    public static  final String LEARN_ROLE_NAME="dub.txt";

    public static final String THINK_QUES_NAME = "think.txt";
    /**
     * 保存画图的文件名分隔符
     */
    public static final String nameSeparator = "_";
    /**
     * 记录操作流水的txt文件
     */
    public static final String RECORD_FILE_NAME = "record.txt";

   /* *//**
     * 海报图片名
     *//*

    public static final String MOVIE_POSTER_NAME3 = "poster3.PNG";
    *//**
     * 简介文件名
     *//*
    public static final String MOVIE_DESCRIPTION = "description.txt";
    *//**
     * 人物介绍文件名
     *//*
    public static final String CHARACTER_INTRODUCTION_NAME = "description.txt";
    */

    /**
     * 人物海报文件名
     *//*
    public static final String CHARACTER_POSTER_NAME1 = "poster1.PNG";
    public static final String CHARACTER_POSTER_NAME2 = "poster2.PNG";
    public static final String CHARACTER_POSTER_NAME3 = "poster3.PNG";*/
    private static void create(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void init() {
        create(LEVEL_1_DIR);
        create(LEVEL_2_DIR);
        create(LEVEL_3_DIR);
        create(LEVEL_4_DIR);
        create(LEVEL_5_DIR);
        create(LEVEL_6_DIR);
        create(FILM_DIR);
        create(MANAGEMENT_DIR);
        create(RECORD_FILE);
        create(WORD);
    }

    public static File getDir(String path) {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            return dir;
        }
        return null;
    }

}
