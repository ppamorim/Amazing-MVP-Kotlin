package com.amazingmvpkotlin.ui.fragment

import android.support.v7.widget.RecyclerView
import com.amazingmvpkotlin.R
import com.amazingmvpkotlin.ui.adapter.SubGenreAdapter
import com.amazingmvpkotlin.ui.fragment.AbstractFragment
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre

class GenreFragment: AbstractFragment() {

    val recyclerView by lazy { findViewById(R.id.recycler_view) as RecyclerView }

    override fun getLayoutId(): Int {
        return R.layout.fragment_genre
    }

    fun setAdapter(subGenres: List<SubGenre>) {
        recyclerView.setAdapter(SubGenreAdapter(subGenres))
    }

}