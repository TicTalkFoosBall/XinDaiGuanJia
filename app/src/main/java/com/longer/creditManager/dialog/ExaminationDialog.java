package com.longer.creditManager.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.longer.creditManager.R;

import org.angmarch.views.NiceSpinner;

import hxz.www.commonbase.util.UiUtils;
import hxz.www.commonbase.view.BaseDialog;

public class ExaminationDialog extends BaseDialog implements View.OnClickListener{

    private EditText ev_opinion;
    private TextView tv1,tv2,tv3;
    private NiceSpinner sp1,sp2,sp3;
    private Button b1;

    public ExaminationDialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_examine;
    }

    @Override
    protected void bindView() {
        ev_opinion = getViewId(R.id.ev_opinion);
        tv1 = getViewId(R.id.tv_result);
        sp1 = getViewId(R.id.sp_result);
        tv2 = getViewId(R.id.tv_approver);
        sp2 = getViewId(R.id.sp_approver);
        tv3 = getViewId(R.id.tv_link);
        sp3 = getViewId(R.id.sp_link);
        b1 = getViewId(R.id.b_submit);


    }

    @Override
    protected void bindListener() {





    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b1.getId()){


        }
    }

    @Override
    protected void intiAttrs(WindowManager.LayoutParams params, Window window, boolean isTransparent) {
        super.intiAttrs(params, window, isTransparent);


        params.gravity = Gravity.CENTER;
        params.width = UiUtils.dp2px(getContext(), 351);
        params.height = UiUtils.dp2px(getContext(),350);

    }

    @Override
    protected Drawable getBackDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#ffffff"));
        drawable.setCornerRadius(UiUtils.dp2px(getContext(), 10));
        return drawable;
    }



}
