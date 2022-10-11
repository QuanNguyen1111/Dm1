package net.tapetee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_list_post.*
import net.tapetee.fragment.ItemFragment
import net.tapetee.model.post.Post

class ListPostActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener {


    override fun onListFragmentInteraction(item: Post?) {

        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra("data", item?.id)
        intent.putExtra("name", item?.title?.rendered)
        startActivity(intent)

    }


    var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_post)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        id = intent.getStringExtra("catId")

        val title = intent.getStringExtra("title")

        title.let {
            supportActionBar?.title = title
        }

        var itemFragment = ItemFragment()

        val bundle = Bundle()
        bundle.putString("catId", id)

        itemFragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(
            R.id.my_container,
            itemFragment
        ).commit()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
