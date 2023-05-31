package com.example.metatechnolankapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.metatechnolankapractical.Database.DBUtils;
import com.example.metatechnolankapractical.Object.Data;

public class DetailActivity extends AppCompatActivity {

    String ID;
    Data data;

    ImageView imageView;
    TextView title,headline,nutrition,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ID = getIntent().getStringExtra("ID");

        data = DBUtils.getAllDataByID(this,ID);

        imageView = findViewById(R.id.image);
        title = findViewById(R.id.title);
        headline = findViewById(R.id.headline);
        nutrition = findViewById(R.id.nutrition);
        description = findViewById(R.id.description);

        title.setText(data.getTitle());
        headline.setText(data.getHeadline());
        nutrition.setText(data.getNutrition());
        description.setText(data.getDescription());

    }
}