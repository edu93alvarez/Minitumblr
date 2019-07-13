package pe.demo.minitumblr.ui.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.demo.minitumblr.R
import pe.demo.minitumblr.domain.model.MTPost
import pe.demo.minitumblr.ui.base.MTBaseLoadingViewHolder
import pe.demo.minitumblr.util.MTConstants

class MTPostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPostList: List<MTPost>? = null

    fun setDataList(postList: List<MTPost>?) {
        this.mPostList = postList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MTPhotoPostViewHolder) {
            val photoViewHolder: MTPhotoPostViewHolder = holder
            mPostList?.get(position)?.let { post -> photoViewHolder.bind(post) }
        } else if (holder is MTTextPostViewHolder) {
            val textViewHolder: MTTextPostViewHolder = holder
            mPostList?.get(position)?.let { post -> textViewHolder.bind(post) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            MTConstants.POST_PHOTO_TYPE ->
                return MTPhotoPostViewHolder(inflater.inflate(R.layout.item_post_image, parent, false))
            MTConstants.POST_TEXT_TYPE ->
                return MTTextPostViewHolder(inflater.inflate(R.layout.item_post_text, parent, false))
            else -> {
                return MTBaseLoadingViewHolder(inflater.inflate(R.layout.item_loading, parent, false))
            }
        }
    }

    override fun getItemCount(): Int {
        return mPostList?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        if (mPostList?.get(position)?.postType.equals(MTConstants.STR_PHOTO_TYPE)) {
            return MTConstants.POST_PHOTO_TYPE
        } else if (mPostList?.get(position)?.postType.equals(MTConstants.STR_TEXT_TYPE)) {
            return MTConstants.POST_TEXT_TYPE
        } else {
            return MTConstants.POST_LOADING
        }
    }
}