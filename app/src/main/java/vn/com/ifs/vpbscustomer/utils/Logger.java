package vn.com.ifs.vpbscustomer.utils;

import android.util.Log;

import static vn.com.ifs.vpbscustomer.utils.Config.IS_DEV_MODE;

/**
 * Created by mobileTeam1 on 3/22/2018.
 */

public class Logger {

    public static void e(String tag, String message) {
        if (IS_DEV_MODE)
            Log.e(tag, message);
    }

    public static void d(String tag, String message) {
        if (IS_DEV_MODE)
            Log.d(tag, message);
    }

    public static void i(String tag, String message) {
        if (IS_DEV_MODE)
            Log.i(tag, message);
    }
}
