package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links____ {

    @SerializedName("self")
    @Expose
    var self: List<Self____>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection____>? = null
    @SerializedName("about")
    @Expose
    var about: List<About__>? = null
    @SerializedName("wp:post_type")
    @Expose
    var wpPostType: List<WpPostType>? = null
    @SerializedName("curies")
    @Expose
    var curies: List<Cury_>? = null

}
