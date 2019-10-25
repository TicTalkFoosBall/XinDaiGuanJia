package com.longer.creditManager.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.longer.creditManager.R;
import com.longer.creditManager.contract.ExamineContracr;
import com.longer.creditManager.preseenter.ExaminePreseenter;

import hxz.www.commonbase.base.mvp.BaseMvpActivity;
import hxz.www.commonbase.model.ExamineBean;
import hxz.www.commonbase.model.ListBody;
import hxz.www.commonbase.util.log.LogShow;

public class ExamineActivity extends BaseMvpActivity<ExaminePreseenter> implements ExamineContracr.View,View.OnClickListener {

    private ImageView iv_back;
    private RecyclerView mRv;

    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return  R.layout.activity_examine;

    }

    @Override
    public void showData(ExamineBean examineBean) {
        if (examineBean != null){

            Log.e("z"," data ----> " + examineBean.getResult().getList().get(1).getTaskName());
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        iv_back.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        LogShow.i("ExamineActivity  initView");
        ListBody listBody = new ListBody("10", "1");
//        mPresenter.getExamineBean("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsZmNwIiwic2Vzc2lvbklkIjoiZjc3YzI2NjlhZGUzNDZjOThhOTI0M2FhNTg0NDY0YzciLCJleHAiOjE1Njk3ODA2NTR9.VqcvBEbp8rytOQ0ERnvw0GuNq_Hb68DpBH0jmgwXu24",listBody);
////        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);

        iv_back = findViewById(R.id.iv_back);
        mRv = findViewById(R.id.mRv);

    }

    @Override
    protected ExaminePreseenter getPresenter() {
        return new ExaminePreseenter();
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == iv_back.getId()){
            finish();
        }
    }
}
