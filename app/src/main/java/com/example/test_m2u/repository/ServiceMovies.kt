package com.example.test_m2u.repository


import com.example.test_m2u.model.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

//const val APP_ID = "a902d179048ebd77b97fbd136899e443"
const val APP_ID = "5174b59215a99e76f7a16664e6d0bbe4"

interface ServiceMovies {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
            @Query("apikey")
            apikey: String
    ): MovieDetailResponse



}
