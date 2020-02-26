package com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.R;
import com.other.ClassData;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {
    private List<ClassData> classData;
    private LayoutInflater inflater;
    public ClassAdapter(List<ClassData> mdata){
        classData = mdata;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_class,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(classData.get(position));
    }

    @Override
    public int getItemCount() {
        return classData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView money;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_title);
            money = itemView.findViewById(R.id.list_money);
            imageView = itemView.findViewById(R.id.list_image);
        }

        public void setData(ClassData classAdapter) {
            title.setText(classAdapter.title);
            money.setText(classAdapter.money);
            imageView.setImageResource(classAdapter.class_list_image);
        }
    }

}
