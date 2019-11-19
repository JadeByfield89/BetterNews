package co.betterup.betterfeed.application

import android.app.Application
import android.content.Context
import co.betterup.betterfeed.model.Article

/**
 * Since we don't need any data to persist between app launches for this project, using SharedPreferences is not necessary.
 * We can just store app state data(in this case, a user's favorites) in our custom Application class here.
 */
class BetterNewsApplication : Application() {


    init {
        instance = this
    }

    companion object {
        val favoriteArticles = ArrayList<Article>()
        private var instance: BetterNewsApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun isArticleAFavorite(article: Article): Boolean {

            if (favoriteArticles.contains(article)) {
                return true
            }

            return false
        }

        fun addArticleToFavorites(article: Article) {

            if (!favoriteArticles.contains(article)) {
                favoriteArticles.add(article)
            }

        }

        fun removeArticleFromFavorites(article: Article) {

            if (favoriteArticles.contains(article)) {
                favoriteArticles.remove(article)
            }

        }

    }


}