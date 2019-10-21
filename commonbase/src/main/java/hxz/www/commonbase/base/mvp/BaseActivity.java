package hxz.www.commonbase.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import hxz.www.commonbase.util.Logger;


public abstract class BaseActivity extends AppCompatActivity {

    protected View mView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);



        if (getLayoutId() != 0) {
            mView = LayoutInflater.from(this).inflate(getLayoutId(), null);
            setContentView(mView);
            init(savedInstanceState);
        }
      //  init(savedInstanceState);
    }

    protected abstract boolean checkDeviceHasNavigationBar(Context context);

    /**
     * 初始化
     */
    protected abstract void init(@Nullable Bundle savedInstanceState);

    /**
     * @return layoutId
     */
    @LayoutRes
    protected abstract int getLayoutId();


    /**
     * 查看当前ActivityName生命周期
     */
    @Override
    protected void onStart() {
        super.onStart();
        Logger.w(this.getClass().getSimpleName() + "<----当前生命周期");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.w(this.getClass().getSimpleName() + "<----当前生命周期");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.w(this.getClass().getSimpleName() + "<----当前生命周期");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.w(this.getClass().getSimpleName() + "<----当前生命周期");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.w(this.getClass().getSimpleName() + "<----当前生命周期");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.w(this.getClass().getSimpleName() + "<----当前生命周期");
    }


}
