package com.ufo.utils;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Vibrator;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by tjpld on 2016/11/17.
 */

public class DeviceUtils {
    //复制
    public static void copyText(String text, Context context) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        ClipData textCd = ClipData.newPlainText("text", text);
        clipboard.setPrimaryClip(textCd);
    }

    //震动
    public static void vibrator(Context context) {
        Vibrator vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);

        long[] pattern = {0, 1};
        vib.vibrate(pattern, -1);
    }
}
