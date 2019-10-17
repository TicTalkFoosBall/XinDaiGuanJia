package com.longer.creditManager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.longer.creditManager.R;
import com.longer.creditManager.bean.Ba2;
import com.longer.creditManager.dialog.Calldialog;


import java.util.ArrayList;
import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder>{

    private List<Ba2> deathdata = new ArrayList<>();
    private Context context;
    private Calldialog calldialog;


    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }



    public void setDeathdata(List<Ba2> deathdata) {
        this.deathdata.clear();
        this.deathdata.addAll(deathdata);
        notifyDataSetChanged();
    }

    public Adapter2(List<Ba2> deathdata, Context context) {
        this.deathdata = deathdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_clientmanagement, viewGroup, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        calldialog = new Calldialog(context);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(i);
                }
            }
        });

        Ba2 ba2 = deathdata.get(i);
        if (ba2.getType().equals("潜在")){
           viewHolder.t1.setText(ba2.getType());
           viewHolder.t1.setBackgroundResource(R.drawable.textcolor);
           viewHolder.t2.setText(ba2.getData());
        }else if (ba2.getType().equals("在途")){
            viewHolder.t1.setText(ba2.getType());
            viewHolder.t1.setBackgroundResource(R.drawable.textcolor2);
            viewHolder.t2.setText(ba2.getData());
        }else if (ba2.getType().equals("在办")){
            viewHolder.t1.setText(ba2.getType());
            viewHolder.t1.setBackgroundResource(R.drawable.textcolor3);
            viewHolder.t2.setText(ba2.getData());
        }else if (ba2.getType().equals("已结")){
            viewHolder.t1.setText(ba2.getType());
            viewHolder.t1.setBackgroundResource(R.drawable.textcolor4);
            viewHolder.t2.setText(ba2.getData());
        }

        viewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calldialog == null){
                    calldialog = new Calldialog(context);

                }else
                {
                    calldialog.show();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return deathdata.size();
    }


    //
//
//    private OnItemClickListener onItemClickListener;
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        onItemClickListener = listener;
//    }
//
//
//    public Adapter2(Context context) {
//        this.context = context;
//    }
//
//    public void setDeathdata(List<Ba2> deathdata) {
//        this.deathdata.clear();
//        this.deathdata.addAll(deathdata);
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//        View inflate = LayoutInflater.from(context).inflate(R.layout.item_customerselection, viewGroup, false);
//
//        return new ViewHolder(inflate);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
//
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickListener != null) {
//                    onItemClickListener.onClick(i);
//                }
//            }
//        });
//
//       // viewHolder.t1.setText();
//
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return deathdata.size();
//    }
//
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView t1, t2;
        private ImageView iv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv_sign);
            t2 = itemView.findViewById(R.id.tv_content);
            iv = itemView.findViewById(R.id.iv_call);


        }
    }

    public interface OnItemClickListener {

        void onClick(int i);
    }






}
