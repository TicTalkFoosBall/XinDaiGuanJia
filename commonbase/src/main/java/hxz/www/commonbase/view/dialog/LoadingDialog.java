package hxz.www.commonbase.view.dialog;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import hxz.www.commonbase.R;


/**
 * Created by Circle on 2019-07-02
 */
public class LoadingDialog {
    private Dialog mDialog;

    private static volatile LoadingDialog mInstance;

    public static LoadingDialog getInstance() {
        if (mInstance == null) {
            synchronized (LoadingDialog.class) {
                if (mInstance == null) {
                    mInstance = new LoadingDialog();
                }
            }
        }
        return mInstance;
    }


    public void showUpload(Context context) {
        show(context, "上传中...");
    }

    public void showWate(Context context) {
        show(context, "请稍等...");
    }

    public void show(Context context) {
        show(context, "", false);
    }

    public void show(Context context, String tip) {
        show(context, tip, false);
    }

    public void show(Context context, boolean cancelable) {
        show(context, "", cancelable);
    }

    public void show(Context context, String msg, boolean cancelable) {
        View view = View.inflate(context, R.layout.dialog_loading, null);

        TextView tvMsg = view.findViewById(R.id.tv_msg);

        if (TextUtils.isEmpty(msg)) {
            tvMsg.setText(R.string.loading);
        } else {
            tvMsg.setText(msg);
        }

        mDialog = new Dialog(context, R.style.Dialog_Transparent);
        mDialog.setContentView(view);
        mDialog.setCanceledOnTouchOutside(cancelable);
        mDialog.getWindow().setGravity(Gravity.CENTER);
        mDialog.show();
    }

//    public static void loadDrawable(SimpleDraweeView draweeView, @DrawableRes int resId) {
////        AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
////                .setUri(Uri.parse("res://" + BaseApplication.getInstance().getPackageName() + "/" + R.drawable.loading_white))
////                .setControllerListener(controllerListener1)
////                .build();
////        ivMove.setController(build1);
//
//        Uri uri = Uri.parse(StringimageTranslateUri(draweeView.getContext(), resId));
//        DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(uri).setAutoPlayAnimations(true).setOldController(draweeView.getController()).build();
//        draweeView.setController(controller);
//    }

    public static String StringimageTranslateUri(Context context, int resId) {
        Resources r = context.getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + r.getResourcePackageName(resId) + "/" +
                r.getResourceTypeName(resId) + "/" + r.getResourceEntryName(resId));
        return uri.toString();
    }


    public void dismiss() {
        try {//--activity被销毁 调用了此方法 会崩溃
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.cancel();
                mDialog = null;
            }
        } catch (Exception ignored) {

        }
        mInstance = null;
    }

}
