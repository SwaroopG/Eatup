package com.poorjar.commons;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Swaroop on 5/17/15.
 */
public class CommonUtilities {

    public static boolean isNetworkAvailable(final Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Log.e("isNetworkAvailable", "Network Available!");
            return true;
        }
        Log.e("isNetworkAvailable", "No Networks Available!");
        return false;
    }
}
