package net.tapetee.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
        // Check if message contains a notification payload.
        if (p0 != null) {
            if (p0.notification != null) {
                Log.e(
                    "Message", "Message Notification Body: " +
                            p0?.notification!!.body
                );
            }
        }

    }

    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
        Log.e("KEY", p0)
    }

}
