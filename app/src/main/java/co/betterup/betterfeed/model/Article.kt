package co.betterup.betterfeed.model

import com.google.gson.annotations.SerializedName
import java.net.URL
import java.util.*

/**
 * A single Article. Some sample data for this class can be loaded from the 'assets/articles.json'
 * file. This is just provided as a starting point and this and any other part of this project can
 * be changed in any way you see fit.
 */
data class Article(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("source") val source: String,
    @SerializedName("description") val description: String?,
    @SerializedName("favorite") val favorite: Boolean,
    @SerializedName("hero_image") val heroImage: URL,
    @SerializedName("link") val link: URL
)