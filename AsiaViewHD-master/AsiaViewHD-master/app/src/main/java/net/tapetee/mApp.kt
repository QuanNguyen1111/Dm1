package net.tapetee

import android.app.Application
import android.os.Handler

class mApp: Application() {


    override fun onCreate() {
        super.onCreate()
    }


    companion object {

        val TAG = Application::class.java
            .simpleName

        @Volatile
        lateinit var applicationHandler: Handler

        @Volatile
        var application: Application? = null
    }



}
