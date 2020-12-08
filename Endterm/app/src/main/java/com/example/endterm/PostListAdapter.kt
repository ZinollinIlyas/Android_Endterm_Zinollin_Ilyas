package com.example.endterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class PostListAdapter( val context: Context): RecyclerView.Adapter<PostListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_content, parent, false)
        instance = this
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return MainActivity.post.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = MainActivity.post.get(position)
        holder.title.text = post.title


        holder.itemView.setOnClickListener{
            val bundle = bundleOf("postId" to post.id, "userId" to post.userId)
            it.findNavController().navigate(R.id.action_fragmentPostList_to_fragmentDetailPage,bundle)
        }


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title: TextView = view.findViewById(R.id.title)


    }

    companion object{
        lateinit var instance: PostListAdapter
    }




}
