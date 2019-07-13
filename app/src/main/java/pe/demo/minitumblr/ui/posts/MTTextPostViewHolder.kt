package pe.demo.minitumblr.ui.posts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post_text.*
import pe.demo.minitumblr.domain.model.MTPost


class MTTextPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun bind(itemPost: MTPost) {
        tvTextPost.text = itemPost.postBodyText ?: ""
    }

}