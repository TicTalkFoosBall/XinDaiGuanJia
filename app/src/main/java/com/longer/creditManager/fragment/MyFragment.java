package com.longer.creditManager.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.longer.creditManager.MyApplication;
import com.longer.creditManager.R;
import com.longer.creditManager.activity.RegardsActivity;
import com.longer.creditManager.login.LoginActivity;


import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.cache.Cache;

import static android.view.Gravity.apply;


/**
 * A simple {@link Fragment} subclass.
 *
 * 我的界面
 *
 */
public class MyFragment extends BaseMvpFragment implements View.OnClickListener{

    private ImageView iv_headportrait,iv_regard; // 头像 关于
    private LinearLayout share,about; // 头像 关于
    private Button exit;

    public MyFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        return inflater.inflate(R.layout.fragment_my, container, false);
//    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        iv_headportrait = mRootView.findViewById(R.id.iv_headportrait);
        iv_regard = mRootView.findViewById(R.id.iv_regard);
        share = mRootView.findViewById(R.id.ll_share);
        about = mRootView.findViewById(R.id.ll_about);
        exit = mRootView.findViewById(R.id.bt_exit);
        iv_regard.setOnClickListener(this);
        share.setOnClickListener(this);
        about.setOnClickListener(this);
        exit.setOnClickListener(this);

        Glide.with(getContext()).load(R.mipmap.rng)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv_headportrait);

    }

    @Override
    protected BasePresenter<? extends IBaseView> getPresenter() {
        return null;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == iv_regard.getId()){
            startActivity(new Intent(getContext(), RegardsActivity.class));
        }
        else
        if (v.getId() == share.getId()){
        }
        else
        if (v.getId() == about.getId()){
            startActivity(new Intent(getContext(), RegardsActivity.class));
        }
        else
        if (v.getId() == exit.getId()){
            Cache.setUserInfo(null);
            BaseApplication.getInstance().tokenExpire();
            Intent intent = new Intent(getContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
}
