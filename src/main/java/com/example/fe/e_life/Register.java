package com.example.fe.e_life;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.view.View;
import android.widget.Button;

/**
 * Created by fe on 15-8-6.
 */
public class Register extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button button=(Button) findViewById(R.id.button3);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Register.this, RegisterSucessfully.class);
                startActivity(intent);

            }
        });
    }
}
