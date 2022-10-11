package net.tapetee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_photo_pager.*
import kotlinx.android.synthetic.main.category.*
import kotlinx.android.synthetic.main.download_dialog.*
import net.tapetee.adapter.WallpaperAdapter
import net.tapetee.download.AsianDownloader
import net.tapetee.model.media.Wallpaper
import net.tapetee.ui.main.SectionsPagerAdapter

class PhotoPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_pager)

        val count = intent.getIntExtra("count", -1)

        supportActionBar?.title = count.toString()

        val position = intent.getIntExtra("position", -1)

        tvTitleCount.text = (position.toString().plus("/").plus(count.toString()))


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, WallpaperAdapter.listWallpaper)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        viewPager.setCurrentItem(position)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tvTitleCount.text = (position.plus(1).toString().plus("/").plus(count.toString()))
            }

        })

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->

            val downloadDialog: AlertDialog.Builder = AlertDialog.Builder(this@PhotoPagerActivity)

            downloadDialog.setView(R.layout.download_dialog)
            var alertView: AlertDialog = downloadDialog.show()


            var full = alertView.findViewById<TextView>(R.id.full)
            var large = alertView.findViewById<TextView>(R.id.large)
            var mediumLarge = alertView.findViewById<TextView>(R.id.mediumLarge)
            var medium = alertView.findViewById<TextView>(R.id.medium)
            var thumbnail = alertView.findViewById<TextView>(R.id.thumbnail)

            var wallpaper: Wallpaper? = WallpaperAdapter.listWallpaper?.get(view_pager.currentItem)

            var downloadManager = AsianDownloader()

            wallpaper?.mediaDetails?.sizes?.full?.let {
                full?.visibility = View.VISIBLE
                full?.text = wallpaper?.mediaDetails?.sizes?.full?.height.toString().plus("x")
                    .plus(wallpaper?.mediaDetails?.sizes?.full?.width.toString())


                full?.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        downloadManager.showDownload(
                            this@PhotoPagerActivity,
                            wallpaper?.mediaDetails?.sizes?.full?.sourceUrl!!
                        )
                    }
                })
            }
            wallpaper?.mediaDetails?.sizes?.large?.let {
                large?.visibility = View.VISIBLE
                large?.text = wallpaper?.mediaDetails?.sizes?.large?.height.toString().plus("x")
                    .plus(wallpaper?.mediaDetails?.sizes?.large?.width.toString())
            }
            wallpaper?.mediaDetails?.sizes?.mediumLarge?.let {
                mediumLarge?.visibility = View.VISIBLE
                mediumLarge?.text = wallpaper?.mediaDetails?.sizes?.mediumLarge?.height.toString().plus("x")
                    .plus(wallpaper?.mediaDetails?.sizes?.mediumLarge?.width.toString())
            }
            wallpaper?.mediaDetails?.sizes?.medium?.let {
                medium?.visibility = View.VISIBLE
                medium?.text = wallpaper?.mediaDetails?.sizes?.medium?.height.toString().plus("x")
                    .plus(wallpaper?.mediaDetails?.sizes?.medium?.width.toString())
            }
            wallpaper?.mediaDetails?.sizes?.thumbnail?.let {
                thumbnail?.visibility = View.VISIBLE
                thumbnail?.text = wallpaper?.mediaDetails?.sizes?.thumbnail?.height.toString().plus("x")
                    .plus(wallpaper?.mediaDetails?.sizes?.thumbnail?.width.toString())
            }


        }
    }
}