package com.longer.creditManager.fragment;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.longer.creditManager.R;
import com.longer.creditManager.activity.Add_BusinessCustomerActivity;
import com.longer.creditManager.activity.Add_ConsumerClientActivity;
import com.longer.creditManager.adapter.Adapter2;
import com.longer.creditManager.bean.Ba2;
import com.longer.creditManager.dialog.Businesslinesdialog;

import java.util.ArrayList;
import java.util.List;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;

/**
 * A simple {@link Fragment} subclass.
 *
 * 客户界面
 *
 */
public class ClientFragment extends BaseMvpFragment implements View.OnClickListener,Adapter2.OnItemClickListener{
    private TextView iv_filtrate; // 筛选
    private ImageView iv_more; // 添加
    // 声明平移动画
    private TranslateAnimation animation;
    private  PopupWindow popupWindow;

    private RecyclerView mRv;
    private List<Ba2> ba2 = new ArrayList<>();
    private Adapter2 adapter2;
    private Businesslinesdialog businesslinesdialog; // 业务选择对话框


    @Override
    protected void initData() {

        for (int i = 0; i < 40; i++) {
            ba2.add(new Ba2("潜在","南京龙戈软件科技有限公司" + i));
            ba2.add(new Ba2("在途","南京龙戈软件科技有限公司" + i));
            ba2.add(new Ba2("在办","南京龙戈软件科技有限公司" + i));
            ba2.add(new Ba2("已结","南京龙戈软件科技有限公司" + i));
        }




    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        iv_filtrate = mRootView .findViewById(R.id.iv_filtrate);
        iv_filtrate.setOnClickListener(this);
        iv_more = mRootView.findViewById(R.id.iv_more);
        iv_more.setOnClickListener(this);

        adapter2 = new Adapter2(ba2,getContext());
        mRv = mRootView.findViewById(R.id.mRv);
        adapter2.setOnItemClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        // 设置布局管理器
        mRv.setLayoutManager(manager);
        mRv.setItemAnimator(new DefaultItemAnimator());
            mRv.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.HORIZONTAL));
        mRv.setAdapter(adapter2);





    }


    @Override
    protected BasePresenter<? extends IBaseView> getPresenter() {
        return null;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == iv_filtrate.getId()){

            initPopupWindow();

        }else if (v.getId() == iv_more.getId()){
            initWindow();

        }

    }

    private void initWindow() {
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.menu_addclient, null, false);
        PopupWindow  popupWindow1 = new PopupWindow(view1, 241, 170,true);
        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.setFocusable(true);
        popupWindow1.setOutsideTouchable(true);
        popupWindow1.update();
        popupWindow1.showAsDropDown(iv_more,50,5);
        initWindowView(view1);
    }

    // 添加 个人或企业客户
    private void initWindowView(View view1) {
        view1.findViewById(R.id.tv_add_customer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Add_ConsumerClientActivity.class));

            }
        });
        view1.findViewById(R.id.tv_add_company).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Add_BusinessCustomerActivity.class));

            }
        });


    }


    // 弹出PopupWindow
    private void initPopupWindow(){
        Log.e("z"," data ---->"  + " aaaaa");
        View view = LayoutInflater.from(getContext()).inflate(R.layout.popuwindow_screen, null, false);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();

        popupWindow.setFocusable(true);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(200);
        // 设置popupWindow的显示位置，此处是在手机屏幕底部且水平居中的位置
        popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        view.startAnimation(animation);
        PopupWindowOnClick(view);
    }
    // PopupWindow的点击事件
    private void PopupWindowOnClick(View view) {
        view.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });view.findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.tv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.tv_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.tv_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在点击之后设置popupwindow的销毁
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    //lighton();
                }
            }
        });

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_client;
    }

    @Override
    public void showMsg(String msg) {

    }

    /**
     * 设置手机屏幕亮度变暗
     */
    private void lightoff() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.1f;
      getActivity().getWindow().setAttributes(lp);
    }
    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 1f;
        getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(int i) {
        if (businesslinesdialog == null){
            businesslinesdialog = new Businesslinesdialog(getContext());
        }else

            businesslinesdialog.show();


    }
}
