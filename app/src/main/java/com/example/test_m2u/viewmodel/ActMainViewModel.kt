package com.example.test_m2u.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.test_m2u.model.moviedetailresponse.MovieDetailResponse
import com.example.test_m2u.model.similarmovieresponse.Movie
import com.example.test_m2u.repository.RepositoryMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActMainViewModel(application: Application) : AndroidViewModel(application) {

    val dataSet = MutableLiveData<List<Movie>>()
    val movie = MutableLiveData<MovieDetailResponse>()
    val pageTotal = MutableLiveData<Int>()
    private val context = getApplication<Application>().applicationContext

    //private var repository = RepositoryDatabase(context)
    private var repositoryTMDB = RepositoryMovies()


    fun getMovie() = CoroutineScope(Dispatchers.IO).launch {
        movie.postValue(repositoryTMDB.getMovieDetail())
    }

    fun getSimilarMovies(movieID: String,page: Int = 1) = CoroutineScope(Dispatchers.IO).launch{
        val response = repositoryTMDB.getSimilarMovies(movieID,page)
        dataSet.postValue(response.movies)
        pageTotal.postValue(response.totalPages)

    }

}