package com.example.fe.e_life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SlidingDrawer;



/**
 * Created by fe on 15-8-7.
 */
public class Study extends Activity {

    private SlidingDrawer sd;
    private ImageView im;
    private ImageButton cet4button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study);

        sd=(SlidingDrawer) findViewById(R.id.drawer1);
        im=(ImageView) findViewById(R.id.myimage);
        sd.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                im.setImageResource(R.drawable.classification);
            }
        });
        sd.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                im.setImageResource(R.drawable.classification);
            }
        });


        cet4button =(ImageButton)sd.findViewById(R.id.cet4);
        cet4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Study.this, Cet4.class);
                startActivity(intent);
            }
        });

        ImageButton cet6button=(ImageButton) findViewById(R.id.cet6);
        cet6button.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Study.this, Cet6.class);
                startActivity(intent);

            }
        });

        ImageButton toeflbutton=(ImageButton) findViewById(R.id.toefl);
        toeflbutton.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Study.this, TOEFL.class);
                startActivity(intent);

            }
        });

        ImageButton ieltsbutton=(ImageButton) findViewById(R.id.ielts);
        ieltsbutton.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Study.this, IELTS.class);
                startActivity(intent);

            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}