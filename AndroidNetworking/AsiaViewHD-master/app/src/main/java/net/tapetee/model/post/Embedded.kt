package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Embedded {

    @SerializedName("author")
    @Expose
    var author: List<Author_>? = null
    @SerializedName("replies")
    @Expose
    var replies: List<List<Reply_>>? = null
    @SerializedName("wp:featuredmedia")
    @Expose
    var wpFeaturedmedia: List<WpFeaturedmedium_>? = null
    @SerializedName("wp:term")
    @Expose
    var wpTerm: List<List<WpTerm_>>? = null

}
