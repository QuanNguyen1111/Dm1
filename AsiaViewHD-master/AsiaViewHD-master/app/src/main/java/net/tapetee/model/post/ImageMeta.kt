package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageMeta {

    @SerializedName("aperture")
    @Expose
    var aperture: String? = null
    @SerializedName("credit")
    @Expose
    var credit: String? = null
    @SerializedName("camera")
    @Expose
    var camera: String? = null
    @SerializedName("caption")
    @Expose
    var caption: String? = null
    @SerializedName("created_timestamp")
    @Expose
    var createdTimestamp: String? = null
    @SerializedName("copyright")
    @Expose
    var copyright: String? = null
    @SerializedName("focal_length")
    @Expose
    var focalLength: String? = null
    @SerializedName("iso")
    @Expose
    var iso: String? = null
    @SerializedName("shutter_speed")
    @Expose
    var shutterSpeed: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("orientation")
    @Expose
    var orientation: String? = null
    @SerializedName("keywords")
    @Expose
    var keywords: List<Any>? = null

}
