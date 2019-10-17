package com.longer.creditManager.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.longer.creditManager.R;
import com.longer.creditManager.activity.GuaranteeBusinessActivity;

import hxz.www.commonbase.util.UiUtils;
import hxz.www.commonbase.view.BaseDialog;

public class Businesslinesdialog extends BaseDialog {

    private TextView tv1,tv2; // 担保业务,信贷业务


    public Businesslinesdialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_businesschoice;
    }

    @Override
    protected void bindView() {
        tv1 = getViewId(R.id.tv_assure);
        tv2 = getViewId(R.id.tv_credit);


    }

    @Override
    protected void bindListener() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "111111", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), GuaranteeBusinessActivity.class);
                getContext().startActivity(intent);
                dismiss();

            }
        });
    }

    @Override
    protected void intiAttrs(WindowManager.LayoutParams params, Window window, boolean isTransparent) {
        super.intiAttrs(params, window, isTransparent);


        params.gravity = Gravity.CENTER;
        params.width = UiUtils.dp2px(getContext(), 245);
        params.height = UiUtils.dp2px(getContext(),150);

    }

    @Override
    protected Drawable getBackDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#ffffff"));
        drawable.setCornerRadius(UiUtils.dp2px(getContext(), 30));
        return drawable;
    }

}
