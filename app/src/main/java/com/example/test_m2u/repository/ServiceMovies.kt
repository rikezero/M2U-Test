package com.example.test_m2u.repository


import com.example.test_m2u.model.moviedetailresponse.MovieDetailResponse
import com.example.test_m2u.model.similarmovieresponse.SimilarMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val MOVIE = "2164"
const val APP_ID = "5174b59215a99e76f7a16664e6d0bbe4"

interface ServiceMovies {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id")
        movie:String = MOVIE,
        @Query("api_key")
        apikey: String
    ): MovieDetailResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id")
        movie:String = MOVIE,
        @Query("api_key")
        apikey: String
    ): SimilarMovieResponse


}
