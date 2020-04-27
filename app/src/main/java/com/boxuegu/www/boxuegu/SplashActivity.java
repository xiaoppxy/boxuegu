package com.boxuegu.www.boxuegu;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    private TextView text_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        text_splash = findViewById(R.id.text_splash);
        init();
    }
    private void init(){

        try {
            //获取程序信息
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            text_splash.setText("V"+packageInfo.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //延迟3秒跳转
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task,3000);//设置跳转时间3秒
    }
}
