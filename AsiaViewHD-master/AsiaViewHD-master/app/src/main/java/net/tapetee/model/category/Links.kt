package net.tapetee.model.category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("self")
    @Expose
    var self: List<Self>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection>? = null
    @SerializedName("about")
    @Expose
    var about: List<About>? = null
    @SerializedName("wp:post_type")
    @Expose
    var wpPostType: List<WpPostType>? = null
    @SerializedName("curies")
    @Expose
    var curies: List<Cury>? = null

}
