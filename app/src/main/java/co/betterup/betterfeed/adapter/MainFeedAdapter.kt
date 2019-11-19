package co.betterup.betterfeed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.betterup.betterfeed.R
import co.betterup.betterfeed.application.BetterNewsApplication
import co.betterup.betterfeed.model.Article
import kotlinx.android.synthetic.main.item_feed_article.view.*

class MainFeedAdapter(val articles: ArrayList<Article>, val context: Context, val listener: OnArticleSelectedListener) : RecyclerView.Adapter<MainFeedAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed_article, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article = articles.get(position)
        holder?.title?.text = article.title
        holder?.description.text = article.description
        holder?.favoriteIcon.setOnClickListener {



            if(BetterNewsApplication.isArticleAFavorite(article)){
                holder?.favoriteIcon.setBackgroundResource(R.drawable.ic_favorite_border_24px)
                BetterNewsApplication.removeArticleFromFavorites(article)
            }

            else {
                holder?.favoriteIcon.setBackgroundResource(R.drawable.ic_favorite_black_24px)
                BetterNewsApplication.addArticleToFavorites(article)
            }


        }

        holder?.itemParent.setOnClickListener{
            listener.onArticleSelected(article.link.toString())
        }


    }

    interface OnArticleSelectedListener {

        fun onArticleSelected(articleLink: String)
    }


    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title = view.articleTitle
        val description = view.articleDescription
        val favoriteIcon = view.favoriteIcon
        val itemParent = view
    }
}