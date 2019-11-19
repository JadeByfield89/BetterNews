package co.betterup.betterfeed.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.betterup.betterfeed.R
import co.betterup.betterfeed.adapter.FeedAdapter
import co.betterup.betterfeed.constant.FEEDTYPE
import co.betterup.betterfeed.model.Article
import co.betterup.betterfeed.presenter.MainFeedPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


/**
 * This MainActivity represents the main container of the app. We will insert every other child fragment we need into this parent activity.
 */
class MainActivity : FragmentActivity(), MainFeedView {

    private var mPresenter: MainFeedPresenterImpl = MainFeedPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.loadArticles()
        setupToolbar()
    }


    fun setupToolbar() {
        toolbar.favoriteIcon.setOnClickListener {
            showFavoriteArticles()
        }
    }

    // Show the list of articles to the user once they have been successfully parsed from the JSON file.
    override fun displayArticlesList(articleList: ArrayList<Article>) {
        // Creates a vertical Layout Manager
        articlesList.layoutManager = LinearLayoutManager(this)
        articlesList.adapter = FeedAdapter(
            articleList,
            this,
            FEEDTYPE.MAIN,
            object : FeedAdapter.OnArticleSelectedListener {

                override fun onArticleSelected(articleLink: String) {
                    displayArticleWebview(articleLink)
                }
            })
    }

    // Open up a webview and load the full page of the article for the user to view
    override fun displayArticleWebview(articleLink: String) {
        toolbar.toolbar_title.setText("Article Detail")
        val webviewFragment = ArticleWebViewFragment.newInstance(articleLink)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.main_content, webviewFragment, "article_webview_fragment")
            .addToBackStack("article_webview_fragment").commit()
    }

    // Did we run into an error? Let's update the UI to show the user that something went wrong
    override fun showErrorToUser(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showFavoriteArticles() {
        val favoritesFragment = FavoriteArticlesFragment.newInstance()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.main_content, favoritesFragment, "favorite_articles_fragment")
            .addToBackStack("favorite_articles_fragment").commit()

        toolbar.toolbar_title.setText("Favorites")
        toolbar.favoriteIcon.visibility = View.INVISIBLE

    }

    override fun onBackPressed() {
        super.onBackPressed()

        // If no other fragments are in the backstack, let's reset the toolbar to its default state.
        val fragmentManager = supportFragmentManager

        if (fragmentManager.fragments.size == 0) {
            toolbar.toolbar_title.setText("BetterNews")
            toolbar.favoriteIcon.visibility = View.VISIBLE

        } else if (fragmentManager.fragments.size > 0) {

            for (fragment in fragmentManager.fragments) {
                if (fragment.tag.equals("favorite_articles_fragment")) {
                    toolbar_title.setText("Favorites")
                    favoriteIcon.visibility = View.INVISIBLE
                } else if (fragment.tag.equals("article_webview_fragment")) {
                    toolbar_title.setText("Article Detail")
                    favoriteIcon.visibility = View.VISIBLE
                }
            }
        }
    }
}