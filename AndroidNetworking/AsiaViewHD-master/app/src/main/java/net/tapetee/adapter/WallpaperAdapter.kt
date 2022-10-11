package net.tapetee.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.tapetee.PhotoPagerActivity
import net.tapetee.R
import net.tapetee.model.media.Wallpaper

class WallpaperAdapter(private var context: Context, private var listWall: List<Wallpaper>) :


    RecyclerView.Adapter<WallpaperHolder>() {
    companion object {
        var listWallpaper: List<Wallpaper>? = null
    }

    var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        return WallpaperHolder(LayoutInflater.from(context).inflate(R.layout.wallpaper, parent, false))
    }

    override fun getItemCount(): Int {
        return listWall.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {

        Glide.with(context).load(listWall[position].mediaDetails?.sizes?.full?.sourceUrl).into(holder.imgWall)
        holder.itemView.setOnClickListener {

            val intent = Intent(context, PhotoPagerActivity::class.java)
            intent.putExtra("position",position)
            intent.putExtra("count",count)
            listWallpaper = listWall
            context.startActivity(intent)

        }

    }

}

class WallpaperHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imgWall: ImageView = itemView.findViewById(R.id.imgWall)


}
