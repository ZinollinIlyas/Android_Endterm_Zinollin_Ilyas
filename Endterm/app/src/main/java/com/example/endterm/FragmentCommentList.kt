package com.example.endterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.comments_list.*
import kotlinx.android.synthetic.main.list_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentCommentList: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.comments_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        comment_recyclerview.adapter = CommentAdapter(view.context)
        comment_recyclerview.layoutManager = LinearLayoutManager(view.context)


        MainActivity.apiService.getAllComments().enqueue(object: Callback<MutableList<Comment>> {
            override fun onFailure(call: Call<MutableList<Comment>>, t: Throwable) {

            }

            override fun onResponse(
                    call: Call<MutableList<Comment>>,
                    response: Response<MutableList<Comment>>
            ) {
                MainActivity.comment = response.body()!!
                (comment_recyclerview.adapter as PostListAdapter).notifyDataSetChanged()
            }
        })

        back_to_postlist.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentCommentList_to_fragmentPostList)
        }

    }
}