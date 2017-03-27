package com.example.i.test.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.i.test.R;

/**
 * Created by 马仲凯 on 2017/3/27.
 */

public class TestDialog extends ProgressDialog {
    public TestDialog(Context context) {
        super(context);
    }

    public TestDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dialog);
        this.setIndeterminate(false);//this可以省略  本类dialog
        WindowManager.LayoutParams w=getWindow().getAttributes();
        w.width=WindowManager.LayoutParams.WRAP_CONTENT;
        w.height=WindowManager.LayoutParams.ALPHA_CHANGED;

    }
}
