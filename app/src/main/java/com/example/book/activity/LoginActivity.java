package com.example.book.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.book.R;
import com.main.book.MainActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText user,password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init() {
        user = (EditText)findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        btn_login =(Button) findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                information();
            }
        });
        //设置焦点监听
        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(LoginActivity.this,"仅支持字母、数字、字符",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void information(){
        String user_name=user.getText().toString();
        String user_pass=password.getText().toString();
        if(TextUtils.isEmpty(user_name)){
            user.setError("用户名不能为空");
        }
        if(TextUtils.isEmpty(user_pass)){
            user.setError("密码不能为空");
        }
        if (user_name.equals("")&&user_pass.equals("")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
        }
    }
    public void goRegister(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
