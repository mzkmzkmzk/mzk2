
package com.example.i.test.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.i.test.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
private EditText et_zhanghao,et_mima;
    private Button btn_loading;
    private TextView tv_zhuce;
    private Context context= LoginActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    private void initView(){
        et_zhanghao= (EditText) findViewById(R.id.et_zhanghao);
        et_mima= (EditText) findViewById(R.id.et_mima);
        btn_loading= (Button) findViewById(R.id.btn_loading);
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

                View  view=View.inflate(context,R.layout.item_zhuce,null);
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

    }
}
