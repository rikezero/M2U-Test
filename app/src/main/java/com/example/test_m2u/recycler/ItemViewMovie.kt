package com.example.test_m2u.recycler



import com.example.test_m2u.custom.ItemViewBuilder
import com.example.test_m2u.custom.setImageFromURL
import com.example.test_m2u.databinding.ItemSimilarBinding
import com.example.test_m2u.model.similarmovieresponse.Movie
import com.squareup.picasso.Picasso


class ItemViewMovie : ItemViewBuilder<Movie, ItemSimilarBinding>() {

    override val binding by lazy { bind(ItemSimilarBinding::class) }

    override fun ItemSimilarBinding.onBind(position: Int) {

        (collection as Set<Movie>).elementAt(position).run {
            itemImage.setImageFromURL("https://image.tmdb.org/t/p/original$backdropPath")
            itemName.text = title
            itemYear.text = releaseDate
            //itemType.text
        }
    }

}
