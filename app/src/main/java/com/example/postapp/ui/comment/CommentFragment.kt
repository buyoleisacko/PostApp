package com.example.postapp.ui.comment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_comment.*


class CommentFragment : BaseFragment<CommentViewModel>() {

    private lateinit var _adapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.loadComments()
        viewModel.comments.observe(viewLifecycleOwner, Observer {
            if (it.isSuccess) {
                it.onSuccess { comments ->
                    _adapter.submitList(comments)
                    recycler_view.adapter = _adapter
                }
            } else {
                it.onFailure { throwable ->
                    Toast.makeText(context, throwable.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            progressStatus(progressBar, it)
        })
    }

    private fun initRecyclerView() {
        _adapter = CommentAdapter()
        recycler_view.apply {
            hasFixedSize()
            adapter = _adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun getViewModel(): Class<CommentViewModel> = CommentViewModel::class.java

}