package com.example.test_m2u.recycler


import com.example.test_m2u.custom.ItemViewBuilder
import com.example.test_m2u.custom.setImageFromURL
import com.example.test_m2u.databinding.ItemSimilarBinding
import com.example.test_m2u.model.genreresponse.Genre
import com.example.test_m2u.model.similarmovieresponse.Movie
import com.example.test_m2u.repository.RepositoryMovies
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemViewMovie : ItemViewBuilder<Movie, ItemSimilarBinding>() {

    override val binding by lazy { bind(ItemSimilarBinding::class) }

    override fun ItemSimilarBinding.onBind(position: Int) {


        (collection as Set<Movie>).elementAt(position).run {
            itemImage.setImageFromURL("https://image.tmdb.org/t/p/original$backdropPath")
            itemName.text = title
            itemYear.text = releaseDate
            var genre = ""
            genreIds.forEach {
                when {
                    it.equals(28) -> {
                        genre += "Action "
                    }
                    it.equals(12) -> {
                        genre += "Adventure "
                    }
                    it.equals(16) -> {
                        genre += "Animation "
                    }
                    it.equals(35) -> {
                    genre += "Comedy "
                    }
                    it.equals(80) -> {
                    genre += "Crime "
                    }
                    it.equals(99) -> {
                    genre += "Documentary "
                    }
                    it.equals(18) -> {
                        genre += "Drama "
                    }
                    it.equals(10751) -> {
                        genre += "Family "
                    }
                    it.equals(14) -> {
                        genre += "Fantasy "
                    }
                    it.equals(36) -> {
                        genre += "History "
                    }
                    it.equals(27) -> {
                    genre += "Horror "
                    }
                    it.equals(10402) -> {
                        genre += "Music "
                    }
                    it.equals(9648) -> {
                        genre += "Romance "
                    }
                    it.equals(878) -> {
                        genre += "Science Fiction "
                    }
                    it.equals(10770) -> {
                        genre += "TV Movie "
                    }
                    it.equals(53) -> {
                        genre += "Thriller "
                    }
                    it.equals(10752) -> {
                        genre += "War "
                    }
                    it.equals(37) -> {
                        genre += "Western "
                    }
                }
            }
            itemType.text = genre
        }
    }

}
