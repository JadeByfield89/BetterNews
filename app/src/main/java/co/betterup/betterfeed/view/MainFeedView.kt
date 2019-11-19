package co.betterup.betterfeed.view

interface MainFeedView {

    fun displayArticlesList()

    fun displayArticleWebview(articleLink: String)

    fun showErrorToUser(error: String)

    fun showFavoriteArticles()
}