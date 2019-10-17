package hxz.www.commonbase.util.qr;

import android.graphics.Bitmap;

/**
 * Created by guoleiqiu
 * on 2017/12/22 15:35.
 */

public interface QREncodeCallback {
    void onQREncodeSucc(Bitmap bitmap);
    void onQREncodeError();
}
