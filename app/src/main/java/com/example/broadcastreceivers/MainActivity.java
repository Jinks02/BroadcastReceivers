package com.example.broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ConnectivityReceiver receiver;
    IntentFilter intentFilter;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new ConnectivityReceiver();
        intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver,intentFilter);

        btn = findViewById(R.id.button2);
        btn.setOnClickListener(view -> Toast.makeText(MainActivity.this,"Custom Intent Detected",Toast.LENGTH_SHORT).show());
    }
    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.teqip3.broadcastreceiver.CUSTOM_MESSAGE ");
        sendBroadcast(intent);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
