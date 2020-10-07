package com.example.test_m2u.repository

import com.example.test_m2u.model.moviedetailresponse.MovieDetailResponse
import com.example.test_m2u.model.similarmovieresponse.SimilarMovieResponse
import com.example.test_m2u.retrofit.RetroInit


class RepositoryMovies {
    private var url = "https://api.themoviedb.org/3/"
    private var service = ServiceMovies::class

    private val serviceMovies = RetroInit(url).create(service)

    suspend fun getMovieDetail(): MovieDetailResponse {
        return serviceMovies.getMovieDetail(apikey = APP_ID)
    }

    suspend fun getSimilarMovies(movieID: String, page:Int): SimilarMovieResponse {
        return serviceMovies.getSimilarMovies(movieID, APP_ID, page)
    }

}