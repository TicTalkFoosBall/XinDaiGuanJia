package hxz.www.commonbase.view.roundView;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Circle on 2018/11/1
 */
public class SquareRoundImageView extends RoundImageView {


    public SquareRoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SquareRoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareRoundImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

    }


}
