package com.example.sky.uitest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private Button button;
    private EditText editTextUser;
    private EditText editTextPassword;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button = (Button) findViewById(R.id.button5);
        editTextUser = (EditText) findViewById(R.id.findname);
        editTextPassword = (EditText) findViewById(R.id.findpassword);
        sharedPreferences = this.getSharedPreferences("myapp", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUser.getText().toString().equals("")) {
                    Toast.makeText(Main4Activity.this, R.string.text_14, Toast.LENGTH_LONG).show();
                }else if (!sharedPreferences.contains(editTextUser.getText().toString())){
                    Toast.makeText(Main4Activity.this,R.string.text_15,Toast.LENGTH_LONG).show();
                }
                else {
                    editor.remove(editTextUser.getText().toString());
                    editor.putString(editTextUser.getText().toString(), editTextPassword.getText().toString());
                    editor.commit();
                    Toast.makeText(Main4Activity.this, R.string.text_16, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
