package com.example.postapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.data.model.Comment
import kotlinx.android.synthetic.main.list_comment.view.*

class CommentAdapter :
    ListAdapter<Comment, CommentAdapter.CommentVh>(CommentDiff()) {
    class CommentVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Comment?) {
            with(itemView) {
                item_1.text = item?.name
                item_2.text = item?.email
                item_3.text = item?.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentVh {
        return CommentVh(
            LayoutInflater.from(parent.context).inflate(R.layout.list_comment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentVh, position: Int) {
        holder.bind(getItem(position))
    }
}

internal class CommentDiff : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }
}