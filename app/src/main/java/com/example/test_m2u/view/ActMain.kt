package com.example.test_m2u.view

import androidx.activity.viewModels
import com.example.test_m2u.base.ActBind
import com.example.test_m2u.custom.dp
import com.example.test_m2u.custom.viewBind
import com.example.test_m2u.databinding.ActMainBinding
import com.example.test_m2u.viewmodel.ActMainViewModel


class ActMain : ActBind<ActMainBinding>() {
    override val binding: ActMainBinding by viewBind()
    private val viewModel: ActMainViewModel by viewModels()
    //private val cards = mutableSetOf<CardItem>()

    override fun ActMainBinding.onBinding() {
        val adapter = recyclerAdapter<ItemViewCard>(cards)
        recycler.adapter = adapter

//        adapter.onTarget = {
//            while (pagina < totalPaginas) {
//                pagina += 1
//                viewModel.getCharacters(pagina)
//            }
//        }

        viewModel.dataSet.observe(this@ActMain, Observer {
            it.run {
                cards.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })






    }

}