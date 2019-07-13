package pe.demo.minitumblr.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pe.demo.minitumblr.R
import pe.demo.minitumblr.ui.posts.MTPostsActivity
import pe.demo.minitumblr.util.MTConstants.ARG_BLOG_NAME
import pe.demo.minitumblr.util.MTConstants.ARG_POST_TYPE

class MTMainActivity : AppCompatActivity(), View.OnClickListener {

    private var mPostType: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etPostType.setOnClickListener(this)
        btnContinue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnContinue.id -> goToPostsActivity()
            etPostType.id -> showPostTypeDialog()
        }
    }

    private fun goToPostsActivity() {
        val intent = Intent(this, MTPostsActivity::class.java)
        intent.putExtra(ARG_BLOG_NAME, etBlogName.text.toString().trim())
        intent.putExtra(ARG_POST_TYPE, mPostType)
        startActivity(intent)
    }

    fun showPostTypeDialog() {
        lateinit var dialog: AlertDialog
        val postTypes = arrayOf("Texto", "Foto")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Tipo de posts")
        builder.setSingleChoiceItems(postTypes, -1, { _, which ->
            etPostType.setText(postTypes[which]);
            mPostType = which
            dialog.dismiss()
        })

        dialog = builder.create()
        dialog.show()
    }

}

