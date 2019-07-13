package pe.demo.minitumblr.ui.posts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post_image.*
import pe.demo.minitumblr.domain.model.MTPost


class MTPhotoPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun bind(itemPost: MTPost) {
        tvCaption.text = itemPost.postCaption ?: ""
        Glide.with(itemView.context).load(itemPost.postImageUrl)
            .apply(RequestOptions().fitCenter()).into(ivPost)
    }


}