package hxz.www.commonbase.util.span;

import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

import com.xingxiu.frame.app.BaseApplication;
import com.xingxiu.frame.util.expand.BaseExUtilKt;

/**
 * @Author :rickBei
 * @Date :2019/7/30 14:21
 * @Descripe: 带点击和颜色的Span
 **/
public class ClickableSpan extends android.text.style.ClickableSpan {
    private SpanListener listener;
    private int color;


    public ClickableSpan(int color, SpanListener listener) {
        this.listener = listener;
        this.color = color;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(color);//颜色
        ds.setUnderlineText(false); //去掉下划线

    }

    @Override
    public void onClick(View widget) {
        if (widget instanceof TextView) {
            ((TextView) widget).setHighlightColor(BaseExUtilKt.getColor(Color.TRANSPARENT, BaseApplication.getInstance()));
        }
        if (listener != null) {
            listener.onClick();
        }

    }
}
