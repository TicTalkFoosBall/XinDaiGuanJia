package hxz.www.commonbase.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.ByteArrayOutputStream;

public class BitmapUtil {

    /**
     * 获取分享Bitmap
     *
     * @param bitmap
     * @return
     */
    public static Bitmap getShareBitmap(Bitmap bitmap) {
        try {
            byte[] bytes = bitmap2Bytes(bitmap, 32);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        } catch (Exception e) {

        }
        return bitmap;
    }


    /**
     * 获取分享Bitmap
     *
     * @param bitmap
     * @return
     */
    public static Bitmap getSaceFaceBitmap(Bitmap bitmap) {
        try {
            byte[] bytes = bitmap2Bytes(bitmap, 800);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;//必须设置为565，否则无法检测
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        } catch (Exception e) {

        }
        return bitmap;
    }

    /**
     * Bitmap转换成byte[]并且进行压缩,压缩到不大于maxkb
     *
     * @param bitmap
     * @return
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap, int maxkb) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
        int options = 100;
        while (output.toByteArray().length > maxkb && options > 10) {
            output.reset(); //清空output
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, output);//这里压缩options%，把压缩后的数据存放到output中
            options -= 5;
        }
        return output.toByteArray();
    }


    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }


    /**
     * 等比例缩放图片
     */
    public static Bitmap zoomBitmap(Bitmap bm, float scaleSize) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(scaleSize, scaleSize);
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }

    /**
     * 等比例缩放图片
     */
    public static Bitmap zoomBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }

    /**
     * 从获取缓存的图片
     *
     * @param context
     * @param url
     * @return
     */
    public static Bitmap getBitmap(Context context, String url) {
        return getBitmap(context, url, Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }


    public static Bitmap getBitmap(final Context context, final String url, final int width, final int height) {
        Bitmap bitmap = null;
        try {
            Drawable drawable = Glide.with(context).load(url).into(width, height).get();
            if (drawable != null) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                Glide.with(context).load(url).preload(width, height);
            }
        } catch (Exception e) {
        }
        return bitmap;
    }
}
