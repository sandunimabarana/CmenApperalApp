package com.example.cmenapperalapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ApperalList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Apperal> list;
    ApperalListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apperal_list_activity);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ApperalListAdapter(this, R.layout.aperalitems, list);
        gridView.setAdapter(adapter);

        //get all data from sqlite
        Cursor cursor = MainActivity.sqlIteHelper.getData("SELECT * FROM APPERAL");
        list.clear();
        while (cursor.moveToNext()){
              int id = cursor.getInt(0);
              String name = cursor.getString(1);
              String price = cursor.getString(2);
              byte[] image = cursor.getBlob(3);

              list.add(new Apperal(id, name, price, image));
        }
        adapter.notifyDataSetChanged();

    }
}
