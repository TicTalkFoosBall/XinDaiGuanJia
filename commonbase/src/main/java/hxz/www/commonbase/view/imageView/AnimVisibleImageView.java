package hxz.www.commonbase.view.imageView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import hxz.www.commonbase.util.log.LogShow;


/**
 * Created by Circle on 2019-07-02
 */
public class AnimVisibleImageView extends AppCompatImageView {

    private AnimationDrawable mDrawable;

    public AnimVisibleImageView(Context context) {
        super(context);
    }

    public AnimVisibleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimVisibleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == VISIBLE) {
            if (mDrawable == null) {
                Drawable drawable = getDrawable();
                if (drawable == null) return;
                if (drawable instanceof AnimationDrawable) {
                    mDrawable = ((AnimationDrawable) drawable);
                    mDrawable.start();
                }
            } else if (mDrawable != null) {
                setImageDrawable(mDrawable);
                mDrawable.start();
            }
        } else {
            clearAnimation();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogShow.i("AnimVisibleImageView  onDetachedFromWindow");
        setImageDrawable(null);
        /**
         * 释放animDrawable
         */
        clearAnimation();
    }


}
