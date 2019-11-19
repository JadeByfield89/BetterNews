package co.betterup.betterfeed.model

import com.google.gson.annotations.SerializedName
import java.net.URL
import java.util.*

/**
 * Data class representing a single Article. We will use GSON to marshall this class to and from JSON
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