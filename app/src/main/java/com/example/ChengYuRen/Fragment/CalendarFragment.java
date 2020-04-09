package com.example.ChengYuRen.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.ChengYuRen.Adapter.CalendarGridAdapter;
import com.example.ChengYuRen.R;

//某个月的月历 碎片Fragment的形式加入到翻页适配器
//网格的每一个单元就是一个具体的日期
public class CalendarFragment extends Fragment {
    private static final String TAG = "CalendarFragment";
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象
    private int mYear, mMonth; // 当前碎片所要展示的年份和月份
    private GridView gv_calendar; // 声明一个网格视图对象

    public static CalendarFragment newInstance(int year, int month){
        CalendarFragment fragment=new CalendarFragment();//创建一个碎片的实例
        Bundle bundle=new Bundle(); //创建一个新包裹
        bundle.putInt("year",year);
        bundle.putInt("month",month);
        fragment.setArguments(bundle);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //获取活动页面的上下文
        mContext=getActivity();
        // 如果碎片携带有包裹，则打开包裹获取参数信息
        if (getArguments()!=null)
        {
            mMonth=getArguments().getInt("month",1);
            mYear=getArguments().getInt("year",2000);

        }
        // 根据布局文件fragment_calendar.xml生成视图对象
        mView=inflater.inflate(R.layout.frgment_calendar,container,false);
        gv_calendar=mView.findViewById(R.id.gv_calendar);
        return mView;
    }
    public void onResume() {
        super.onResume();
        // 构建一个月历的网格适配器,给gv_calendar设置月历网格适配器
        CalendarGridAdapter calendarGridAdapter=new CalendarGridAdapter(mContext,mYear,mMonth,1);
        gv_calendar.setAdapter(calendarGridAdapter);
    }

}