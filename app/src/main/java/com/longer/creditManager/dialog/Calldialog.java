package com.longer.creditManager.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.longer.creditManager.R;

import hxz.www.commonbase.util.UiUtils;
import hxz.www.commonbase.view.BaseDialog;

public class Calldialog extends BaseDialog{

    TextView tv_nunber,tv_callout,tv_cancel;


    public Calldialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_call;
    }

    @Override
    protected void bindView() {
        tv_callout = findViewById(R.id.tv_callout);
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_nunber = findViewById(R.id.tv_number);

    }

    @Override
    protected void bindListener() {

    }


    @Override
    protected void intiAttrs(WindowManager.LayoutParams params, Window window, boolean isTransparent) {
        super.intiAttrs(params, window, isTransparent);


        params.gravity = Gravity.CENTER;
        params.width = UiUtils.dp2px(getContext(), 245);
        params.height = UiUtils.dp2px(getContext(),95);

    }

    @Override
    protected Drawable getBackDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#ffffff"));
        drawable.setCornerRadius(UiUtils.dp2px(getContext(), 10));
        return drawable;
    }


}
