package com.example.ChengYuRen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

public class MonthPicker extends DatePicker {
    public MonthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        ViewGroup viewGroup=((ViewGroup)((ViewGroup)getChildAt(0)).getChildAt(0));
        if (viewGroup.getChildCount()==3)
        {
            // 有的机型显示格式为“年月日”，此时隐藏第三个控件
            viewGroup.getChildAt(2).setVisibility(View.GONE);
        }else if (viewGroup.getChildCount()==5)
        {
            // 有的机型显示格式为“年|月|日”，此时隐藏第四个和第五个控件（即“|日”）
            viewGroup.getChildAt(3).setVisibility(View.GONE);
            viewGroup.getChildAt(4).setVisibility(View.GONE);
        }
    }
}
