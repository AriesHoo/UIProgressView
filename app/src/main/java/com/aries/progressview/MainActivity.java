package com.aries.progressview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aries.ui.widget.progress.UIProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_loadingNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIProgressView(MainActivity.this)
                        .setMessage("Loading...")
                        .show();
            }
        });

        findViewById(R.id.btn_loadingDimAmount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIProgressView(MainActivity.this)
                        .setMessage("Loading...")
                        .setDimAmount(0f)
                        .show();
            }
        });

        findViewById(R.id.btn_loadingBg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIProgressView(MainActivity.this)
                        .setMessage("Loading...")
                        .setBackgroundColor(Color.parseColor("purple"))
                        .show();
            }
        });

        findViewById(R.id.btn_loadingIndeterminateDrawable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIProgressView(MainActivity.this)
                        .setMessage("Loading...")
                        .setIndeterminateDrawable(R.drawable.progress_loading)
                        .show();
            }
        });
    }
}
