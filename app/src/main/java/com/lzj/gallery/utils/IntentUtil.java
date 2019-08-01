package com.lzj.gallery.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 常用跳转
 * 可携带数据
 */

public class IntentUtil {

    public static void IntenToActivity(Activity thisActivity, Class toActivity){
        Intent intent = new Intent(thisActivity,toActivity);
        thisActivity.startActivity(intent);
    }

    public static void IntenToActivityWithBundle(Activity thisActivity, Class toActivity, Bundle bundle){
        Intent intent = new Intent(thisActivity,toActivity);
        if(bundle != null) intent.putExtras(bundle);
        thisActivity.startActivity(intent);
    }

    public static void IntenToActivityResult(Activity thisActivity, Class toActivity, int requstCode){
        Intent intent = new Intent(thisActivity,toActivity);
        thisActivity.startActivityForResult(intent,requstCode);
    }

    public static void IntenToActivityResultWithBundle(Activity thisActivity, Class toActivity, int requstCode, Bundle bundle){
        Intent intent = new Intent(thisActivity,toActivity);
        intent.putExtras(bundle);
        thisActivity.startActivityForResult(intent,requstCode);
    }

    public static void IntentFinishActivityResult(Activity activity, Bundle bundle){
        Intent intent = new Intent();
        intent.putExtras(bundle);
        activity.setResult(activity.RESULT_OK,intent);
        activity.finish();
    }

}
