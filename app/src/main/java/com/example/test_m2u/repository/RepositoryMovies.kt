package com.example.test_m2u.repository

import com.example.test_m2u.model.MovieDetailResponse
import com.example.test_m2u.retrofit.RetroInit


class RepositoryMovies {
    private var url = "https://api.themoviedb.org/3/"
    private var service = ServiceMovies::class

    private val serviceMovies = RetroInit(url).create(service)

    suspend fun getMovieDetail():MovieDetailResponse {
        return serviceMovies.getMovieDetail(APP_ID)
    }

}