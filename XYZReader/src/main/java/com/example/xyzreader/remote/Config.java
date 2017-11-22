package com.example.xyzreader.remote;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

class Config {
    static final URL BASE_URL;
    static final String mDataSourceUdacity = "https://go.udacity.com/xyz-reader-json";
    static final String mDataSourceGithub = "https://raw.githubusercontent.com/TNTest/xyzreader/master/data.json";
    private static String TAG = Config.class.toString();

    static {
        URL url = null;
        try {
            url = new URL(mDataSourceGithub);
        } catch (MalformedURLException ignored) {
            // TODO: throw a real error
            Log.e(TAG, "Please check your internet connection. " + ignored);
        }

        BASE_URL = url;
    }
}
