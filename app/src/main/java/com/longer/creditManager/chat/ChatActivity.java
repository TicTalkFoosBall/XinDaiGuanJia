package com.longer.creditManager.chat;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;



import com.longer.creditManager.R;
import com.longer.creditManager.activity.FriendProfileActivity;
import com.longer.creditManager.util.Constants;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMMessage;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;

public class ChatActivity extends Activity {


    private ChatInfo mChatInfo;
    private ChatLayout mChatLayout;
    private TitleBarLayout mTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Bundle bundle = getIntent().getExtras();
        mChatInfo = (ChatInfo) bundle.getSerializable(Constants.CHAT_INFO);

            initView();
        }


    private void initView() {

        //从布局文件中获取聊天面板组件
       mChatLayout = findViewById(R.id.chat_layout);

        //单聊组件的默认UI和交互初始化
        mChatLayout.initDefault();

        // TODO 通过api设置ChatLayout各种属性的样例
        // ChatLayoutHelper.customizeChatLayout(getActivity(), mChatLayout);
        /*
         * 需要聊天的基本信息
         */
        mChatLayout.setChatInfo(mChatInfo);
        TIMMessage timMessage = new TIMMessage();
        boolean readed = timMessage.isPeerReaded();
        Log.e("gg", " r " + readed);



        //获取单聊面板的标题栏
        mTitleBar = mChatLayout.getTitleBar();

        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (mChatInfo.getType() == TIMConversationType.C2C) {

            mTitleBar.setOnRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChatActivity.this, FriendProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, mChatInfo);
                   startActivity(intent);
                }
            });
        }
        mChatLayout.getMessageLayout().setOnItemClickListener(new MessageLayout.OnItemClickListener() {
            @Override
            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {

                // mTitleBar.setTitle("已读",  ITitleBarLayout.POSITION position);
                //因为adapter中第一条为加载条目，位置需减1
                mChatLayout.getMessageLayout().showItemPopMenu(position - 1, messageInfo, view);
            }

            @Override
            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
                if (null == messageInfo || null == messageInfo.getTIMMessage()) {
                    return;
                }
                ChatInfo info = new ChatInfo();
                info.setId(messageInfo.getTIMMessage().getSender());
                Intent intent = new Intent(ChatActivity.this, FriendProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(TUIKitConstants.ProfileType.CONTENT, info);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mChatLayout.exitChat();
    }


}
