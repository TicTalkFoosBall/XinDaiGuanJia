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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Deathdata> deathdata = new ArrayList<>();
    private Context context;


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }


    public Adapter(Context context) {
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

        View inflate = LayoutInflater.from(context).inflate(R.layout.item_examine, viewGroup, false);

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
        Deathdata deathdata = this.deathdata.get(i);
        viewHolder.t1.setText(deathdata.getS1());
        viewHolder.t2.setText(deathdata.getS2());
        viewHolder.t3.setText(deathdata.getS3());
        viewHolder.t4.setText(deathdata.getS4());
        viewHolder.t5.setText(deathdata.getS5());
        viewHolder.b1.setText(deathdata.getS6());
        viewHolder.b2.setText(deathdata.getS7());


    }

    @Override
    public int getItemCount() {
        return deathdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView t1, t2, t4, t5, t3;
        private Button b1, b2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.tv_company);
            t2 = itemView.findViewById(R.id.tv_name);
            t3 = itemView.findViewById(R.id.tv_money);
            t4 = itemView.findViewById(R.id.tv_variety);
            t5 = itemView.findViewById(R.id.tv_starttime);
            b1 = itemView.findViewById(R.id.b_1);
            b2 = itemView.findViewById(R.id.b_2);

        }
    }

    public interface OnItemClickListener {

        void onClick(int i);
    }

}
