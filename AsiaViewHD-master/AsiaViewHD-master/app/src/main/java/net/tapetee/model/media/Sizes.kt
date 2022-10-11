package net.tapetee.model.media

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sizes {

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: Thumbnail? = null
    @SerializedName("medium")
    @Expose
    var medium: Medium? = null
    @SerializedName("medium_large")
    @Expose
    var mediumLarge: MediumLarge? = null
    @SerializedName("large")
    @Expose
    var large: Large? = null
    @SerializedName("full")
    @Expose
    var full: Full? = null
    @SerializedName("primer-featured")
    @Expose
    var primerFeatured: PrimerFeatured? = null
    @SerializedName("primer-hero")
    @Expose
    var primerHero: PrimerHero? = null

}
