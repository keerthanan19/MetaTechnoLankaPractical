package com.example.metatechnolankapractical.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metatechnolankapractical.Callback.Onclick;
import com.example.metatechnolankapractical.Object.Data;
import com.example.metatechnolankapractical.R;

import java.util.ArrayList;
import java.util.Date;

public class FuritListAdapter extends RecyclerView.Adapter<FuritListAdapter.RecycleViewHolder> {

    Context context;
    Onclick onclick;
    ArrayList<Data> dataArrayList ;
    private final LayoutInflater inflater;

    public  FuritListAdapter (Context mContext, ArrayList<Data> data , Onclick mOnclick){
        context = mContext;
        dataArrayList = data;
        onclick = mOnclick;
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public FuritListAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  inflater.inflate(R.layout.furite_list_view, parent, false);
        return new FuritListAdapter.RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuritListAdapter.RecycleViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageDrawable(dataArrayList.get(position).getImage());
        holder.title.setText(dataArrayList.get(position).getTitle());
        holder.desc.setText(dataArrayList.get(position).getHeadline());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.onClick(dataArrayList.get(position).getID());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    protected class RecycleViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,desc;

        public RecycleViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);


        }
    }
}
