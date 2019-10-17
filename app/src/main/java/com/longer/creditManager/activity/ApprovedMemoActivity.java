package com.longer.creditManager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;




import com.longer.creditManager.R;
import com.longer.creditManager.adapter.Adapter3;
import com.longer.creditManager.bean.Deathdata;
import com.longer.creditManager.util.AndroidBug54971Workaround;


import java.util.ArrayList;
import java.util.List;

public class ApprovedMemoActivity extends AppCompatActivity implements Adapter3.OnItemClickListener{

    private Adapter3 adapter3;
    private List<Deathdata> deathdata = new ArrayList<>();
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_approved_memo);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);


        initView();
        initData();

    }

    private void initView() {
        adapter3 = new Adapter3(this);
        adapter3.setOnItemClickListener(this);
        mRv = findViewById(R.id.mRv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        // 设置布局管理器
        mRv.setLayoutManager(manager);
        mRv.setItemAnimator(new DefaultItemAnimator());

        mRv.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL));
        mRv.setAdapter(adapter3);

    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            deathdata.add(new Deathdata("担保项目受理","审核通过","审批意见内容仅做排班版使用，请自行忽略","系统管理员","2019-08-14","","","",""));
            deathdata.add(new Deathdata("担保项目受理","审核不通过","审批意见内容仅做排班版使用，请自行忽略","系统管理员","2019-08-14","","","",""));
            adapter3.setDeathdata(deathdata);
        }
    }

    @Override
    public void onClick(int i) {

    }
}
