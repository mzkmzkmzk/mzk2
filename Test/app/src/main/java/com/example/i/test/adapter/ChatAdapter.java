package com.example.i.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.i.test.R;
import com.hyphenate.chat.EMConversation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马仲凯 on 2017/3/24.
 */

public class ChatAdapter extends BaseAdapter {
    private Context context;
    private List<EMConversation> list=new ArrayList();

    public ChatAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_chat_list,parent,false);

            convertView.setTag(viewHolder);


        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder{
        private TextView name;

    }
}
