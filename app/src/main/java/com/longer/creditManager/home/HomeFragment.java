package com.longer.creditManager.home;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longer.creditManager.R;
import com.longer.creditManager.activity.ExaminationActivity;
import com.longer.creditManager.activity.ExamineActivity;
import com.longer.creditManager.adapter.Adapter;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.blacklist.NoticeActivity;

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
public class HomeFragment extends BaseMvpFragment<HomePreseenter> implements Adapter.OnItemClickListener,View.OnClickListener,HomeContract.View {

//    private List<Deathdata> deathdata = new ArrayList<>();
//    private Adapter adapter;
//    private RecyclerView mRV;

    private RelativeLayout rl;
    private RelativeLayout rl_notice;
    private RelativeLayout rl_syetmMsg;
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
        rl_syetmMsg = mRootView.findViewById(R.id.rl_syetmMsg);
        rl_notice = mRootView.findViewById(R.id.rl_notice);
        tv_examine = mRootView.findViewById(R.id.tv_examine);

        rl.setOnClickListener(this);
        rl_notice.setOnClickListener(this);
        rl_syetmMsg.setOnClickListener(this);
        tv_examine.setOnClickListener(this);


    }

    @Override
    protected HomePreseenter getPresenter() {
        return new HomePreseenter();
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
        else if (v.getId() == rl_notice.getId()) {
            startActivity(new Intent(getContext(), NoticeActivity.class));
        }
        else if (v.getId() == rl_syetmMsg.getId()) {
            startActivity(new Intent(getContext(), ExamineActivity.class));
        }
    }

    @Override
    public void showData(LoginBeae loginBeae) {

    }
}
