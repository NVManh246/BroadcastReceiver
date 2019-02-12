package com.rikkei.broadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_MESSAGE = "msg";
    private static final String MESSAGE_A = "Xin chào A";
    private static final String MESSAGE_SUB_B = "Xin chào Sub b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_a).setOnClickListener(this);
        findViewById(R.id.button_b).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_a:
                Intent intent = new Intent();
                intent.setAction("package_name.CALL_A");
                intent.putExtra(EXTRA_MESSAGE, MESSAGE_A);
                sendBroadcast(intent);
                break;
            case R.id.button_b:
                Intent intentB = new Intent();
                intentB.setAction("package_name.CALL_SUB_B");
                intentB.putExtra(EXTRA_MESSAGE, MESSAGE_SUB_B);
                sendBroadcast(intentB);
                break;
        }
    }
}
