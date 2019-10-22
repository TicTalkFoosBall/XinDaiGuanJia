package com.longer.creditManager.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longer.creditManager.R;
import com.longer.creditManager.activity.ExaminationActivity;
import com.longer.creditManager.activity.ExamineActivity;
import com.longer.creditManager.adapter.Adapter;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;
import hxz.www.commonbase.util.log.LogShow;

/**
 * A simple {@link Fragment} subclass.
 *
 * 首页
 *
 */
public class HomeFragment extends BaseMvpFragment implements Adapter.OnItemClickListener,View.OnClickListener {

//    private List<Deathdata> deathdata = new ArrayList<>();
//    private Adapter adapter;
//    private RecyclerView mRV;

    private RelativeLayout rl;
    private TextView tv_examine;


    @Override
    protected void initData() {
//
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        //   initView1();

        rl = mRootView.findViewById(R.id.rl);
        tv_examine = mRootView.findViewById(R.id.tv_examine);

        rl.setOnClickListener(this);
        tv_examine.setOnClickListener(this);


    }

    @Override
    protected BasePresenter<? extends IBaseView> getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(int i) {
        LogShow.i("HomeFragment  onClick i");
        Intent intent = new Intent(getActivity(), ExaminationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        LogShow.i("HomeFragment  onClick v");
        if (v.getId() == rl.getId()) {

            startActivity(new Intent(getContext(), ExamineActivity.class));

        } else if (v.getId() == tv_examine.getId()) {
            startActivity(new Intent(getContext(), ExamineActivity.class));
        }
    }
}
