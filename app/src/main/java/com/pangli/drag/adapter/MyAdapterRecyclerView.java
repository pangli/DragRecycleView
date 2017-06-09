package com.pangli.drag.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pangli.drag.R;
import com.pangli.drag.model.Item;

import java.util.List;


/**
 * Created by pangli on 09/06/2017.
 */
public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> {

    private List<Item> mList;

    public MyAdapterRecyclerView(List<Item> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = mList.get(position); // Object Item
        holder.setImage(item.getIdImage()); // Image
    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUser;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivUser = (ImageView) itemView.findViewById(R.id.ivUser);
        }

        public void setImage(int idImage) {
            RequestOptions options = new RequestOptions();
            options.centerCrop();
            Glide.with(ivUser.getContext())
                    .load(idImage)
                    .apply(options)
                    .into(ivUser);
        }

    }

}
