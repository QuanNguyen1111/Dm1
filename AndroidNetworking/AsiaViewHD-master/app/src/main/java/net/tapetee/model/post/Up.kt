package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Up {

    @SerializedName("embeddable")
    @Expose
    var embeddable: Boolean? = null
    @SerializedName("post_type")
    @Expose
    var postType: String? = null
    @SerializedName("href")
    @Expose
    var href: String? = null

}
