package hxz.www.commonbase.view.imageView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Circle on 2019-07-02
 */
public class AnimImageView extends AppCompatImageView {

    private AnimationDrawable mDrawable;

    public AnimImageView(Context context) {
        super(context);
    }

    public AnimImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
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
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }
}
