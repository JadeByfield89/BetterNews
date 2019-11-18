package co.betterup.betterfeed.data

import java.net.URL
import java.util.*

/**
 * A single Article. Some sample data for this class can be loaded from the 'assets/articles.json'
 * file. This is just provided as a starting point and this and any other part of this project can
 * be changed in any way you see fit.
 */
data class Article(
    val id: Int,
    val title: String,
    val createdAt: Date,
    val source: String,
    val description: String?,
    val favorite: Boolean,
    val heroImage: URL,
    val link: URL
)