package com.longer.creditManager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import com.longer.creditManager.R;
import com.longer.creditManager.bean.Sudoku;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private List<Sudoku> data = new ArrayList<>(); // 九 宫 格 数  据 源
    private Context context;

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Sudoku> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridview_sudoku,null);
            viewHolder.iv = convertView.findViewById(R.id.tv_type);
            viewHolder.tv = convertView.findViewById(R.id.tv_text);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Sudoku sudoku = data.get(position);
        viewHolder.iv.setImageResource(sudoku.getImgUrl());
        viewHolder.tv.setText(sudoku.getTv_name());

        if (sudoku.getTv_name().equals("")){

        }else if (sudoku.getTv_name().equals("")){

        }



        return convertView;
    }

    public class ViewHolder{
        private ImageView iv;
        private TextView tv;

    }

}
