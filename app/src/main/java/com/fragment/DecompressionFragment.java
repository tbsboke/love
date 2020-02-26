package com.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.adapter.OutlayRecyclerViewAdapter;
import com.adapter.ViewPagerAdapter;
import com.entity.AccountItem;
import com.example.book.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DecompressionFragment extends Fragment {
    private View mRootview;
    private RecyclerView mRecyclerView;
    public DecompressionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootview =inflater.inflate(R.layout.fragment_decompression,container,false);
        initView();
        return mRootview;
    }

    private void initView() {
        List<AccountItem> outlayAccountList = getTextData();
        mRecyclerView=mRootview.findViewById(R.id.Recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.setAdapter(new OutlayRecyclerViewAdapter(this.getActivity(),outlayAccountList));
    }

    private List<AccountItem> getTextData() {
        List<AccountItem> result = new ArrayList<>();
        for(int i =0;i<5;i++){
           AccountItem item = new AccountItem();
           item.setId(i);
           item.setData("食物"+i);
           result.add(item);
        }
            return result;
    }


}
