package net.tapetee

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.android.synthetic.main.content_post.*
import net.tapetee.adapter.WallpaperAdapter
import net.tapetee.model.media.Wallpaper
import net.tapetee.retrofit.AsiaRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity(), Callback<Collection<Wallpaper>> {

    override fun onFailure(call: Call<Collection<Wallpaper>>, t: Throwable) {

    }

    override fun onResponse(call: Call<Collection<Wallpaper>>, response: Response<Collection<Wallpaper>>) {
        listWall?.addAll(response.body()!!)

        wallAdapter?.count = response.body()!!.size

        lvListMedia.adapter?.notifyDataSetChanged()
        swipeToRefresh.isRefreshing = false
        swipeToRefresh.isEnabled = false

    }

    private var page = 1;
    private val perPage = 10;


    private var wallAdapter: WallpaperAdapter? = null
    private var listWall: ArrayList<Wallpaper>? = null
    private var layoutManager: LinearLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initData()


        val title = intent.getStringExtra("name")
        supportActionBar?.title = title


        val id = intent.getIntExtra("data", -1);
        if (id > 0) {
            AsiaRetrofit.create().getMediaOfPost(id, page, perPage).enqueue(this)
        }

        swipeToRefresh.setOnRefreshListener {
            if (id > 0) {
                page = 1
                listWall = ArrayList()
                AsiaRetrofit.create().getMediaOfPost(id, page, perPage).enqueue(this)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData() {

        listWall = ArrayList()
        layoutManager = LinearLayoutManager(this)
        wallAdapter = WallpaperAdapter(this, listWall as ArrayList<Wallpaper>)


        lvListMedia.adapter = wallAdapter;
        var mana: StaggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mana.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        lvListMedia.layoutManager = mana
        lvListMedia.setHasFixedSize(true)
        swipeToRefresh.isRefreshing = true

    }
}
