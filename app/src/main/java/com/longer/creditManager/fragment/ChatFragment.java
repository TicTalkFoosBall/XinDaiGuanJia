package com.longer.creditManager.fragment;



import android.os.Bundle;

import android.support.annotation.Nullable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import com.longer.creditManager.R;
import com.longer.creditManager.util.Constants;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;


public class ChatFragment extends BaseFragment {
    private View mBaseView;
    private ChatLayout mChatLayout;
    private TitleBarLayout mTitleBar;
    private ChatInfo mChatInfo;
    private MessageInfo info = new MessageInfo();
    private TextView isread;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        mChatInfo = (ChatInfo) bundle.getSerializable(Constants.CHAT_INFO);
        if (mChatInfo == null) {
            return null;
        }
        mBaseView = inflater.inflate(R.layout.fragment_chat, container, false);
        initView();
        return mBaseView;
    }

    private void initView() {
        //从布局文件中获取聊天面板组件
        mChatLayout = mBaseView.findViewById(R.id.chat_layout);

        //单聊组件的默认UI和交互初始化
        mChatLayout.initDefault();
       // TextView t = mChatLayout.findViewById(R.id.recording_tips);
        //Log.e("zzz","mgs" +);

        // TODO 通过api设置ChatLayout各种属性的样例
        // ChatLayoutHelper.customizeChatLayout(getActivity(), mChatLayout);
        /*
         * 需要聊天的基本信息
         */
        mChatLayout.setChatInfo(mChatInfo);
//        TIMMessage timMessage = new TIMMessage();
//        boolean readed = timMessage.isPeerReaded();
//        Log.e("gg", " r " + readed);
//
//        // notifyAll();
////        MessageCustomHolder customHolder = new MessageCustomHolder(getView());
////
////
////        isread = customHolder.isread;
////
////
////
////        timMessage = new TIMMessage();
////        boolean peerReaded = timMessage.isPeerReaded();
////        if (peerReaded){
////            Log.e("zzz"," l1 " + peerReaded);
////            isread.setText("已读");
////            // notifyAll();
////        }else {
////            isread.setText("未读");
////            Log.e("zzz"," l2 " + peerReaded);
////            // notifyAll();
////        }
//
//
//        //获取单聊面板的标题栏
//        mTitleBar = mChatLayout.getTitleBar();
////        MessageLayout messageLayout = mChatLayout.getMessageLayout();
////        // 聊天界面设置头像和昵称
////        TIMUserProfile profile = TIMFriendshipManager.getInstance().queryUserProfile(info.getFromUser());
////        if (profile == null) {
////            //messageLayout.findViewById(R.id.recording_tips).setText(info.getFromUser());
////        } else {
////           // usernameText.setText(!TextUtils.isEmpty(profile.getNickName()) ? profile.getNickName() : info.getFromUser());
////            if (!TextUtils.isEmpty(profile.getFaceUrl()) && !info.isSelf()) {
////                List<String> urllist = new ArrayList<>();
////                urllist.add(profile.getFaceUrl());
////              //  leftUserIcon.setIconUrls(urllist);
////                urllist.clear();
////            }
////        }
//
//
//        //    mChatLayout.findViewById(R.id.recording_);
//
//        //单聊面板标记栏返回按钮点击事件，这里需要开发者自行控制
//        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().finish();
//            }
//        });
//        if (mChatInfo.getType() == TIMConversationType.C2C) {
//
//            mTitleBar.setOnRightClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(getActivity(), FriendProfileActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, mChatInfo);
//                  startActivity(intent);
//                }
//            });
//        }
//        mChatLayout.getMessageLayout().setOnItemClickListener(new MessageLayout.OnItemClickListener() {
//            @Override
//            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {
//
//                // mTitleBar.setTitle("已读",  ITitleBarLayout.POSITION position);
//                //因为adapter中第一条为加载条目，位置需减1
//                mChatLayout.getMessageLayout().showItemPopMenu(position - 1, messageInfo, view);
//
//
//            }
//
//            @Override
//            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
//                if (null == messageInfo || null == messageInfo.getTIMMessage()) {
//                    return;
//                }
//                ChatInfo info = new ChatInfo();
//                info.setId(messageInfo.getTIMMessage().getSender());
//                Intent intent = new Intent(getActivity(), FriendProfileActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra(TUIKitConstants.ProfileType.CONTENT, info);
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mChatLayout.exitChat();
//    }
}
