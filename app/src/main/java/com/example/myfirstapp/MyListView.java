package com.example.myfirstapp;

import android.Manifest;
import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyListView extends AppCompatActivity {

    ListView lv_myListView;

    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
        this.initView();
        this.initVar();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.items_myfirstview, R.id.tv_item, names);
        lv_myListView.setAdapter(arrayAdapter);
    }

    void initView() {
        lv_myListView = (ListView) findViewById(R.id.lv_myListView);
    }
    void initVar() {
        names = new String[]{"QQ", "wechat", "tiktok", "sogou", "whatsapp", "line"};
    }
}



