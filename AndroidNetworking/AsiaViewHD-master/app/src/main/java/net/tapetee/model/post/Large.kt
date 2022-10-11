package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Large {

    @SerializedName("file")
    @Expose
    var file: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("mime_type")
    @Expose
    var mimeType: String? = null
    @SerializedName("source_url")
    @Expose
    var sourceUrl: String? = null

}
