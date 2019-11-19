package co.betterup.betterfeed.presenter

import android.util.Log
import co.betterup.betterfeed.application.BetterNewsApplication
import co.betterup.betterfeed.model.Article
import co.betterup.betterfeed.presenter.MainFeedPresenter
import co.betterup.betterfeed.view.MainFeedView
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainFeedPresenterImpl(val view: MainFeedView) : MainFeedPresenter {


    override fun loadArticles(): ArrayList<Article>{

        val articles = ArrayList<Article>()
        val jsonString = BetterNewsApplication.applicationContext().assets.open("articles.json").bufferedReader().use { it.readText() }
        Log.d("MainFeedPresenterImpl", "New Article String => : " + jsonString)


        val gson = Gson()
        val jsonObject = JSONObject(jsonString)
        val jsonArray = jsonObject.getJSONArray("articles")


        for (i in 0 until jsonArray.length()){

            val articleJsonObject = jsonArray.getJSONObject(i)

            // Convert each article string to an Article model object
            val articleObject = gson.fromJson(articleJsonObject.toString(), Article::class.java)

            articles.add(articleObject)
            Log.d("MainFeedPresenterImpl", "Article " + i + "added to list")

        }

        Log.d("MainFeedPresenterImpl", "List size => " + articles.size)





        return articles
        // Call view to display articles list once they've completed parsing
    }

}
