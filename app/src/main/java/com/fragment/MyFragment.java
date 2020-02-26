package com.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adapter.MyAdapter;
import com.example.book.R;
import com.other.DataBean;
import com.other.MyItemDacoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private List<DataBean> datas = new ArrayList<>();
    private int imag[] = {R.drawable.q,R.drawable.qq,R.drawable.qqq
            ,R.drawable.qqqq,R.drawable.qqqqq};
    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerview);
        myAdapter = new MyAdapter(datas);
        mRecyclerView.setAdapter(myAdapter);
        //设置布局方式
        initStraggerAdapterV();
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //对item修饰样式
        mRecyclerView.addItemDecoration(new MyItemDacoration());
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, String city) {
                Toast.makeText(MyFragment.this.getActivity(),"city"+city+"position"+position,Toast.LENGTH_LONG).show();
            }
        });
        initDatas();
        return view;
    }
    private void initStraggerAdapterV(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
    private void initDatas() {
        for (int i =0;i<imag.length;i++){
            int iconId = imag[i];
            DataBean dataBean = new DataBean();
            dataBean.text="我是"+i;
            dataBean.image=iconId;
            datas.add(dataBean);
        }
    }
}
