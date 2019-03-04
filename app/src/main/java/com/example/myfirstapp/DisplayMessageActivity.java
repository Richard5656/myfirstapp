package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity implements View.OnClickListener {

    //声明要用到的view对象
    Button btn_test_onclicklistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        btn_test_onclicklistener = (Button) findViewById(R.id.btn_test_onclicklistener);
        btn_test_onclicklistener.setOnClickListener(this);
        //这里先findview，找出相应对象
        //然后给对象设置监听者为自己，因为自己这个类实现了那个接口

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_onclicklistener:
                btn_test_onclicklistener.setText("我被你点击了");
        }
    }
}
