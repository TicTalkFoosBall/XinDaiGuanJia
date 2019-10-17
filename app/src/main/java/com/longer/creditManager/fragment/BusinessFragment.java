package com.longer.creditManager.fragment;



import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.longer.creditManager.R;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;

/**
 * A simple {@link Fragment} subclass.
 *
 * 业务界面
 *
 */
public class BusinessFragment extends BaseMvpFragment implements View.OnClickListener{

    private ImageView iv_type,iv_type2,iv_type3,iv_type4,iv_type5,iv_type6,iv_type7,iv_type8,iv_type9;

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        iv_type = mRootView.findViewById(R.id.tv_type);
        iv_type2 = mRootView.findViewById(R.id.tv_type2);
        iv_type3 = mRootView.findViewById(R.id.tv_type3);
        iv_type4 = mRootView.findViewById(R.id.tv_type4);
        iv_type5 = mRootView.findViewById(R.id.tv_type5);
        iv_type6 = mRootView.findViewById(R.id.tv_type6);
        iv_type7 = mRootView.findViewById(R.id.tv_type7);
        iv_type8 = mRootView.findViewById(R.id.tv_type8);
        iv_type9 = mRootView.findViewById(R.id.tv_type9);
        iv_type.setOnClickListener(this);
        iv_type2.setOnClickListener(this);
        iv_type3.setOnClickListener(this);
        iv_type5.setOnClickListener(this);
        iv_type4.setOnClickListener(this);
        iv_type6.setOnClickListener(this);
        iv_type7.setOnClickListener(this);
        iv_type8.setOnClickListener(this);
        iv_type9.setOnClickListener(this);

    }

    @Override
    protected BasePresenter<? extends IBaseView> getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_business;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == iv_type.getId()){
            Toast.makeText(mActivity, "0", Toast.LENGTH_SHORT).show();
        }else if (v.getId() == iv_type2.getId()){

        }else if (v.getId() == iv_type3.getId()){

        }else if (v.getId() == iv_type4.getId()){

        }else if (v.getId() == iv_type5.getId()){

        }else if (v.getId() == iv_type6.getId()){

        }else if (v.getId() == iv_type7.getId()){

        }else if (v.getId() == iv_type8.getId()){

        }else if (v.getId() == iv_type9.getId()){

        }

    }
}
