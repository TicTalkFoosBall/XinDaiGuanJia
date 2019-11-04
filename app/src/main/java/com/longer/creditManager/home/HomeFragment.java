package com.longer.creditManager.home;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longer.creditManager.R;
import com.longer.creditManager.activity.ExaminationActivity;
import com.longer.creditManager.adapter.Adapter;
import com.longer.creditManager.buinese.detail.BusineseDetailActivity;
import com.longer.creditManager.notice.NoticeActivity;
import com.longer.creditManager.notice.SystemMsgActivity;
import com.longer.creditManager.todo.RefreshTodoEvent;
import com.longer.creditManager.todo.list.TodoActivity;
import com.longer.creditManager.view.CircleImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.model.Notices;
import hxz.www.commonbase.model.SystemMsgs;
import hxz.www.commonbase.model.Tasks;
import hxz.www.commonbase.model.UnreadBean;
import hxz.www.commonbase.model.todo.buinese.BusineseTab;
import hxz.www.commonbase.model.todo.buinese.HomeListBean;
import hxz.www.commonbase.net.constant.ApiService;
import hxz.www.commonbase.util.ImageLoaders;
import hxz.www.commonbase.util.log.LogShow;
import hxz.www.commonbase.util.time.DateUtil;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * 首页
 */
public class HomeFragment extends BaseMvpFragment<HomePreseenter> implements Adapter.OnItemClickListener, View.OnClickListener, HomeContract.View {


    private RelativeLayout rl_todo;
    private RelativeLayout rl_notice;
    private RelativeLayout rl_syetmMsg;
    private LinearLayout ll_option1, ll_option2, ll_option3;
    private TextView tv_examine, tv_todoCount, tv_noticeCount, tv_systemMsgCount;
    private TextView tv_todoTitle, tv_noticeTitle, tv_systemMsgTitle;
    private TextView tv_todoTime, tv_noticeTime, tv_systemMsgTime, tv_option1, tv_option2, tv_option3;
    private CircleImageView iv_icon1, iv_icon2, iv_icon3;

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        addToPresenters(mPresenter);
        rl_todo = mRootView.findViewById(R.id.rl_todo);
        rl_syetmMsg = mRootView.findViewById(R.id.rl_syetmMsg);
        rl_notice = mRootView.findViewById(R.id.rl_notice);
        tv_examine = mRootView.findViewById(R.id.tv_examine);
        tv_todoCount = mRootView.findViewById(R.id.tv_todoCount);
        tv_noticeCount = mRootView.findViewById(R.id.tv_noticeCount);
        tv_systemMsgCount = mRootView.findViewById(R.id.tv_systemMsgCount);

        tv_todoTitle = mRootView.findViewById(R.id.tv_todoTitle);
        tv_noticeTitle = mRootView.findViewById(R.id.tv_noticeTitle);
        tv_systemMsgTitle = mRootView.findViewById(R.id.tv_systemMsgTitle);

        tv_todoTime = mRootView.findViewById(R.id.tv_todoTime);
        tv_noticeTime = mRootView.findViewById(R.id.tv_noticeTime);
        tv_systemMsgTime = mRootView.findViewById(R.id.tv_systemMsgTime);
        tv_option1 = mRootView.findViewById(R.id.tv_option1);
        tv_option2 = mRootView.findViewById(R.id.tv_option2);
        tv_option3 = mRootView.findViewById(R.id.tv_option3);
        iv_icon1 = mRootView.findViewById(R.id.iv_icon1);
        iv_icon2 = mRootView.findViewById(R.id.iv_icon2);
        iv_icon3 = mRootView.findViewById(R.id.iv_icon3);

        ll_option1 = mRootView.findViewById(R.id.ll_option1);
        ll_option2 = mRootView.findViewById(R.id.ll_option2);
        ll_option3 = mRootView.findViewById(R.id.ll_option3);

        rl_todo.setOnClickListener(this);
        rl_notice.setOnClickListener(this);
        rl_syetmMsg.setOnClickListener(this);
        tv_examine.setOnClickListener(this);

