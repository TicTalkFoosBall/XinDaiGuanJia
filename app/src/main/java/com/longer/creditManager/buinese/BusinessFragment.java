package com.longer.creditManager.buinese;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.longer.creditManager.R;
import com.longer.creditManager.buinese.detail.BusineseDetailActivity;
import com.longer.creditManager.buinese.more.BusineseMoreActivity;
import com.longer.creditManager.recording.BusTabmentAdapter;

import java.util.ArrayList;
import java.util.List;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;
import hxz.www.commonbase.model.todo.buinese.DefaultListBean;
import hxz.www.commonbase.model.todo.buinese.OtherListBean;
import hxz.www.commonbase.model.todo.buinese.OtherListBeanSeri;
import hxz.www.commonbase.util.log.LogShow;

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
        adapter.setOnItemClickListener((view, model, position) ->
        {
            LogShow.i("BusinessFragment  initRecycleview", position, adapter.getData().size());
            if (position == (adapter.getData().size() - 1)) {
                Intent intent = new Intent(getContext(), BusineseMoreActivity.class);
                OtherListBeanSeri bean = new OtherListBeanSeri();
                bean.setOtherListBeans(otherList);
                intent.putExtra("otherList", bean);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getContext(), BusineseDetailActivity.class);
                intent.putExtra("code", tab.getDefaultList().get(position).getCode());
                intent.putExtra("name", tab.getDefaultList().get(position).getName());
                startActivity(intent);
            }

        });


    }


    @Override
    public void onClick(View v) {


    }

    private List<OtherListBean> otherList;

    @Override
    public void onQueryBusineseTab(BusineseTab tab) {
        if (tab != null) {
            if (tab.getDefaultList() != null) {
                this.tab = tab;
                List<DefaultListBean> list = new ArrayList<>();
                DefaultListBean bean = new DefaultListBean();
                bean.setName("更多统计");
                bean.setIconRes(R.mipmap.business_ico_09);
                list.addAll(tab.getDefaultList());
                list.add(bean);
                adapter.setData(list);

            }
            otherList = tab.getOtherList();
        }
    }
}
