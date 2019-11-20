package co.betterup.betterfeed.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.betterup.betterfeed.R
import co.betterup.betterfeed.adapter.FeedAdapter
import co.betterup.betterfeed.application.BetterNewsApplication
import co.betterup.betterfeed.constant.FEEDTYPE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_favorite_articles.view.*


class FavoriteArticlesFragment : Fragment(), FavoriteArticlesView {

    companion object {
        fun newInstance(): FavoriteArticlesFragment {

            return FavoriteArticlesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return LayoutInflater.from(activity).inflate(R.layout.fragment_favorite_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFavoriteArticles()
    }

    // Get the list of favorite articles from the application's state, and let's show them to the user
    override fun showFavoriteArticles() {
        if(BetterNewsApplication.favoriteArticles.size == 0){
            view?.favorites_empty_text?.visibility = View.VISIBLE
        }

        else {
            view?.favorites_empty_text?.visibility = View.INVISIBLE
            view?.favoritesList?.layoutManager = LinearLayoutManager(activity)
            view?.favoritesList?.adapter = FeedAdapter(
                BetterNewsApplication.favoriteArticles,
                context,
                FEEDTYPE.FAVORITES,
               object: FeedAdapter.OnArticleSelectedListener {

                   override fun onArticleSelected(articleLink: String) {
                       activity?.toolbar?.toolbar_title?.setText("Article Detail")
                       val webviewFragment = ArticleWebViewFragment.newInstance(articleLink)
                       val fragmentManager = activity?.supportFragmentManager
                       fragmentManager?.beginTransaction()
                           ?.add(R.id.main_content, webviewFragment, "article_webview_fragment")
                           ?.addToBackStack("article_webview_fragment")?.commit()
                   }
               })
        }
    }


}