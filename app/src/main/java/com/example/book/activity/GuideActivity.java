package com.example.book.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.book.R;

public class GuideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //无title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        setContentView(R.layout.activity_guide);

        Thread myThread = new Thread() {//创建子线程
            @Override
            public void run() {
                try {
                    sleep(2000);//使程序休眠一秒
                    Intent it = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(it);
                    finish();//关闭当前活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程

    }
}
