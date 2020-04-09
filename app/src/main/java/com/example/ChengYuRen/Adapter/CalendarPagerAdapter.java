package com.example.ChengYuRen.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ChengYuRen.Constant;
import com.example.ChengYuRen.Fragment.CalendarFragment;

//全部月历的ViewPager 共计12页 它与具体月份之间通过CalendarPagerAdapter关联
public class CalendarPagerAdapter extends FragmentStatePagerAdapter
{
    private int mYear;
    public CalendarPagerAdapter(FragmentManager fragmentManager, int year)
    {
        // 碎片页适配器的构造函数，传入碎片管理器与年份
        super(fragmentManager);
        mYear=year;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        //// 获取指定月份的碎片Fragment
        return CalendarFragment.newInstance(mYear,position+1);
    }

    @Override
    public int getCount() {
        //一年12个月
        return 12;
    }
    public CharSequence getPageTitle(int position){
        return new String(Constant.xuhaoArray[position+1]+'月');
    }
}
