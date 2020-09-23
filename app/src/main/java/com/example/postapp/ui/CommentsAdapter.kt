package com.example.postapp.ui

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postsapp.R
import com.example.postsapp.models.Comment
import kotlinx.android.synthetic.main.item_post.view.*
import kotlinx.android.synthetic.main.row_item_comments.view.*

class CommentsAdapter(
    var comments: List<Comment>
) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>(), Parcelable {
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    constructor(parcel: Parcel) : this(TODO("comments")) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_comments, parent, false)

    )

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var comment = comments[position]
        holder.itemView.body.text = comment.body
        holder.itemView.email.text = comment.email
        holder.itemView.name.text = comment.name
        holder.itemView.Id.text = comment.id.toString()
        holder.itemView.postId.text = comment.postId.toString()


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CommentsAdapter> {
        override fun createFromParcel(parcel: Parcel): CommentsAdapter {
            return CommentsAdapter(parcel)
        }

        override fun newArray(size: Int): Array<CommentsAdapter?> {
            return arrayOfNulls(size)
        }
    }
}