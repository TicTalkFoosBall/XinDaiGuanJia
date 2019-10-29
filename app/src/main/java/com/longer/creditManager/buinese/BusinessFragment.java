package com.longer.creditManager.buinese;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.longer.creditManager.R;
import com.longer.creditManager.buinese.detail.BusineseDetailActivity;
import com.longer.creditManager.recording.BusTabmentAdapter;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;
import hxz.www.commonbase.util.log.LogShow;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * 业务界面
 */
public class BusinessFragment extends BaseMvpFragment<BusinesePreseenter> implements View.OnClickListener, BusineseView {

    private BusTabmentAdapter adapter;
    private RecyclerView tabRecy;
    private BusineseTab tab;

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        addToPresenters(mPresenter);
        tabRecy = mRootView.findViewById(R.id.rv_tab);
        initRecycleview();
        mPresenter.getTabs();
    }

    @Override
    protected BusinesePreseenter getPresenter() {
        return new BusinesePreseenter();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_business;
    }

    @Override
    public void showMsg(String msg) {

    }


    private void initRecycleview() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        adapter = new BusTabmentAdapter();
        tabRecy.setLayoutManager(manager);
        tabRecy.setAdapter(adapter);
//        tabRecy.addItemDecoration(new VerticalItemDecoration(DisplayUtil.dp2px(8)));
        adapter.setOnItemClickListener((view, model, position) ->
        {
            LogShow.i("BusinessFragment  initRecycleview");
            Intent intent = new Intent(getContext(), BusineseDetailActivity.class);
            intent.putExtra("code",tab.getDefaultList().get(position).getCode());
            startActivity(intent);
        });


    }


    @Override
    public void onClick(View v) {


    }

    @Override
    public void onQueryBusineseTab(BusineseTab tab) {
        if (tab != null) {
            if (tab.getDefaultList() != null) {
                this.tab = tab;
                adapter.setData(tab.getDefaultList());

            }

        }
    }
}
