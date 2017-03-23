package com.example.i.test.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.i.test.MainActivity;
import com.example.i.test.R;
import com.hyphenate.chat.EMClient;

import java.util.Date;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intentToNew();
    }
    private void intentToNew(){
        new Thread(new Runnable() {
            @Override
            public void run() {
               //判断之前是否登陆过
                if(EMClient.getInstance().isLoggedInBefore()){
                    Long startTime=new Date().getTime();
                    //两个方法是为了保证进入主页面后本地会话和群组都 load 完毕
                  EMClient.getInstance().chatManager().loadAllConversations();
               EMClient.getInstance().groupManager().loadAllGroups();
                Long time=new Date().getTime()-startTime;
                  //登陆过跳转到主页
                    SystemClock.sleep(2000-time);
                    //跳转到MainActivity
                   startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }else{//没登陆过调到登陆页
                    SystemClock.sleep(2000);
                    //跳转到登陆页
                   startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                }
                finish();
            }
        }).start();
    }
}
