package com.example.demo6;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseToken extends FirebaseMessagingService{

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
       Log.e("'aaa" ,s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.e("DATA", remoteMessage.getMessageId());
        Log.e("DATA",remoteMessage.getFrom());
    }
}
