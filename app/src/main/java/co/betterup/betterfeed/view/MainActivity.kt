package co.betterup.betterfeed.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.betterup.betterfeed.R
import co.betterup.betterfeed.adapter.MainFeedAdapter
import co.betterup.betterfeed.presenter.MainFeedPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*


/**
 * This is just provided as a starting point and this and any other part of this project can
 * be changed in any way you see fit.
 */
class MainActivity : AppCompatActivity(), MainFeedView {

    private var mPresenter : MainFeedPresenterImpl = MainFeedPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayArticlesList()
    }

    override fun displayArticlesList() {
        // Creates a vertical Layout Manager
        articlesList.layoutManager = LinearLayoutManager(this)
        articlesList.adapter = MainFeedAdapter(mPresenter.loadArticles(), this, object : MainFeedAdapter.OnArticleSelectedListener {

            override fun onArticleSelected(articleLink: String) {
                displayArticleWebview(articleLink)
                Log.d("MainActivity", "Article " + articleLink + " selected")
            }
        })
    }

    override fun displayArticleWebview(articleLink: String) {
        val webviewFragment = ArticleWebViewFragment.newInstance(articleLink)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.main_content, webviewFragment).addToBackStack("article_webview_fragment").commit()
    }

    override fun showErrorToUser(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFavoriteArticles() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}