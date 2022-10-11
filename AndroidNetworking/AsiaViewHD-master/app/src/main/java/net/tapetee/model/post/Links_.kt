package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links_ {

    @SerializedName("self")
    @Expose
    var self: List<Self_>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection_>? = null

}
