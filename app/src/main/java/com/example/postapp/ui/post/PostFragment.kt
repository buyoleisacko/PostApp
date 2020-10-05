package com.example.postapp.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : BaseFragment<PostViewModel>() {
    private lateinit var _adapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.loadPosts()
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            if (it.isSuccess) {
                it.onSuccess { posts ->
                    _adapter.submitList(posts)
                    recycler_view.adapter = _adapter
                }
            } else {
                it.onFailure { exception: Throwable ->
                    Toast.makeText(context, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            progressStatus(progressBar, it)
        })
    }

    private fun initRecyclerView() {
        _adapter = PostAdapter()
        recycler_view.apply {
            hasFixedSize()
            adapter = _adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun getViewModel(): Class<PostViewModel> = PostViewModel::class.java

}