package net.tapetee.retrofit

import net.tapetee.model.category.Category
import net.tapetee.model.media.Wallpaper
import net.tapetee.model.post.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AsiaService {

    //http://asian.dotplays.com/wp-json/wp/v2/posts?_embed
    // get latest post or get post in category

    @GET("wp-json/wp/v2/posts?_embed")
    fun getLatestPost(@Query("categories") category: String, @Query("page") page: Int, @Query("per_page") per_page: Int): Call<Collection<Post>>


    //http://asian.dotplays.com/wp-json/wp/v2/media?parent=524
    @GET("wp-json/wp/v2/media")
    fun getMediaOfPost(@Query("parent") parent: Int, @Query("page") page: Int, @Query("per_page") per_page: Int):
            Call<Collection<Wallpaper>>


    //
    @GET("wp-json/wp/v2/categories")
    fun getCategories(@Query("page") page: Int, @Query("per_page") per_page: Int): Call<Collection<Category>>
}