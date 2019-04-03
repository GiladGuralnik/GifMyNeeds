package com.gifmyneeds.utilities;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

public class GifMyNeedsApplication extends Application {

    private static WeakReference<Context> context;

    public void onCreate() {
        super.onCreate();
        GifMyNeedsApplication.context = new WeakReference<Context>(this);
    }

    public static Context getAppContext() {
        return GifMyNeedsApplication.context.get();
    }
}
