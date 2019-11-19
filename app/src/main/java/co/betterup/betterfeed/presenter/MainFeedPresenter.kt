package co.betterup.betterfeed.presenter

import co.betterup.betterfeed.model.Article


/**
 * This interface will act as a contract between our MainFeedView and business logic.
 * MVP allows easy separation of concerns by making the Presenter a powerful middle that can be easily tested.
 *
 * The main feed has a presenter because it needs to respond to user input, manipulate the data layer,
 * and then tell the View when to update.
 */

interface MainFeedPresenter {

    fun loadArticles() : ArrayList<Article>
}