package com.longer.creditManager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.longer.creditManager.R;
import com.longer.creditManager.bean.Deathdata;


import java.util.ArrayList;
import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {

    private List<Deathdata> deathdata = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }
    public Adapter3(Context context) {
        this.context = context;
    }

    public void setDeathdata(List<Deathdata> deathdata) {
        this.deathdata.clear();
        this.deathdata.addAll(deathdata);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_approvedmemo, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(i);
                }
            }
        });
       // deathdata.add(new Deathdata("担保项目受理","审核通过","审批意见内容仅做排班版使用，请自行忽略","系统管理员","2019-08-14","","","",""));

        Deathdata deathdata = this.deathdata.get(i);
        viewHolder.t1.setText(deathdata.getS1());


        viewHolder.t2.setText("审批意见："+deathdata.getS3());
        viewHolder.t3.setText(deathdata.getS4());
        viewHolder.t4.setText(deathdata.getS5());

        if (deathdata.getS2().equals("审核通过")){
            viewHolder.b1.setText(deathdata.getS2());
            viewHolder.b1.setBackgroundResource(R.drawable.textcolor);
        }else  if (deathdata.getS2().equals("审核不通过")){
            viewHolder.b1.setText(deathdata.getS2());
            viewHolder.b1.setBackgroundResource(R.drawable.textcolor3);
        }

    }

    @Override
    public int getItemCount() {
        return deathdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView t1, t2, t4,t3;
        private Button b1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.tv_company);
            t2 = itemView.findViewById(R.id.tv_opinion);
            t3 = itemView.findViewById(R.id.tv_Administrator);
            t4 = itemView.findViewById(R.id.tv_time);

            b1 = itemView.findViewById(R.id.b_1);

        }
    }

    public interface OnItemClickListener {

        void onClick(int i);
    }

}
