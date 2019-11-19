package co.betterup.betterfeed.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import co.betterup.betterfeed.R
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.fragment_article_webview.*
import kotlinx.android.synthetic.main.fragment_article_webview.view.*

class ArticleWebViewFragment : Fragment(), ArticleWebView {

    private var mUrl: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mUrl = arguments?.getString(KEY_URL)
        return LayoutInflater.from(activity).inflate(R.layout.fragment_article_webview, container, false)

    }


    companion object {
        val KEY_URL = "key:url"
        fun newInstance(url: String): ArticleWebViewFragment {
            val fragment = ArticleWebViewFragment()
            val args = Bundle()
            args.putString(KEY_URL, url)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settings = view.webview.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        view.webview.webViewClient = DefaultWebViewClient()
        showArticleInBrowser(mUrl)

    }

    open class DefaultWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }


    override fun showArticleInBrowser(url: String?) {
        view?.webview?.loadUrl(mUrl)
        Log.d("ArticleWebViewFragment", "Loading URL " + url)
    }
}