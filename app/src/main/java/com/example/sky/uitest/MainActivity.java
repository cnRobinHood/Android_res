package com.example.sky.uitest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Button mButton0;
    private Button mButton1;
    private EditText mEditText0;
    private EditText mEditText1;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button1);
        mButton0 = (Button) findViewById(R.id.button2);
        mButton1 = (Button) findViewById(R.id.button3);
        mEditText0 = (EditText) findViewById(R.id.name);
        mEditText1 = (EditText) findViewById(R.id.password);
        sharedPreferences = this.getSharedPreferences("myapp", MODE_PRIVATE);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        mButton0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String stringUser = mEditText0.getText().toString();
                String stringPassword = mEditText1.getText().toString();
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                if (stringPassword.equals("") || stringUser.equals("")) {
                    Toast.makeText(MainActivity.this, R.string.text_10, Toast.LENGTH_LONG).show();
                } else if (stringPassword.equals(sharedPreferences.getString(stringUser, ""))) {
                    Toast.makeText(MainActivity.this, R.string.text_6, Toast.LENGTH_LONG).show();
                    startActivity(intent1);
                } else {
                    Toast.makeText(MainActivity.this, R.string.text_7, Toast.LENGTH_LONG).show();
                }
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
