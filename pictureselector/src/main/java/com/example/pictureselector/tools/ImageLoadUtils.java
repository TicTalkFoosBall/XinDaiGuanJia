package com.example.pictureselector.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * @Author :rickBei
 * @Date :2019/9/26 11:49
 * @Descripe: From bug to bugs
 **/
public class ImageLoadUtils {

    public static Bitmap createBitmap(ImageView img,Integer res) {
        InputStream is = img.getResources().openRawResource(res);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        Bitmap btp = BitmapFactory.decodeStream(is, null, options);
        return btp;

    }
}
