package com.example.postapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.data.model.Todo
import kotlinx.android.synthetic.main.list_todo.view.*

class TodoAdapter :
    ListAdapter<Todo, TodoAdapter.TodoVh>(TodoDiff()) {
    class TodoVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Todo?) {
            with(itemView) {
                item_1.text = item?.title
                cb_item.isChecked = item!!.completed
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoVh {
        return TodoVh(
            LayoutInflater.from(parent.context).inflate(R.layout.list_todo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoVh, position: Int) {
        holder.bind(getItem(position))
    }
}

internal class TodoDiff : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }
}