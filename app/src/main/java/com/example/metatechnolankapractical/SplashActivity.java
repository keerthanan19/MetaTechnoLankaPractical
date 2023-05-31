package com.example.metatechnolankapractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.metatechnolankapractical.Adapter.ViewPagerAdapter;
import com.example.metatechnolankapractical.Callback.OnButtonClick;
import com.example.metatechnolankapractical.Database.DBUtils;
import com.example.metatechnolankapractical.Object.Data;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements OnButtonClick {

    OnButtonClick onButtonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        onButtonClick = this;
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this,onButtonClick));

        SpringDotsIndicator springDotsIndicator = findViewById(R.id.dots_indicator);
        springDotsIndicator.attachTo(viewPager);

        DBUtils.deleteAllData(this);

        String[] title = getResources().getStringArray(R.array.title);
        String[] headline = getResources().getStringArray(R.array.headline);
        String[] image = getResources().getStringArray(R.array.image);
        String[] gradientColors = getResources().getStringArray(R.array.gradientColors);
        String[] description = getResources().getStringArray(R.array.description);
        String[] nutrition = getResources().getStringArray(R.array.nutrition);

        ArrayList<Data> dataArrayList = new ArrayList<>();

        for (int i = 0 ; i < title.length; i++){
            Data data = new Data() ;
            data.setTitle(title[0]);
            data.setHeadline(headline[0]);
            data.setImage(getResources().getDrawable(Integer.parseInt(image[i])));
            data.setGradientColors(gradientColors[0]);
            data.setDescription(description[0]);
            data.setNutrition(nutrition[0]);

            DBUtils.insert_data(data, this);
        }




    }

    @Override
    public void onButtonClick(String id) {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
    }
}