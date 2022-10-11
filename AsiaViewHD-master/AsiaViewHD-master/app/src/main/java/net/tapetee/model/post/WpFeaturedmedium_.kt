package net.tapetee.model.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WpFeaturedmedium_ {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("title")
    @Expose
    var title: Title_? = null
    @SerializedName("author")
    @Expose
    var author: Int? = null
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
    @SerializedName("source_url")
    @Expose
    var sourceUrl: String? = null
    @SerializedName("_links")
    @Expose
    var links: Links___? = null

}
