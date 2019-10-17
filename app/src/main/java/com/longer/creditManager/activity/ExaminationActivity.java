package com.longer.creditManager.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;


import com.longer.creditManager.R;
import com.longer.creditManager.dialog.ExaminationDialog;
import com.longer.creditManager.util.AndroidBug54971Workaround;


import hxz.www.commonbase.base.mvp.BaseActivity;

/**
 * ExaminationActivity  项目初审
 *
 *
 *
 */
public class ExaminationActivity extends BaseActivity implements View.OnClickListener{

    private ImageView iv_back,iv_more;
    // 声明平移动画
    private TranslateAnimation animation;
    private PopupWindow popupWindow;
    private Button b_examine; // 立即审批
    private ExaminationDialog examinationDialog;
    private ImageView iv_next;


    @Override
    public void onClick(View v) {
        if (v.getId() == iv_more.getId()){
            initPopupWindow();
            lightoff();
        }else if (v.getId() == iv_back.getId()){
            finish();
        }else if (v.getId() == b_examine.getId()){
            if (examinationDialog == null){
                examinationDialog = new ExaminationDialog(this);
                examinationDialog.show();
            }else {
                examinationDialog.show();

            }
        }else if (v.getId() == iv_next.getId()){

            startActivity(new Intent(this,ApprovedMemoActivity.class));
        }

    }

    // 弹出PopupWindow
    private void initPopupWindow(){

        View view = LayoutInflater.from(this).inflate(R.layout.popuwindow, null, false);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        lighton();
        animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(200);
        popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        view.startAnimation(animation);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                lighton();
            }
        });

        PopupWindowOnClick(view);
    }

    private void PopupWindowOnClick(View view) {
        view.findViewById(R.id.iv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });view.findViewById(R.id.iv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        });
//        view.findViewById(R.id.iv_4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lighton();
//                Toast.makeText(ExaminationActivity.this, "4", Toast.LENGTH_SHORT).show();
//            }
//        });
        view.findViewById(R.id.iv_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "5", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.iv_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "6", Toast.LENGTH_SHORT).show();
            }
        });view.findViewById(R.id.iv_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "7", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lighton();
                Toast.makeText(ExaminationActivity.this, "8", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        return false;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);
        iv_back  = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_more = findViewById(R.id.iv_more);
        iv_more.setOnClickListener(this);
        b_examine = findViewById(R.id.b_examine);
        b_examine.setOnClickListener(this);
        iv_next = findViewById(R.id.iv_next);
        iv_next.setOnClickListener(this);

    }

    @Override
    protected int getLayoutId() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_examination;
    }

    @Override
    protected void onDestroy() {

        if (animation!= null)
        {
            animation.cancel();
        }
        if (popupWindow != null){
            popupWindow.dismiss();
        }
        super.onDestroy();
    }
    private void lightoff() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.6f;
       getWindow().setAttributes(lp);
    }
    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }
}
