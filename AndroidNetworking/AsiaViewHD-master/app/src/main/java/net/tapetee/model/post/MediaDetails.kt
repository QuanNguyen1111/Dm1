package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MediaDetails {

    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("file")
    @Expose
    var file: String? = null
    @SerializedName("sizes")
    @Expose
    var sizes: Sizes? = null
    @SerializedName("image_meta")
    @Expose
    var imageMeta: ImageMeta? = null

}
