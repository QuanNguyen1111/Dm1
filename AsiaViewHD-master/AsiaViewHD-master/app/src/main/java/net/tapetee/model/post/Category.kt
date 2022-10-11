package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("taxonomy")
    @Expose
    var taxonomy: String? = null
    @SerializedName("parent")
    @Expose
    var parent: Int? = null
    @SerializedName("meta")
    @Expose
    var meta: List<Any>? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}
