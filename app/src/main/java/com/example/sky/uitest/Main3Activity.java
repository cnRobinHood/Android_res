package com.example.sky.uitest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private Button mButton;
    private EditText meditText0;
    private EditText meditText1;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mButton = (Button) findViewById(R.id.button4);
        meditText0 = (EditText) findViewById(R.id.registname);
        meditText1 = (EditText) findViewById(R.id.registpassword);
        sharedPreferences = this.getSharedPreferences("myapp", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (meditText0.getText().toString().equals("") || meditText1.getText().toString().equals("")) {
                    Toast.makeText(Main3Activity.this, R.string.text_9, Toast.LENGTH_LONG).show();
                }else if (sharedPreferences.contains(meditText0.getText().toString())){
                    Toast.makeText(Main3Activity.this,R.string.text_11,Toast.LENGTH_LONG).show();
                }
                else {
                    editor.putString(meditText0.getText().toString(), meditText1.getText().toString());
                    editor.commit();
                    Toast.makeText(Main3Activity.this, R.string.text_8, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
