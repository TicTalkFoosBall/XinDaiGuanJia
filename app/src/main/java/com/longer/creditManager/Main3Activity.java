package com.longer.creditManager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;


import com.longer.creditManager.util.AndroidBug54971Workaround;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;

import hxz.www.commonbase.base.mvp.BaseActivity;

public class Main3Activity extends BaseActivity {
    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        return false;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);
        // 从布局文件中获取会话列表面板
        ConversationLayout conversationLayout = findViewById(R.id.conversation_layout);
        // 会话列表面板的默认 UI 和交互初始化
        conversationLayout.initDefault();

    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main3;
    }
}
