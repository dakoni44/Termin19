package org.ftninformatika.termin19;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    private List<String> data;
    private OnItemClickListener listener;

    public MyAdapter(List<String> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        MyViewholder myViewholder=new MyViewholder(view,listener);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.tvPrimary.setText(data.get(position));
        holder.tvSecondary.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvPrimary, tvSecondary;
        public OnItemClickListener vhListener;

        public MyViewholder(@NonNull View itemView, OnItemClickListener vhListener) {
            super(itemView);
            tvPrimary=itemView.findViewById(R.id.tvPrimary);
            tvSecondary=itemView.findViewById(R.id.tvSecondary);
            this.vhListener=vhListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            vhListener.onItemClick(getAdapterPosition());
        }
    }



    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
