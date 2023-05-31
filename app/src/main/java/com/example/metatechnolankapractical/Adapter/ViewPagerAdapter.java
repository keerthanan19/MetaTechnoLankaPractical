package com.example.metatechnolankapractical.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.metatechnolankapractical.Callback.OnButtonClick;
import com.example.metatechnolankapractical.Object.ModelObject;
import com.example.metatechnolankapractical.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;

    OnButtonClick buttonClick;

    public ViewPagerAdapter(Context context, OnButtonClick onButtonClick ) {
        mContext = context;
        buttonClick = onButtonClick;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), container, false);
        container.addView(layout);
        Button button = layout.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick.onButtonClick("");
            }
        });

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject customPagerEnum = ModelObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }
}
