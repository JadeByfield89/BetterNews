package co.betterup.betterfeed.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import co.betterup.betterfeed.R
import kotlinx.android.synthetic.main.fragment_article_webview.*

class ArticleWebViewFragment : Fragment(), ArticleWebView {

    private var mUrl: String? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_article_webview, container, false)
        val settings = web_view.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        web_view.webViewClient = DefaultWebViewClient()
        showArticleInBrowser(mUrl)

        return view
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

    }

    open class DefaultWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }


    override fun showArticleInBrowser(url: String?) {
        web_view.loadUrl(mUrl)
    }
}