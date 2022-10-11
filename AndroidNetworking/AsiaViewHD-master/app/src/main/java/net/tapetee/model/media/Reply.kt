package net.tapetee.model.media

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Reply {

    @SerializedName("embeddable")
    @Expose
    var embeddable: Boolean? = null
    @SerializedName("href")
    @Expose
    var href: String? = null

}
