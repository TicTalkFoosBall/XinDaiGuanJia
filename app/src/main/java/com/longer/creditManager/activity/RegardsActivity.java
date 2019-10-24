package om.longer.creditManager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.longer.creditManager.R;
import com.longer.creditManager.activity.AboutActivity;
import com.longer.creditManager.util.AndroidBug54971Workaround;


public class RegardsActivity extends AppCompatActivity {

    private ImageView back;
    private LinearLayout ll_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regards);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);
        back=findViewById(R.id.iv_back_about);
        ll_about=findViewById(R.id.ll_about);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ll_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegardsActivity.this.startActivity(new Intent(RegardsActivity.this, AboutActivity.class));
            }
        });
    }
}
