package co.betterup.betterfeed.presenter

import co.betterup.betterfeed.model.Article


/**
 * This interface will act as a contract between our main feed view and business logic.
 * MVP allows easy separation of concerns by making the Presenter a powerful middle that can be easily tested.
 */

interface MainFeedPresenter {

    fun loadArticles() : ArrayList<Article>
}