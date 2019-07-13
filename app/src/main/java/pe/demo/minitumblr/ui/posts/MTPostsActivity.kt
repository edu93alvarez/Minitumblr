package pe.demo.minitumblr.ui.posts

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_posts.*
import org.koin.android.ext.android.inject
import pe.demo.minitumblr.R
import pe.demo.minitumblr.domain.model.MTPost
import pe.demo.minitumblr.presentation.post.MTPostContract
import pe.demo.minitumblr.util.MTConstants.ARG_BLOG_NAME
import pe.demo.minitumblr.util.MTConstants.ARG_POST_TYPE

class MTPostsActivity : AppCompatActivity(), MTPostContract.View {

    override val presenter by inject<MTPostContract.Presenter>()
    private var mPostList: List<MTPost>? = null
    private val mPostAdapter = MTPostAdapter()
    private var mPostType: Int = 0
    private var mBlogName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        getDataFromIntent()
        presenter.view = this
        presenter.getPosts(mBlogName + ".tumblr.com", mPostType)
    }

    private fun getDataFromIntent() {
        val bundle: Bundle? = intent.extras
        mPostType = bundle!!.getInt(ARG_POST_TYPE)
        mBlogName = bundle!!.getString(ARG_BLOG_NAME)
    }

    fun setupPostAdapter() {
        rvPosts.layoutManager = LinearLayoutManager(
            this
        )
        mPostAdapter?.setDataList(mPostList)
        rvPosts.adapter = mPostAdapter
    }

    override fun onSuccessGetPosts(posts: List<MTPost>) {
        mPostList = posts
        setupPostAdapter()
    }

    override fun onFailureGetPosts(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressLoading() {
        Toast.makeText(this, "Showing progress", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressLoading() {
        Toast.makeText(this, "Hiding progress", Toast.LENGTH_SHORT).show()
    }
}
