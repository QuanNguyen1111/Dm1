package net.tapetee.model.media

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Description {

    @SerializedName("rendered")
    @Expose
    var rendered: String? = null

}
