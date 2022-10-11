package net.tapetee.download

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import java.io.File
import android.content.Context.DOWNLOAD_SERVICE
import androidx.core.content.ContextCompat.getSystemService


class AsianDownloader {


    fun showDownload(context: Context, url: String) {

        val file = File(context.getExternalFilesDir(null), "Dummy")
        /*
       Create a DownloadManager.Request with all the information necessary to start the download
        */
        val request =
            DownloadManager.Request(Uri.parse(url))
                .setTitle("Dummy File")// Title of the Download Notification
                .setDescription("Downloading")// Description of the Download Notification
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)// Visibility of the download Notification
                .setDestinationUri(Uri.fromFile(file))// Uri of the destination file
                .setAllowedOverRoaming(true)// Set if download is allowed on roaming network

        val downloadManager = context.getSystemService(DOWNLOAD_SERVICE) as DownloadManager?
        var downloadID = downloadManager!!.enqueue(request)// enqueue puts the download request in the queue.
        
    }


}