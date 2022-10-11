package net.tapetee.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.fragment_item_list.*
import net.tapetee.adapter.PostAdapter

import net.tapetee.model.post.Post
import net.tapetee.retrofit.AsiaRetrofit
import net.tapetee.view.EndlessRecyclerViewScrollListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList
import androidx.core.os.HandlerCompat.postDelayed
import android.os.Handler
import net.tapetee.R
import net.tapetee.view.GridItemDecoration


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ItemFragment.OnListFragmentInteractionListener] interface.
 */
class ItemFragment : Fragment(), Callback<Collection<Post>> {


    private var page = 1
    private val perPage = 10
    private var listPost: ArrayList<Post>? = null
    private var callBack: Callback<Collection<Post>>? = null


    private var layoutManager: StaggeredGridLayoutManager?? = null


    override fun onFailure(call: Call<Collection<Post>>, t: Throwable) {
        swipeToRefresh?.isRefreshing = false
    }

    override fun onResponse(call: Call<Collection<Post>>, response: Response<Collection<Post>>) {
        swipeToRefresh?.isRefreshing = false
        if (response.body() != null) {

            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            layoutManager!!.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE

            listPost?.addAll(response.body()!!)
            list.adapter?.notifyDataSetChanged()

        } else {
            list.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager!!) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {

                }
            })
        }
    }


    private fun initData() {

        listPost = ArrayList()
        list.adapter = PostAdapter(context!!, listPost as ArrayList<Post>, listener)

        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager!!.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        list.layoutManager = layoutManager
        //This will for default android divider
        list.addItemDecoration(GridItemDecoration(10, 2))


        callBack = this

    }


    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }


    var catId: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData();

        arguments?.let {
            catId = arguments?.getString("catId")!!
        }


        swipeToRefresh.isRefreshing = true

        swipeToRefresh.setOnRefreshListener {

            page = 1

            listPost?.clear()
            list.adapter?.notifyDataSetChanged()

            AsiaRetrofit.create().getLatestPost(catId, page, perPage).enqueue(this)

        }

        AsiaRetrofit.create().getLatestPost(catId, page, perPage).enqueue(this)
//        list.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager!!) {
//            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
//                this@ItemFragment.page++
//                AsiaRetrofit.create().getLatestPost(page, perPage).enqueue((callBack))
//
//            }
//        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Post?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
