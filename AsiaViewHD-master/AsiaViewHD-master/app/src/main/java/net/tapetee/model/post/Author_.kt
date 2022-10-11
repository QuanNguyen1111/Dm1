package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Author_ {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("_links")
    @Expose
    var links: Links_? = null

}
