package com.example.metatechnolankapractical.Object;

import com.example.metatechnolankapractical.R;

public enum ModelObject {
    RED(R.string.blue, R.layout.view_blue),
    BLUE(R.string.pink, R.layout.view_pink),
    GREEN(R.string.yellov, R.layout.view_yellov);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
