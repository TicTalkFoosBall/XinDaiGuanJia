package com.longer.creditManager.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.longer.creditManager.MainActivity;
import com.longer.creditManager.MyApplication;
import com.longer.creditManager.R;
import com.longer.creditManager.bean.LoginBeae;
import com.longer.creditManager.bean.Token;
import com.longer.creditManager.bean.body.LoginBody;
import com.longer.creditManager.contract.LoginContracr;
import com.longer.creditManager.preseenter.LoginPreseenter;

import hxz.www.commonbase.base.mvp.BaseMvpActivity;
import hxz.www.commonbase.util.ToastUtil;
import hxz.www.commonbase.util.log.LogShow;

public class LoginActivity extends BaseMvpActivity<LoginPreseenter> implements View.OnClickListener, LoginContracr.View {

    private EditText e_username, ev_pwd, ev_company;
    private Button b_login;
    private ImageView iv_cancel, iv_estop;
    private TextView tv_forgetpwd;
    private boolean flag = true;
    //  private Token token;


    @Override
    public void onClick(View v) {
        if (v.getId() == b_login.getId()) {
            LoginBody loginBody = new LoginBody(e_username.getText().toString(), ev_pwd.getText().toString());
            mPresenter.getLoginBeae(loginBody);


            //  loginYun();

        } else if (v.getId() == iv_cancel.getId()) {
            ev_pwd.setText("");


        } else if (v.getId() == iv_estop.getId()) {

            if (flag) {

                ev_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                flag = false;
                iv_estop.setImageResource(R.mipmap.login_visible);
            } else {
                ev_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                flag = true;
                iv_estop.setImageResource(R.mipmap.login_hide);
            }


        } else if (v.getId() == tv_forgetpwd.getId()) {
            startActivity(new Intent(this, ForgetThePasswordActivity.class));
        }
//
    }

    private boolean ckeckEnable() {
        return !TextUtils.isEmpty(e_username.getText().toString()) && !TextUtils.isEmpty(ev_pwd.getText().toString());
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initEvent() {
        b_login.setOnClickListener(this);
        iv_estop.setOnClickListener(this);
        iv_cancel.setOnClickListener(this);
        tv_forgetpwd.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        e_username = findViewById(R.id.ev_username);
        ev_company = findViewById(R.id.ev_company);
        ev_pwd = findViewById(R.id.ev_pwd);
        iv_cancel = findViewById(R.id.iv_cancel);

        iv_estop = findViewById(R.id.iv_estop);
        tv_forgetpwd = findViewById(R.id.tv_forgetpwd);
        b_login = findViewById(R.id.login_btn);

    }

    @Override
    protected LoginPreseenter getPresenter() {
        return new LoginPreseenter();
    }

    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void showMsg(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    public void showData(LoginBeae loginBeae) {
        if (loginBeae != null&&loginBeae.getResult()!=null) {
            String code = loginBeae.getCode();
            Token token = new Token();
            MyApplication.TOKEN = loginBeae.getResult().getToken();
            token.setToken(loginBeae.getResult().getToken());
            LogShow.i("LoginActivity  showData",e_username.getText().toString(),token.getToken());

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
    }

//    // 登录腾讯云
//    private void loginYun() {
//        // 获取userSig函数
//        String userSig = GenerateTestUserSig.genTestUserSig(e_username.getText().toString());
//        TUIKit.login(e_username.getText().toString(), userSig, new IUIKitCallBack() {
//            @Override
//            public void onError(String module, final int code, final String desc) {
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        ToastUtil.toastLongMessage("登录失败, errCode = " + code + ", errInfo = " + desc);
//                    }
//                });
//                // DemoLog.i(TAG, "imLogin errorCode = " + code + ", errorInfo = " + desc);
//            }
//
//            @Override
//            public void onSuccess(Object data) {
//
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//
//                Log.e("z"," 登录成功" );
//
//            }
//        });
//
//
//    }


}
