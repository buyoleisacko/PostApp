package com.example.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.repository.PostsRepository
import com.example.postapp.viewmodel.PostsViewModel
import com.example.postapp.viewmodel.PostsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsViewModelFactory = com.example.postapp.viewmodel.PostsViewModelFactory()
        postsViewModel
            ViewModelProvider(this, postsViewModelFactory).get(PostsViewModel::class.java)
        postsViewModel.getPosts()
        postsViewModel.postsLiveData.observe(this, Observer { posts ->

            val recyclerPost = null
            recyclerPost.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                hasFixedSize()
                var adapter = PostsAdapter(posts)
            }

            Toast.makeText(baseContext, "${posts.size} posts fetched", Toast.LENGTH_LONG).show()
        })

        postsViewModel.postsFailedLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }

    private fun hasFixedSize() {
        TODO("Not yet implemented")
    }

    private fun ViewModelProvider(
        mainActivity: MainActivity,
        postsViewModelFactory: PostsViewModelFactory
    ): Any {
        TODO("Not yet implemented")
    }
}

private fun Any.get(java: Class<PostsViewModel>) {
    TODO("Not yet implemented")
}

class PostsViewModelFactory(postsRepository: PostsRepository) {

}
