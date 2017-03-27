package com.xiahao.geek.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.xiahao.geek.app.App;
import com.xiahao.geek.app.Constants;


/**
 * Created by codeest on 16/8/31.
 */

public class SharedPreferenceUtil {


    private static final int DEFAULT_CURRENT_ITEM = Constants.TYPE_ZHIHU;

    private static final String SHAREDPREFERENCES_NAME = "my_sp";

    public static SharedPreferences getAppSp() {
        return App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

}
