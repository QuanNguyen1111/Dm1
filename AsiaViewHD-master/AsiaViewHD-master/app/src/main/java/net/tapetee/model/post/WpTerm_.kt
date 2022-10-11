package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WpTerm_ {

    @SerializedName("id")
    @Expose
    var id: Int? = null
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
    @SerializedName("_links")
    @Expose
    var links: Links____? = null

}
