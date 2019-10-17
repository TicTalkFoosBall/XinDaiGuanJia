package hxz.www.commonbase.util.fragment;

import android.os.Bundle;
import com.xingxiu.frame.base.BaseFragment;

/**
 * Fragment DialogFragment 帮助类
 * Created by Circle on 2019-06-27
 */
public class FragmentHelper {

    public static final String PARAMS = "params";


    /**
     * 创建fragment的静态方法，方便传递参数
     *
     * @param params 传递的参数
     * @return
     */
    public static <T extends BaseFragment> T newInstance(Class clazz, Object... params) {
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
