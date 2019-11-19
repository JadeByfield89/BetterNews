package co.betterup.betterfeed.view

import co.betterup.betterfeed.model.Article

interface MainFeedView {

    fun displayArticlesList(articleList: ArrayList<Article>)

    fun displayArticleWebview(articleLink: String)

    fun showErrorToUser(error: String)

    fun showFavoriteArticles()
}