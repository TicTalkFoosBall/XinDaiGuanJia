package com.longer.creditManager.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.longer.creditManager.MyApplication;
import com.longer.creditManager.R;
import com.longer.creditManager.activity.RegardsActivity;


import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;

import static android.view.Gravity.apply;


/**
 * A simple {@link Fragment} subclass.
 *
 * 我的界面
 *
 */
public class MyFragment extends BaseMvpFragment implements View.OnClickListener{

    private TextView tv_phone; // 手机号
    private ImageView iv_headportrait,iv_regard; // 头像 关于

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
        tv_phone = mRootView.findViewById(R.id.tv_phone);
        iv_headportrait = mRootView.findViewById(R.id.iv_headportrait);
        iv_regard = mRootView.findViewById(R.id.iv_regard);
        iv_regard.setOnClickListener(this);


        String phone_num = tv_phone.getText().toString();
//        　String replace =phone_num.substring(3,7);
//　　     String newStr = str.replace(replace ,"****");
        String replace = phone_num.substring(3, 7);
        String newPhone = phone_num.replace(replace, "****");
        tv_phone.setText(newPhone);


//        GlideUtils.loadImageCenterCrop(getActivity(),R.mipmap.rng,iv_headportrait);
//        Glide.with(getContext())
//                .load(item.getImage_src())
//                .transform(new CenterCrop(getContext()), new GlideRoundTransform(getActivity(),4))
//                .error(R.mipmap.deault_home3)
//                .into(itemImge);
//

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

    }
}
