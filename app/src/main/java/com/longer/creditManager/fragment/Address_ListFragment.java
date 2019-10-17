package com.longer.creditManager.fragment;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Toast;


import com.longer.creditManager.R;
import com.longer.creditManager.activity.FriendProfileActivity;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactLayout;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactListView;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;

import hxz.www.commonbase.base.mvp.BaseMvpFragment;
import hxz.www.commonbase.base.mvp.BasePresenter;
import hxz.www.commonbase.base.mvp.IBaseView;

/**
 * A simple {@link } subclass.
 *
 * 通讯录界面
 */
public class Address_ListFragment extends BaseMvpFragment {

    private  ContactLayout mContactLayout;

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        // 从布局文件中获取通讯录面板
        //AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);
         mContactLayout = mRootView.findViewById(R.id.contact_layout);
        // 通讯录面板的默认 UI 和交互初始化
        mContactLayout.initDefault();

        skipSinglechat();


    }

    private void skipSinglechat() {

        mContactLayout.getContactListView().setOnItemClickListener(new ContactListView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ContactItemBean contact) {
                if (position == 0) {
                    Toast.makeText(mActivity, "0", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(mActivity, "1", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(mActivity, "2", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(mActivity, "3", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), FriendProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, contact);
                    startActivity(intent);

                }
            }
        });
    }

    @Override
    protected BasePresenter<? extends IBaseView> getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_address__list;
    }

    @Override
    public void showMsg(String msg) {

    }
}
