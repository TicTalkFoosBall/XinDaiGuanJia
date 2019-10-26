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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.longer.creditManager.R;

import hxz.www.commonbase.util.UiUtils;
import hxz.www.commonbase.view.BaseDialog;

public class ExaminationDialog extends BaseDialog implements View.OnClickListener {

    private EditText ev_opinion;
    private TextView tv1, tv_result, tv3;
    private LinearLayout result;
    private Button b_submit;
    private OptionDialogListener listener;


    public ExaminationDialog(Context context) {

        super(context);
    }

    public void setListener(OptionDialogListener listener) {
        this.listener = listener;
    }

    public void setResult(String des) {
        tv_result.setText(des);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_examine;
    }

    @Override
    protected void bindView() {
        ev_opinion = getViewId(R.id.ev_opinion);
        tv1 = getViewId(R.id.tv_result);
        result = getViewId(R.id.ll_result);
        tv_result = getViewId(R.id.tv_result);
        b_submit = getViewId(R.id.b_submit);
        result.setOnClickListener(this);
        b_submit.setOnClickListener(this);
    }

    @Override
    protected void bindListener() {
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == result.getId()) {
            if (listener != null) {
                listener.onResultChoose();
            }

        }
        else if (v.getId() == b_submit.getId()) {
            if (listener != null) {
                if (ev_opinion.getText()!=null&&ev_opinion.getText().toString()!=null)
                {
                    listener.onCommit(ev_opinion.getText().toString());
                }

            }

        }
    }

    @Override
    protected void intiAttrs(WindowManager.LayoutParams params, Window window, boolean isTransparent) {
        super.intiAttrs(params, window, isTransparent);

        params.gravity = Gravity.CENTER;
        params.width = UiUtils.dp2px(getContext(), 351);
        params.height = UiUtils.dp2px(getContext(), 350);

    }

    @Override
    protected Drawable getBackDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#ffffff"));
        drawable.setCornerRadius(UiUtils.dp2px(getContext(), 10));
        return drawable;
    }


}
