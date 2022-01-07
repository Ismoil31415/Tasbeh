package com.example.tasbeh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity {
    TextView subhanAllah;
    String Tasbeh = "SubhanAllah";
    int count = 0;
    int count1;
    final String LOG_TAG = "myLogs";
    ImageButton finger;
    Vibrator vibrator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("TASBEEH COUNTER");
        setContentView(R.layout.activity_main);
        finger = findViewById(R.id.finger);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        if (savedInstanceState != null) {
            Tasbeh = savedInstanceState.getString("Alloh");
            count = savedInstanceState.getInt("count");
            count1 = savedInstanceState.getInt("count1");
        }
        Log.d(LOG_TAG, "onCreate");

        finger = findViewById(R.id.finger);
        subhanAllah = findViewById(R.id.subhanAllah);
        subhanAllah.setText(Tasbeh);
        TextView textView = findViewById(R.id.tv_sum);
        textView.setText(String.valueOf(count));
        finger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.layout);
                finger.startAnimation(animation);
                String zikr1 = "SubhanAllah";
                String zikr2 = "Alhamdulillah";
                String zikr3 = "Allohu Akbar";
                count++;
                if (count == 33) {
                    count = 0;
                    count1++;
                    if (count1 == 1) {
                        subhanAllah.setText(zikr2);
                    } else if (count1 == 2) {
                        subhanAllah.setText(zikr3);
                    } else {
                        count1 = 0;
                        subhanAllah.setText(zikr1);
                    }
                }
                textView.setText("" + count);
            }
        });


    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    protected void onRestart() {
        super.onRestart();

        Log.d(LOG_TAG, "onRestart");
    }



    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        outState.putInt("count1", count1);
        outState.putString("Alloh", subhanAllah.getText().toString());
        Log.d(LOG_TAG, "onSaveInstanceState");
    }


}
