package com.xiahao.geek.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by codeest on 2016/8/3.
 */
public class Constants {


    //================= TYPE ====================

    public static final int TYPE_ZHIHU = 101;

    public static final int TYPE_ANDROID = 102;

    public static final int TYPE_IOS = 103;

    public static final int TYPE_WEB = 104;

    public static final int TYPE_GIRL = 104;


    //================= PATH ====================

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";

    //================= INTENT ====================
    public static final String IT_GANK_TYPE = "type";

    public static final String IT_GANK_TYPE_CODE = "type_code";

}
