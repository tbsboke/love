package com.main.book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.adapter.ViewPagerAdapter;
import com.example.book.R;
import com.fragment.ClassroomFragment;
import com.fragment.DecompressionFragment;
import com.fragment.InteractionFragment;
import com.fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.yczbj.ycvideoplayerlib.manager.VideoPlayerManager;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    private BottomNavigationView navigation;

    //设置更换主题菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int themeId = getIntent().getIntExtra("themeId",-1);
        if(themeId!=-1){
            setTheme(themeId);
        }
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager =(ViewPager) this.findViewById(R.id.viewpage);
        setupViewPager(viewPager);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_title1:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_title2:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_title3:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_title5:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };
    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ClassroomFragment f1 = new ClassroomFragment();
        DecompressionFragment f2 = new DecompressionFragment();
        InteractionFragment f3 = new InteractionFragment();
        MyFragment f4 = new MyFragment();
        adapter.addFragment(f1);
        adapter.addFragment(f2);
        adapter.addFragment(f3);
        adapter.addFragment(f4);
        viewPager.setAdapter(adapter);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.theme_red:
                red();
                break;
            case R.id.theme_blue:
                blue();
                break;
            case R.id.theme_violet:
                violet();
                break;
            default:
        }
        return true;
    }
    public void red(){
        //结束自己
        finish();
        overridePendingTransition(0,0);//紧挨着finish方法或者对应的startActivity方法
        //重启自己
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        //告知需要的主题
        intent.putExtra("themeId",R.style.App_Red);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void violet(){
        //结束自己
        finish();
        overridePendingTransition(0,0);//紧挨着finish方法或者对应的startActivity方法
        //重启自己
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        //告知需要的主题
        intent.putExtra("themeId",R.style.App_Violet);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void blue(){
        //结束自己
        finish();
        overridePendingTransition(0,0);//紧挨着finish方法或者对应的startActivity方法
        //重启自己
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        //告知需要的主题
        intent.putExtra("themeId",R.style.App_blue);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

}
