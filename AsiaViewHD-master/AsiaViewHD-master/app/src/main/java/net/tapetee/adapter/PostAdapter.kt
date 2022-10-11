package net.tapetee.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.tapetee.R
import net.tapetee.fragment.ItemFragment
import net.tapetee.model.post.Post


class PostAdapter(
    private var context: Context,
    private var list: List<Post>,private val mListener: ItemFragment.OnListFragmentInteractionListener?
) : RecyclerView.Adapter<PostHolder>() {


    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Post
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        Glide.with(context).load(list.get(position).embedded?.wpFeaturedmedia?.get(0)?.sourceUrl).into(holder.imgThumb)
        with(holder.mView) {
            tag = list[position]
            setOnClickListener(mOnClickListener)
        }
    }
}



