package hxz.www.commonbase.util.qr;

import android.graphics.Bitmap;

public interface QREncodeCallback {
    void onQREncodeSucc(Bitmap bitmap);
    void onQREncodeError();
}
