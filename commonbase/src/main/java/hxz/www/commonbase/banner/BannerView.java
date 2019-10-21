package hxz.www.commonbase.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BannerView<T> extends RelativeLayout {


    private Context mContext;

    /**
     * 是否自动循环播放
     */
    private boolean isAuto;


    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
