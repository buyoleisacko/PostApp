package com.example.postapp.ui.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.data.model.Post
import kotlinx.android.synthetic.main.list_post.view.*

class PostAdapter :
    ListAdapter<Post, PostAdapter.PostVh>(PostDiff()) {
    class PostVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Post?) {
            with(itemView) {
                item_1.text = item?.title
                item_2.text = item?.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVh {
        return PostVh(
            LayoutInflater.from(parent.context).inflate(R.layout.list_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostVh, position: Int) {
        holder.bind(getItem(position))
    }
}

internal class PostDiff : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}