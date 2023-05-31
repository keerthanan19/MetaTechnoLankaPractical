package com.example.metatechnolankapractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.metatechnolankapractical.Adapter.FuritListAdapter;
import com.example.metatechnolankapractical.Callback.Onclick;
import com.example.metatechnolankapractical.Database.DBUtils;
import com.example.metatechnolankapractical.Object.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Onclick {

    Onclick onclick;
    FuritListAdapter furitListAdapter;
    ArrayList<Data> dataArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onclick = this;

        recyclerView = findViewById(R.id.furitList);

        dataArrayList = DBUtils.getAllData(this);

        LinearLayoutManager ListRecyclerView = new LinearLayoutManager(this); // (Context context)
        furitListAdapter = new FuritListAdapter(this, dataArrayList ,onclick);
        recyclerView.setAdapter(furitListAdapter);
        recyclerView.setLayoutManager(ListRecyclerView);
        ListRecyclerView.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Override
    public void onClick(String ID) {
        Intent intent = new Intent(getBaseContext(), DetailActivity.class);
        intent.putExtra("ID", ID);

        startActivity(intent);
    }
}