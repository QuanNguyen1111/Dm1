package net.tapetee.model.media

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
    @SerializedName("author")
    @Expose
    var author: List<Author>? = null
    @SerializedName("replies")
    @Expose
    var replies: List<Reply>? = null

}
