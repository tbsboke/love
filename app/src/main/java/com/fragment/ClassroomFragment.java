package com.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.adapter.ClassAdapter;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.book.R;
import com.other.ClassData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassroomFragment extends Fragment {
    View mRootView;
    private SliderLayout msliderLayout;
    private ClassAdapter classAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private GridView gridView;
    private List<ClassData> mClassDatas = new ArrayList<>();
    private ArrayList<HashMap<String,Object>> gridData = new ArrayList<HashMap<String,Object>>();
    private int imag[] = {R.drawable.q,R.drawable.love,R.drawable.qqq
            ,R.drawable.qqqq,R.drawable.qqqqq};
    public ClassroomFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_classroom,container,false);
        init();  // 绑定id
        //设置下拉刷新样式  开始
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light);
        //设置下拉刷新样式  结束
        //初始化宫格
        initGrid();
        classAdapter = new ClassAdapter(mClassDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(classAdapter);
        //初始化下拉刷新
        initListener();
        //初始化轮播图
        initSlider();
        //初始化list数据
        initDatas();
        return mRootView;
    }

    private void initGrid() {
        for(int i = 0 ;i < 8; i++)
        {
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("itemImage", R.drawable.icon);
            map.put("itemText", "item"+i);
            gridData.add(map);
        }
        SimpleAdapter adpter = new SimpleAdapter(ClassroomFragment.this.getActivity(),
                gridData,R.layout.grid,
                new String[]{"itemImage","itemText"},
                new int[]{R.id.grid_image,R.id.grid_title});
        gridView.setAdapter(adpter);
        gridView.setOnItemClickListener(new gridView1OnClickListener());
    }

    private void init(){
        swipeRefreshLayout = mRootView.findViewById(R.id.swipeRefresh);
        msliderLayout =mRootView.findViewById(R.id.slider);
        recyclerView = mRootView.findViewById(R.id.class_recyclerView);
        gridView = mRootView.findViewById(R.id.grid);
    }
    private void initDatas() {
        for (int i =0;i<imag.length;i++){
            int iconId = imag[i];
            ClassData ClassDatas = new ClassData();
            ClassDatas.title="你好啊，欢迎光临,此小店转卖二手物品，欢迎订购"+i;
            ClassDatas.money="￥"+i;
            ClassDatas.class_list_image=iconId;
            mClassDatas.add(ClassDatas);
        }
    }

    private void initSlider() {
        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .description("知心APP")
                .image("https://7365-server-z1qmi-1301202059.tcb.qcloud.la/icon/gei.jpg?sign=ed9686fb084917016a9e8f589d5d5264&t=1581321774");
        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .description("汉服文化")
                .image("https://7363-school-0skj7-1301099630.tcb.qcloud.la/icon/hanfu.jfif?sign=094800c459b276724a5a9fe8633d1be1&t=1581322010");
        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3
                .description("灿烂星空")
                .image("https://7363-school-0skj7-1301099630.tcb.qcloud.la/icon/login.jpg?sign=48bc707c33ca07d4bcaca45b931aebdc&t=1581322041");
        TextSliderView textSliderView4 = new TextSliderView(this.getActivity());
        textSliderView4
                .description("免费平台")
                .image("https://7363-school-0skj7-1301099630.tcb.qcloud.la/icon/onee.jpg?sign=2fe34549240fc8cbb1bf7f917c7ede89&t=1581322066");
        msliderLayout.addSlider(textSliderView1);
        msliderLayout.addSlider(textSliderView2);
        msliderLayout.addSlider(textSliderView3);
        msliderLayout.addSlider(textSliderView4);
    }
    private void initListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //o模拟加载数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //休眠两秒钟
                        SystemClock.sleep(2000);
                        ClassroomFragment.this.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                                Toast.makeText(ClassroomFragment.this.getActivity(),"刷新完成",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private class gridView1OnClickListener implements android.widget.AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Object obj = gridView.getAdapter().getItem(i);
            HashMap<String,Object> map  = (HashMap<String,Object>)obj;
            String str = (String) map.get("itemText");
            Toast.makeText(ClassroomFragment.this.getActivity(), ""+str, Toast.LENGTH_LONG).show();
        }
    }
}
