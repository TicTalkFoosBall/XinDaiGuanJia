package hxz.www.commonbase.util.fragment;

import android.os.Bundle;

import hxz.www.commonbase.base.mvp.BaseFragment;
import hxz.www.commonbase.baseui.BaseFragment2;

public class FragmentHelper {

    public static final String PARAMS = "params";


    /**
     * 创建fragment的静态方法，方便传递参数
     *
     * @param params 传递的参数
     * @return
     */
    public static <T extends BaseFragment2> T newInstance(Class clazz, Object... params) {
        T mFragment = null;
        try {
            mFragment = (T) clazz.newInstance();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(PARAMS, params);
                mFragment.setArguments(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mFragment;
    }

}
