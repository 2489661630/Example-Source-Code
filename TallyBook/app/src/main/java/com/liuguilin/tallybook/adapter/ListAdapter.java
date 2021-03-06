package com.liuguilin.tallybook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuguilin.tallybook.R;

import java.util.ArrayList;

/*
 *  项目名：  TallyBook
 *  包名：    com.liuguilin.tallybook.adapter
 *  文件名:   ListAdapter
 *  创建者:   LiuGuiLinAndroid
 *  创建时间:  2017/3/26 20:08
 *  描述：    适配器
 */
public class ListAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<String> mList;

    public ListAdapter(Context mContext, ArrayList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_setting_item, null);
            viewHolder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_item.setText(mList.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView tv_item;
    }
}
