package com.example.postapp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_todo.*


class TodoFragment : BaseFragment<TodoViewModel>() {

    private lateinit var _adapter: TodoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.loadTodos()
        viewModel.todos.observe(viewLifecycleOwner, Observer {
            if (it.isSuccess) {
                it.onSuccess { todos ->
                    _adapter.submitList(todos)
                    recycler_view.adapter = _adapter
                }
            } else {
                it.onFailure { exception ->
                    Toast.makeText(context, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            progressStatus(progressBar, it)
        })
    }

    private fun initRecyclerView() {
        _adapter = TodoAdapter()
        recycler_view.apply {
            hasFixedSize()
            adapter = _adapter
            layoutManager = LinearLayoutManager(context)

        }
    }

    override fun getViewModel(): Class<TodoViewModel> = TodoViewModel::class.java

}