        ll_option1.setOnClickListener(this);
        ll_option2.setOnClickListener(this);
        ll_option3.setOnClickListener(this);
        mPresenter.getTabs();
        rl_notice.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getUnreadCount();
            }
        }, 300);

        EventBus.getDefault().register(this);

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
        if (v.getId() == rl_todo.getId()) {
            tv_todoCount.setVisibility(View.GONE);
            startActivity(new Intent(getContext(), TodoActivity.class));
        } else if (v.getId() == rl_notice.getId()) {
            tv_noticeCount.setVisibility(View.GONE);
            startActivity(new Intent(getContext(), NoticeActivity.class));
        } else if (v.getId() == rl_syetmMsg.getId()) {
            mPresenter.readSystemMSg();
            tv_systemMsgCount.setVisibility(View.GONE);
            startActivity(new Intent(getContext(), SystemMsgActivity.class));
        } else if (v.getId() == R.id.ll_option1) {
            jump2Busin(0);
        } else if (v.getId() == R.id.ll_option2) {
            jump2Busin(1);
        } else if (v.getId() == R.id.ll_option3) {
            jump2Busin(2);
        }
    }

    private void jump2Busin(int position) {
        Intent intent = new Intent(getContext(), BusineseDetailActivity.class);
        intent.putExtra("code", tabList.get(position).getCode());
        intent.putExtra("name", tabList.get(position).getName());
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(RefreshTodoEvent event) {
        mPresenter.getUnreadCount();
        LogShow.i("HomeFragment  refresh");
    }

    @Override
    public void onQueryUnread(UnreadBean unreadBean) {
        if (unreadBean != null) {
            Notices notices = unreadBean.getNotices();
            if (Integer.valueOf(notices.getUnReadNo()) > 0) {
                tv_noticeCount.setVisibility(View.VISIBLE);
                tv_noticeCount.setText(notices.getUnReadNo());
            } else {
                tv_noticeCount.setVisibility(View.GONE);
            }
            tv_noticeTitle.setText(notices.getTitle());
            String noticeTime = notices.getCreateTime();
            tv_noticeTime.setText(noticeTime.substring(0, noticeTime.length() - 2));

            Tasks task = unreadBean.getTasks();
            if (Integer.valueOf(task.getUnReadNo()) > 0) {
                tv_todoCount.setVisibility(View.VISIBLE);
                tv_todoCount.setText(task.getUnReadNo());
            } else {
                tv_todoCount.setVisibility(View.GONE);
            }
            tv_todoTitle.setText(task.getTitle());
            tv_todoTime.setText(DateUtil.millis2String(task.getCreateTime()));

            SystemMsgs msgs = unreadBean.getSystemMsgs();
            if (Integer.valueOf(msgs.getUnReadNo()) > 0) {
                tv_systemMsgCount.setVisibility(View.VISIBLE);
                tv_systemMsgCount.setText(msgs.getUnReadNo());
            } else {
                tv_systemMsgCount.setVisibility(View.GONE);
            }
            tv_systemMsgTitle.setText(msgs.getTitle());
            tv_systemMsgTime.setText(DateUtil.millis2String(msgs.getCreateTime()));

        }
    }


    private List<HomeListBean> tabList;

    public void onQueryBusineseTab(BusineseTab tab) {
        if (tab != null) {
            if (tab.getHomeList() != null) {
                tabList = tab.getHomeList();
                for (int i = 0; i < tab.getHomeList().size(); i++) {
                    HomeListBean bean = tab.getHomeList().get(i);
                    LogShow.i("onQueryBusineseTab ", bean.getName(), bean.getIcon());
                    String url = bean.getIcon();
                    CircleImageView img = null;
                    if (i == 0) {
                        img = iv_icon1;
                        tv_option1.setText(bean.getName());

                    } else if (i == 1) {
                        img = iv_icon2;
                        tv_option2.setText(bean.getName());
                    } else if (i == 2) {
                        img = iv_icon3;
                        tv_option3.setText(bean.getName());
                    }
                    if (url.isEmpty()) {
                        img.setImageResource(R.mipmap.business_default);
                    } else {
                        ImageLoaders.INSTANCE.load(ApiService.FILE_URL + url, img);
                    }

                }
            }

        }
    }
}


