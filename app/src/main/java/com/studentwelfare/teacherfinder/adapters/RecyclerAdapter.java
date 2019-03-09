package com.studentwelfare.teacherfinder.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.studentwelfare.teacherfinder.DataPackage.Recycler;
import com.studentwelfare.teacherfinder.R;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Recycler> items;
    private Context context;
    private boolean active;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, id,desc;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.rec_user_name);
            imageView = view.findViewById(R.id.rec_user_image);
            id = view.findViewById(R.id.rec_user_id);
            desc = view.findViewById(R.id.rec_user_description);
        }
    }


    public RecyclerAdapter(List<Recycler> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recycler recycler = items.get(position);
        holder.desc.setText(recycler.getDsc());
        holder.name.setText(recycler.getName());
        holder.id.setText(recycler.getID());

        Glide.with(context)
                .load(Uri.parse(recycler.getImg()))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}