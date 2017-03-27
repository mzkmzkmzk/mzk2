
package com.example.i.test.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.test.MainActivity;
import com.example.i.test.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
private EditText et_zhanghao,et_mima;
    private ImageButton btn_loading;
    private TextView tv_zhuce;
    private Context context= LoginActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView(){
        et_zhanghao= (EditText) findViewById(R.id.et_zhanghao);
        et_mima= (EditText) findViewById(R.id.et_mima);
        btn_loading= (ImageButton) findViewById(R.id.btn_loading);
        tv_zhuce= (TextView) findViewById(R.id.tv_zhuce);
        btn_loading.setOnClickListener(this);
        tv_zhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_loading:

                  getLogin();
                break;
            case R.id.tv_zhuce:

                View  view= LayoutInflater.from(context).inflate(R.layout.item_zhuce,null,false);
                new AlertDialog.Builder(context)
                        .setView(view)
                        .setPositiveButton("注册", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("取消",null)
                        .show();
                break;
        }
    }

    public void getLogin() {
        int check;
    String yonghu=et_zhanghao.getText().toString();
        String pwd=et_mima.getText().toString();
        check=chechYonghuPwd(yonghu,pwd);
        switch (check){

            case 0:
                login(yonghu,pwd);
                break;
            default:

                errorToast(check);
                break;
        }
    }

    //判断账号密码是否合法
    private int chechYonghuPwd(String yonghu, String pwd) {
        //判断字符串是否合法
        if(TextUtils.isEmpty(yonghu)){
            return 1;
        }
        if(TextUtils.isEmpty(pwd)){
            return 2;
        }
        if(TextUtils.isEmpty(yonghu)&&TextUtils.isEmpty(pwd)){

            return 5;
        }
        return 0;
    }

    private void login(String et_yonghu, String et_pwd) {
        EMClient.getInstance().login(et_yonghu, et_pwd, new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

                Log.d("TAG", "登陆聊天服务器成功");
            }

            @Override
            public void onError(int i, String s) {
                Log.d("TAG", "登陆聊天服务器失败");
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
    public void errorToast(int errCord) {
        String str;
        switch (errCord) {
            case 1:
                str = "帐号不能为空！";
                break;
            case 2:
                str = "密码不能为空！";
                break;
            case 3:
                str = "再次输入的密码不能为空！";
                break;
            case 4:
                str = "俩次输入的密码不一致！";
                break;
            case 5:
                str="请输入账号和密码";
            default:
                str = "输入的内容不合法！";
                break;
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
