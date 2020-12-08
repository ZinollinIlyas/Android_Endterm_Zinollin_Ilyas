package com.example.endterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentPostList: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_item, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = PostListAdapter(view.context)
        recycler_view.layoutManager = LinearLayoutManager(view.context)

        MainActivity.apiService.getAllPosts().enqueue(object: Callback<MutableList<Post>> {
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {

            }

            override fun onResponse(
                    call: Call<MutableList<Post>>,
                    response: Response<MutableList<Post>>
            ) {
                MainActivity.post = response.body()!!
                (recycler_view.adapter as PostListAdapter).notifyDataSetChanged()
            }
        })
    }
}