package net.tapetee.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import net.tapetee.R

class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mView: View = itemView
    var imgThumb : ImageView = itemView.findViewById(R.id.imgThumb)


}
