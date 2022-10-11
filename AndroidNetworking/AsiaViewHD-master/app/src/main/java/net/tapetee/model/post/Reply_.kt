package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Reply_ {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("parent")
    @Expose
    var parent: Int? = null
    @SerializedName("author")
    @Expose
    var author: Int? = null
    @SerializedName("author_name")
    @Expose
    var authorName: String? = null
    @SerializedName("author_url")
    @Expose
    var authorUrl: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("content")
    @Expose
    var content: Content_? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null


    @SerializedName("_links")
    @Expose
    var links: Links__? = null

}
