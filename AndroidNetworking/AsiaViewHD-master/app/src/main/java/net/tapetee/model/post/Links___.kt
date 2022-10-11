package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links___ {

    @SerializedName("self")
    @Expose
    var self: List<Self___>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection___>? = null
    @SerializedName("about")
    @Expose
    var about: List<About_>? = null
    @SerializedName("author")
    @Expose
    var author: List<Author___>? = null
    @SerializedName("replies")
    @Expose
    var replies: List<Reply__>? = null

}
