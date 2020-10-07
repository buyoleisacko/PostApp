package com.example.postapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_comment

class BaseFragment {

}


class CommentFragment : BaseFragment<CommentViewModel>() {

    private lateinit var _adapter: CommentAdapter

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false)
    }

    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

private fun Any.onViewCreated(view: View, savedInstanceState: Bundle?) {


}

class CommentViewModel {

}
