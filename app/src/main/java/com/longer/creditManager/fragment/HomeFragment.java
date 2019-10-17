package com.longer.creditManager.fragment;




import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.longer.creditManager.MyApplication;
import com.longer.creditManager.R;
import com.longer.creditManager.activity.ExaminationActivity;
import com.longer.creditManager.activity.ExamineActivity;
import com.longer.creditManager.activity.LoginActivity;
import com.longer.creditManager.adapter.Adapter;
import com.longer.creditManager.bean.Deathdata;
import com.longer.creditManager.bean.Token;
import com.longer.creditManager.chat.ChatActivity;
import com.longer.creditManager.util.Constants;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.component.action.PopActionClickListener;
import com.tencent.qcloud.tim.uikit.component.action.PopDialogAdapter;
import com.tencent.qcloud.tim.uikit.component.action.PopMenuAction;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.base.ConversationInfo;
import com.tencent.qcloud.tim.uikit.utils.PopWindowUtil;

import java.util.ArrayList;
import java.util.List;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;

/**
 * A simple {@link Fragment} subclass.
 *
 * 首页
 *
 */
public class HomeFragment extends BaseMvpFragment implements Adapter.OnItemClickListener,View.OnClickListener{

//    private List<Deathdata> deathdata = new ArrayList<>();
//    private Adapter adapter;
//    private RecyclerView mRV;
      private ConversationLayout mConversationLayout;
      private RelativeLayout rl;
      private TextView tv_examine;


//    private ListView mConversationPopList;
//    private PopDialogAdapter mConversationPopAdapter;
//    private PopupWindow mConversationPopWindow;
//    private List<PopMenuAction> mConversationPopActions = new ArrayList<>();
//     //private Menu mMenu;
//    public String a = "a";

