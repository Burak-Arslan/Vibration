package com.example.burakarslan.vibration;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Vibrator vibrator;
    Button btnYarimSaniye, btnTitresim, btnBelirliAraliklarlas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Events();
    }

    public void Init() {
        try {

            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            btnYarimSaniye = (Button) findViewById(R.id.btnYarimSaniye);
            btnTitresim = (Button) findViewById(R.id.btnTitresim);
            btnBelirliAraliklarlas = (Button) findViewById(R.id.btnBelirliAraliklarlaTitrets);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void Events() {
        try {

            btnYarimSaniye.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vibrator.vibrate(500);
                }
            });

            btnTitresim.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    int action = event.getAction();

                    if (action == MotionEvent.ACTION_DOWN) {

                        vibrator.vibrate(1000);

                    } else if (action == MotionEvent.ACTION_UP) {
                        vibrator.cancel();
                    }
                    return false;
                }
            });

            btnBelirliAraliklarlas.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    int action = event.getAction();
                    if (action == MotionEvent.ACTION_DOWN) {

                        long[] pat = {100, 100, 100, 100, 5000};
                        vibrator.vibrate(pat, 0);

                    } else if (action == MotionEvent.ACTION_UP) {
                        vibrator.cancel();
                    }
                    return true;
                }
            });
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
