package com.aries.progressview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import com.aries.ui.widget.progress.UIProgressView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created: AriesHoo on 2017/7/18 16:38
 * Function: UIProgressView示例
 * Desc:
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.sBtn_msgLoading) SwitchCompat sBtnMsg;
    @BindView(R.id.sBtn_viewBackLoading) SwitchCompat sBtnViewBack;
    @BindView(R.id.sBtn_progressLoading) SwitchCompat sBtnProgress;
    @BindView(R.id.sBtn_backLoading) SwitchCompat sBtnBack;

    private boolean isShowMsg = true;
    private boolean isDefaultViewBack = true;
    private boolean isDefaultProgress = true;
    private boolean isBackDim = true;

    @Override
    protected void setTitleBar() {
        titleBar.setTitleMainText("UIProgressView");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle var1) {
        sBtnMsg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isShowMsg = isChecked;
                sBtnMsg.setText(isShowMsg ? "显示Message" : "隐藏Message");
            }
        });
        sBtnViewBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isDefaultViewBack = isChecked;
                sBtnViewBack.setText(isDefaultViewBack ? "默认View背景" : "自定义View背景");
            }
        });
        sBtnProgress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isDefaultProgress = isChecked;
                sBtnProgress.setText(isDefaultProgress ? "默认Progress" : "自定义Progress");
            }
        });
        sBtnBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isBackDim = isChecked;
                sBtnBack.setText(isBackDim ? "背景半透明" : "背景全透明");
            }
        });

        sBtnMsg.setChecked(true);
        sBtnViewBack.setChecked(true);
        sBtnProgress.setChecked(true);
        sBtnBack.setChecked(true);
    }

    @OnClick({R.id.rtv_showLoading})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rtv_showLoading:
                UIProgressView loading = new UIProgressView(mContext);
                if (isShowMsg) {
                    loading.setMessage("Loading...");
                }
                if (!isDefaultViewBack) {
                    loading.setBackgroundColor(Color.RED);
                }
                if (!isDefaultProgress) {
                    loading.setIndeterminateDrawable(R.drawable.progress_loading);
                }
                if (!isBackDim) {
                    loading.setDimAmount(0f);
                }
                loading.show();
                break;
        }
    }
}
