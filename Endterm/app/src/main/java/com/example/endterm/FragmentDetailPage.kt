package com.example.endterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.detail_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentDetailPage: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_page, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        return_to_postlist.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentDetailPage_to_fragmentPostList)
        }

        val postId = arguments?.getInt("postId")!!
        val userId = arguments?.getInt("userId")!!

        MainActivity.apiService.getTodoById(postId).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                val todo = response.body()!!
                detail_title.text = todo.title
                detail_body.text = todo.body

            }

        })

        see_comments.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentDetailPage_to_fragmentCommentList)
        }


    }
}