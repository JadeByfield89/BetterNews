package co.betterup.betterfeed.application

import android.app.Application
import android.content.Context
import android.util.Log
import co.betterup.betterfeed.model.Article


class BetterNewsApplication : Application() {


    init {
        instance = this
    }

    companion object {
        private val favoriteArticles = ArrayList<Article>()
        private var instance: BetterNewsApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun isArticleAFavorite(article: Article): Boolean {

            if(favoriteArticles.contains(article)){
                return true
            }

            return false
        }

        fun addArticleToFavorites(article: Article){

            if(!favoriteArticles.contains(article)){
                favoriteArticles.add(article)
            }

            Log.d("BetterNewsApplication", "Added article " + article.id + " to favorites")
            Log.d("BetterNewsApplication", "Favorites list size => : " + favoriteArticles.size)
        }

        fun removeArticleFromFavorites(article: Article){

            if(favoriteArticles.contains(article)){
                favoriteArticles.remove(article)
            }


            Log.d("BetterNewsApplication", "Removed article " + article.id + " from favorites")
            Log.d("BetterNewsApplication", "Favorites list size => : " + favoriteArticles.size)
        }
    }

    override fun onCreate() {
        super.onCreate()

    }


}