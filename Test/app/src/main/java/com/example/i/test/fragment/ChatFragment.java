package com.example.i.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.i.test.R;

/**
 * Created by 马仲凯 on 2017/3/23.
 */

public class ChatFragment extends Fragment {
    private ListView lv;
    private Context context;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = LayoutInflater.from(context).inflate(R.layout.fragmemt_chat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initView() {
        lv = (ListView) view.findViewById(R.id.lv_char);

    }
}
