package hxz.www.commonbase.util;

import android.view.View;
import android.widget.TextView;

public class KLUnreadUtil {


    public static void setUnReadView(TextView textView, int count) {
        if (count <= 0) {
            textView.setVisibility(View.GONE);
            return;
        }
        textView.setVisibility(View.VISIBLE);
        if (count < 100) {
            textView.setText(count + "");
        } else {
            textView.setText("...");
        }
    }
}
