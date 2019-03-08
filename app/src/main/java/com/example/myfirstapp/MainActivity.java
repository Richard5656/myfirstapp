package com.example.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    Button btn_one;
    Button button_to_signin;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find my view
        btn_one = (Button) findViewById(R.id.btn_one);
        button_to_signin = (Button) findViewById(R.id.button_to_signin);

        dialog = new AlertDialog.Builder(this).setTitle("my dialog")
                .setMessage("sure to quit?")
                .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"haha", Toast.LENGTH_SHORT).show();
                            }
                        }
                )
                .setNegativeButton("no", null)
                .create();
        dialog.show();

        button_to_signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                button_to_signin.setText("clicked ");
                Intent intent = new Intent(MainActivity. this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void click_btn_one(View view) {
        if (btn_one.getText() == "我被你点击了") {
            btn_one.setText("按钮1");
        } else {
            btn_one.setText("我被你点击了");
        }
    }

}
