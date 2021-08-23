package com.example.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends IntentService
{
    public MyService(){
        super("my_intent_thread");
    }
    @Override
    protected void onHandleIntent( Intent intent)
    {
        synchronized (this){
        try{
            wait(20000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId)
    {
        Log.e("start",flags+" "+startId);
        Toast.makeText(MyService.this, "service started", Toast.LENGTH_LONG).show();
        Log.e("start",super.onStartCommand(intent, flags, startId)+"");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "service destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
