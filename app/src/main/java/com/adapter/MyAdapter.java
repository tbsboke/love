package com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.R;
import com.other.DataBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<DataBean> mDatas;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public MyAdapter(List<DataBean> datas){
        mDatas=datas;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.item_my,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setDataAndUI(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.imageview_top);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        listener.onClick(view,getLayoutPosition(),"成功");
                    }
                }
            });
        }

        public void setDataAndUI(DataBean dataBean) {
            textView.setText(dataBean.text);
            imageView.setImageResource(dataBean.image);
        }
    }
    public interface OnItemClickListener{
        void onClick(View v,int position,String city);
    }


}