    @Override
    protected void initData() {
//        Deathdata data = new Deathdata();
//        data.setS1("南京龙戈软件科技有限公司");
//        data.setS2("张国旺");
//        data.setS3("2000.000");
//        data.setS4("小额贷款");
//        data.setS5("2019.02.21");
//        data.setS6("审批活动待办");
//        data.setS7("3天6时前");
//        deathdata.add(data);
//        Deathdata data1 = new Deathdata();
//        data1.setS1("南京龙戈软件科技有限公司");
//        data1.setS2("张国旺");
//        data1.setS3("2000.000");
//        data1.setS4("小额贷款");
//        data1.setS5("2019.02.21");
//        data1.setS6("审批活动待办");
//        data1.setS7("3天6时前");
//        deathdata.add(data1);
//        Deathdata data2 = new Deathdata();
//        data2.setS1("南京龙戈软件科技有限公司");
//        data2.setS2("张国旺");
//        data2.setS3("2000.000");
//        data2.setS4("小额贷款");
//        data2.setS5("2019.02.21");
//        data2.setS6("审批活动待办");
//        data2.setS7("3天6时前");
//        deathdata.add(data2);
//        Deathdata data3 = new Deathdata();
//        data3.setS1("南京龙戈软件科技有限公司");
//        data3.setS2("张国旺");
//        data3.setS3("2000.000");
//        data3.setS4("小额贷款");
//        data3.setS5("2019.02.21");
//        data3.setS6("审批活动待办");
//        data3.setS7("3天6时前");
//        deathdata.add(data3);
//        Deathdata data4 = new Deathdata();
//        data4.setS1("南京龙戈软件科技有限公司");
//        data4.setS2("张国旺");
//        data4.setS3("2000.000");
//        data4.setS4("小额贷款");
//        data4.setS5("2019.02.21");
//        data4.setS6("审批活动待办");
//        data4.setS7("3天6时前");
//        deathdata.add(data4);
//        Deathdata data5 = new Deathdata();
//        data5.setS1("南京龙戈软件科技有限公司");
//        data5.setS2("张国旺");
//        data5.setS3("2000.000");
//        data5.setS4("小额贷款");
//        data5.setS5("2019.02.21");
//        data5.setS6("审批活动待办");
//        data5.setS7("3天6时前");
//        deathdata.add(data5);
//
//        adapter.setDeathdata(deathdata);


    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
//        adapter = new Adapter(getActivity());
//        adapter.setOnItemClickListener(this);
//        mRV =mRootView.findViewById(R.id.mRv);
//
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        // 设置布局管理器
//        mRV.setLayoutManager(manager);
//        mRV.setItemAnimator(new DefaultItemAnimator());
//
//        mRV.addItemDecoration(new DividerItemDecoration(
//                getActivity(), DividerItemDecoration.HORIZONTAL));
//        mRV.setAdapter(adapter);

        Token token = new Token();
        Log.e("zz"," token" + MyApplication.TOKEN);
//        Log.e("zz","zz"+ LoginActivity.);

        mConversationLayout = mRootView.findViewById(R.id.cl);
        mConversationLayout.initDefault();
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
        Intent intent = new Intent(getActivity(), ExaminationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == rl.getId()){

            startActivity(new Intent(getContext(), ExamineActivity.class));

        }else if (v.getId() == tv_examine.getId()){
            startActivity(new Intent(getContext(), ExamineActivity.class));
        }
    }

//    private void initView1() {
//        // 从布局文件中获取会话列表面板
//        mConversationLayout = mRootView.findViewById(R.id.conversation_layout);
//    //    mMenu = new Menu(getActivity(), (TitleBarLayout) mConversationLayout.getTitleBar(), Menu.MENU_TYPE_CONVERSATION);
//        // 会话列表面板的默认UI和交互初始化
//        mConversationLayout.initDefault();
//        // 通过API设置ConversataonLayout各种属性的样例，开发者可以打开注释，体验效果
//       // ConversationLayoutHelper.customizeConversation(mConversationLayout);
//
//
//        mConversationLayout.getConversationList().setOnItemClickListener(new ConversationListLayout.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position, ConversationInfo conversationInfo) {
//                //此处为demo的实现逻辑，更根据会话类型跳转到相关界面，开发者可根据自己的应用场景灵活实现
//                startChatActivity(conversationInfo);
//
//
//            }
//        });
//        mConversationLayout.getConversationList().setOnItemLongClickListener(new ConversationListLayout.OnItemLongClickListener() {
//            @Override
//            public void OnItemLongClick(View view, int position, ConversationInfo conversationInfo) {
//                startPopShow(view, position, conversationInfo);
//            }
//        });
//        initTitleAction();
//        initPopMenuAction();
//    }
//
//    private void initTitleAction() {
////        mConversationLayout.getTitleBar().setOnRightClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                if (mMenu.isShowing()) {
////                    mMenu.hide();
////                } else {
////                    mMenu.show();
////                }
////            }
////        });
//    }
//
//    private void initPopMenuAction() {
//
//        // 设置长按conversation显示PopAction
//        List<PopMenuAction> conversationPopActions = new ArrayList<PopMenuAction>();
//        PopMenuAction action = new PopMenuAction();
//        action.setActionName(getResources().getString(R.string.chat_top));
//        action.setActionClickListener(new PopActionClickListener() {
//            @Override
//            public void onActionClick(int position, Object data) {
//                mConversationLayout.setConversationTop(position, (ConversationInfo) data);
//            }
//        });
//        conversationPopActions.add(action);
//        action = new PopMenuAction();
//        action.setActionClickListener(new PopActionClickListener() {
//            @Override
//            public void onActionClick(int position, Object data) {
//                mConversationLayout.deleteConversation(position, (ConversationInfo) data);
//            }
//        });
//        action.setActionName(getResources().getString(R.string.chat_delete));
//        conversationPopActions.add(action);
//        mConversationPopActions.clear();
//        mConversationPopActions.addAll(conversationPopActions);
//    }
//
//    /**
//     * 长按会话item弹框
//     *
//     * @param index       会话序列号
//     * @param conversationInfo 会话数据对象
//     * @param locationX   长按时X坐标
//     * @param locationY   长按时Y坐标
//     */
//    private void showItemPopMenu(final int index, final ConversationInfo conversationInfo, float locationX, float locationY) {
//        if (mConversationPopActions == null || mConversationPopActions.size() == 0)
//            return;
//        View itemPop = LayoutInflater.from(getActivity()).inflate(R.layout.pop_menu_layout, null);
//        mConversationPopList = itemPop.findViewById(R.id.pop_menu_list);
//        mConversationPopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                PopMenuAction action = mConversationPopActions.get(position);
//                if (action.getActionClickListener() != null) {
//                    action.getActionClickListener().onActionClick(index, conversationInfo);
//                }
//                mConversationPopWindow.dismiss();
//            }
//        });
//
//        for (int i = 0; i < mConversationPopActions.size(); i++) {
//            PopMenuAction action = mConversationPopActions.get(i);
//            if (conversationInfo.isTop()) {
//                if (action.getActionName().equals(getResources().getString(R.string.chat_top))) {
//                    action.setActionName(getResources().getString(R.string.quit_chat_top));
//                }
//            } else {
//                if (action.getActionName().equals(getResources().getString(R.string.quit_chat_top))) {
//                    action.setActionName(getResources().getString(R.string.chat_top));
//                }
//
//            }
//        }
//        mConversationPopAdapter = new PopDialogAdapter();
//        mConversationPopList.setAdapter(mConversationPopAdapter);
//        mConversationPopAdapter.setDataSource(mConversationPopActions);
//        mConversationPopWindow = PopWindowUtil.popupWindow(itemPop, mRootView, (int) locationX, (int) locationY);
//        mRootView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mConversationPopWindow.dismiss();
//            }
//        }, 10000); // 10s后无操作自动消失
//    }
//
//    private void startPopShow(View view, int position, ConversationInfo info) {
//        showItemPopMenu(position, info, view.getX(), view.getY() + view.getHeight() / 2);
//    }
//
//    private void startChatActivity(ConversationInfo conversationInfo) {
//        ChatInfo chatInfo = new ChatInfo();
//        chatInfo.setType(conversationInfo.isGroup() ? TIMConversationType.Group : TIMConversationType.C2C);
//        chatInfo.setId(conversationInfo.getId());
//        chatInfo.setChatName(conversationInfo.getTitle());
//
////        //对单聊会话已读上报
////        final TIMMessage timMessage = new TIMMessage();
////        timMessage.isRead();
////        final boolean peerReaded = timMessage.isPeerReaded();
////        Log.e("z"," " + peerReaded);
////        String customStr = timMessage.getCustomStr();
////        Log.e("z", customStr);
////        String title = conversationInfo.getTitle();
////        //获取与用户 "sample_user_1" 的会话
////        TIMConversation conversation = TIMManager.getInstance().getConversation(
////                TIMConversationType.C2C,    //会话类型：单聊
////                title);                      //会话对方用户帐号
////        //将此会话的所有消息标记为已读
////        conversation.setReadMessage(timMessage, new TIMCallBack() {
////            @Override
////            public void onError(int code, String desc) {
////                Log.e("z", "setReadMessage failed, code: " + code + "|desc: " + desc);
////            }
////
////            @Override
////            public void onSuccess() {
////                Log.d("z", "setReadMessage succ");
////                boolean peerReaded1 = timMessage.isPeerReaded();
////                if (peerReaded1){
////                    String customStr = timMessage.getCustomStr();
////                    Log.e("z", customStr);
////                }
////
////            }
////        });
//
//
//        Intent intent = new Intent(getContext(), ChatActivity.class);
//        intent.putExtra(Constants.CHAT_INFO, chatInfo);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//
//
//
//    }






}
