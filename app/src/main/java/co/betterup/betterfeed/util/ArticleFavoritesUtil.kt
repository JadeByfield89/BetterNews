package co.betterup.betterfeed.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class ArticleFavoritesUtil(val context: Context) {

    val sharedPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val PREF_ARTICLE_FAVORITE = "article_favorite"

    fun addArticleToFavorites(id: Int){
        val editor = sharedPrefs.edit()

        editor.putInt(PREF_ARTICLE_FAVORITE, id)
        editor.commit()
        editor.apply()
    }


    fun isArticleAFavorite(id: Int): Boolean {

       if(sharedPrefs.getInt(PREF_ARTICLE_FAVORITE, id) != 0){

           return true
       }

        return false
    }

}