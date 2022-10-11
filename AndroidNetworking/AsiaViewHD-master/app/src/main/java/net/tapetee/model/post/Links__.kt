package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links__ {

    @SerializedName("self")
    @Expose
    var self: List<Self__>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection__>? = null
    @SerializedName("author")
    @Expose
    var author: List<Author__>? = null
    @SerializedName("up")
    @Expose
    var up: List<Up>? = null
    @SerializedName("in-reply-to")
    @Expose
    var inReplyTo: List<InReplyTo>? = null
    @SerializedName("children")
    @Expose
    var children: List<Child>? = null

}
