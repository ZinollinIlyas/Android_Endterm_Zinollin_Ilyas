package com.example.endterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.endterm.MainActivity.Companion.comment

class CommentAdapter(val context: Context): RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comment_list_content, parent, false)
        instance = this
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return MainActivity.comment.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val comment = MainActivity.comment.get(position)
        holder.name.text = comment.name
        holder.body.text = comment.body



    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var name: TextView = view.findViewById(R.id.comment_name)
        var body: TextView = view.findViewById(R.id.comment_body)


    }

    companion object{
        lateinit var instance: CommentAdapter
    }




}