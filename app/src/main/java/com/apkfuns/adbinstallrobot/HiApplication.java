package com.apkfuns.adbinstallrobot;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengwei on 2017/6/16.
 */

public class HiApplication extends Application {

    public static List<String> packageList = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        List<PackageInfo> list = getPackageManager().getInstalledPackages(0);
        for (PackageInfo info : list) {
            packageList.add(info.packageName);
        }
    }
}
