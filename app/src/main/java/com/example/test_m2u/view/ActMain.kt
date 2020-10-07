package com.example.test_m2u.view

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.test_m2u.base.ActBind
import com.example.test_m2u.custom.onClick
import com.example.test_m2u.custom.recyclerAdapter
import com.example.test_m2u.custom.setImageFromURL
import com.example.test_m2u.custom.viewBind
import com.example.test_m2u.databinding.ActMainBinding
import com.example.test_m2u.model.similarmovieresponse.Movie
import com.example.test_m2u.recycler.ItemViewMovie
import com.example.test_m2u.viewmodel.ActMainViewModel

class ActMain : ActBind<ActMainBinding>() {
    override val binding: ActMainBinding by viewBind()
    private val viewModel: ActMainViewModel by viewModels()
    private val similar = mutableSetOf<Movie>()
    private var movieID = ""
    private var pageTotal = 0
    private var page = 1

    @SuppressLint("SetTextI18n")
    override fun ActMainBinding.onBinding() {
        val adapter = recyclerAdapter<ItemViewMovie>(similar)
        recycler.adapter = adapter

        adapter.onTarget = {
            while (page < pageTotal) {
                page += 1
                viewModel.getSimilarMovies(movieID,page)
            }
        }
        viewModel.getMovie()
        viewModel.movie.observe(this@ActMain, Observer {
            imageView.setImageFromURL("https://image.tmdb.org/t/p/original" + it.backdropPath)
            movieTitle.setText(it.title)
            movieLikes.setText("""${it.voteCount} Likes.""")
            movieViews.setText("""${it.popularity} Views.""")
            movieID = it.id.toString()
            viewModel.getSimilarMovies(it.id.toString())
        })

        viewModel.dataSet.observe(this@ActMain, Observer {
            it.run {
                similar.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

        viewModel.pageTotal.observe(this@ActMain, Observer {
            it.run {
               pageTotal = it
            }
        })

        back.onClick { onBackPressed() }

    }

}