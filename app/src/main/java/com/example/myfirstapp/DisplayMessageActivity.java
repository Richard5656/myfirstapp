package com.example.myfirstapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity implements View.OnClickListener {

    //声明要用到的view对象
    Button btn_test_onclicklistener;
    Button button_openbrowser;
    RadioGroup radioGroup_one;
    TextView textView_sexual;
    ProgressDialog progressDialog;
    Button btn_toListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        final TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        //这里先findview，找出相应对象
        btn_test_onclicklistener = (Button) findViewById(R.id.btn_test_onclicklistener);
        button_openbrowser = (Button) findViewById(R.id.button_openbrowser);
        radioGroup_one = (RadioGroup) findViewById(R.id.radio_button_group_one);
        btn_toListView = (Button) findViewById(R.id.btn_toListView);
        btn_test_onclicklistener.setOnClickListener(this);
        button_openbrowser.setOnClickListener(this);
        textView_sexual =(TextView) findViewById(R.id.textview_sexual);
        radioGroup_one.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i == R.id.radio_button_one) {
                            textView_sexual.setText("your sexual is man");
                        } else {
                            textView_sexual.setText("your sexual is women");
                        }
                    }
                }
        );

        btn_toListView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //open listview;
                        Intent intent1 = new Intent(DisplayMessageActivity.this, MyListView.class);
                        startActivity(intent1);
                    }
                }
        );

        //然后给对象设置监听者为自己，因为自己这个类实现了那个接口
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("is downloading");
        progressDialog.setMessage("please wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        Toast.makeText(this,"aloha ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_openbrowser:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse("www.baidu.com"));
                startActivity(intent);
            case R.id.btn_test_onclicklistener:
                btn_test_onclicklistener.setText("我被你点击了");
        }
    }

}
