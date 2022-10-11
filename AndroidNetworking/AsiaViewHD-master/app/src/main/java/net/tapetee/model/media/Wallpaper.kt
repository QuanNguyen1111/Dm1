package net.tapetee.model.media

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wallpaper {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("date_gmt")
    @Expose
    var dateGmt: String? = null
    @SerializedName("guid")
    @Expose
    var guid: Guid? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("modified_gmt")
    @Expose
    var modifiedGmt: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("title")
    @Expose
    var title: Title? = null
    @SerializedName("author")
    @Expose
    var author: Int? = null
    @SerializedName("comment_status")
    @Expose
    var commentStatus: String? = null
    @SerializedName("ping_status")
    @Expose
    var pingStatus: String? = null
    @SerializedName("template")
    @Expose
    var template: String? = null
    @SerializedName("meta")
    @Expose
    var meta: List<Any>? = null
    @SerializedName("description")
    @Expose
    var description: Description? = null
    @SerializedName("caption")
    @Expose
    var caption: Caption? = null
    @SerializedName("alt_text")
    @Expose
    var altText: String? = null
    @SerializedName("media_type")
    @Expose
    var mediaType: String? = null
    @SerializedName("mime_type")
    @Expose
    var mimeType: String? = null
    @SerializedName("media_details")
    @Expose
    var mediaDetails: MediaDetails? = null
    @SerializedName("post")
    @Expose
    var post: Int? = null
    @SerializedName("source_url")
    @Expose
    var sourceUrl: String? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}
