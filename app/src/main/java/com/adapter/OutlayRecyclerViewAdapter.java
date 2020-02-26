package com.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.entity.AccountItem;
import com.example.book.R;

import java.util.List;


public class OutlayRecyclerViewAdapter extends RecyclerView.Adapter<OutlayRecyclerViewAdapter.OutlayItemViewHolder> {
    private List<AccountItem> mItems;
    private final LayoutInflater mLayoutInflater;

    public OutlayRecyclerViewAdapter(Activity context,List<AccountItem> mItems) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public OutlayItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OutlayItemViewHolder h =new OutlayItemViewHolder(mLayoutInflater.inflate(R.layout.item_decompression,parent,false));
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull OutlayItemViewHolder holder, int position) {
        AccountItem item = this.mItems.get(position);
        holder.tvCategory.setText(item.getData());
        int icon = R.drawable.bar_icon3;
//        if(icon>0){
//            holder.imageView.setImageDrawable(icon);
//        }
    }

    @Override
    public int getItemCount() {
        return mItems==null?0:mItems.size();
    }

    public class OutlayItemViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCategory;
        private ImageView imageView;
        public OutlayItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.dataDe);
            imageView = itemView.findViewById(R.id.imageDe);
        }
    }
}
