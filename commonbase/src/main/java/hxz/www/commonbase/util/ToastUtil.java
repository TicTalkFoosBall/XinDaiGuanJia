package hxz.www.commonbase.util;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xingxiu.frame.R;
import com.xingxiu.frame.app.BaseApplication;

/**
 * Created by Circle on 2019-07-02
 */
public class ToastUtil {
    private static Toast mToast;

    public static void show(CharSequence text) {
        if (TextUtils.isEmpty(text))
            return;
        try {
            if (mToast != null) {
                mToast.cancel();
            }
            mToast = new Toast(BaseApplication.getInstance());
            LayoutInflater inflate = (LayoutInflater) BaseApplication.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflate.inflate(R.layout.layout_toast, null);
            TextView tvTip = view.findViewById(R.id.tv_tip);
            tvTip.setText(text);
            mToast.setView(view);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        } catch (Exception e) {

        }

    }

    public static void show(@StringRes int strResId) {
        show(BaseApplication.getInstance().getResources().getString(strResId));
    }

    public static void showImage(@DrawableRes int resId) {
        showImageText(resId, "");
    }

    public static void showImage(@DrawableRes int resId, @StringRes int strResId) {
        showImageText(resId, BaseApplication.getInstance().getString(strResId));
    }

    public static void showImageText(@DrawableRes int resId, CharSequence text) {
        try {
            if (mToast != null) {
                mToast.cancel();
            }
            mToast = new Toast(BaseApplication.getInstance());
            LayoutInflater inflate = (LayoutInflater) BaseApplication.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflate.inflate(R.layout.layout_toast_image, null);
            if (TextUtils.isEmpty(text)) {
                view.findViewById(R.id.relTipText).setVisibility(View.GONE);
                ImageView ivTip = view.findViewById(R.id.iv_tip);
                ivTip.setVisibility(View.VISIBLE);
                ivTip.setImageResource(resId);
            } else {
                view.findViewById(R.id.iv_tip).setVisibility(View.GONE);
                view.findViewById(R.id.relTipText).setVisibility(View.VISIBLE);
                ImageView ivTip = view.findViewById(R.id.iv_tip_text);
                TextView tvTip = view.findViewById(R.id.tv_tip);
                ivTip.setImageResource(resId);
                tvTip.setText(text);
            }

            mToast.setView(view);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        } catch (Exception e) {

        }
    }
}
