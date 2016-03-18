package com.amazingmvpkotlin.ui.fragment

import android.nfc.Tag
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amazingmvpkotlin.R
import com.amazingmvpkotlin.ui.adapter.SubGenreAdapter
import com.amazingmvpkotlin.ui.fragment.AbstractFragment
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre
import com.github.ppamorim.amazingmvpkotlinrules.domain.util.Tags
import com.github.ppamorim.amazingmvpkotlinrules.presenter.GenrePresenter
import javax.inject.Inject

class GenreFragment: AbstractFragment(), GenrePresenter.View {

    @Inject lateinit var genrePresenter: GenrePresenter

    val recyclerView by lazy { findViewById(R.id.recycler_view) as RecyclerView }

    override fun getLayoutId(): Int {
        return R.layout.fragment_genre
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AbstractFragment>.onCreate(savedInstanceState)
        genrePresenter.setGenreView(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super<AbstractFragment>.onViewCreated(view, savedInstanceState)
        genrePresenter.setGenreObject(getArguments().getParcelable(Tags.GENRE.name()))
        genrePresenter.restoreInstance(savedInstanceState)
    }

    override fun isReady(): Boolean {
        return isAdded()
    }

    override fun renderSubGenre(subGenres: List<SubGenre>) {
        recyclerView.setAdapter(SubGenreAdapter(subGenres))
        configRecyclerViewLayoutManger()
    }

    fun configRecyclerViewLayoutManger() {
        val resources = getContext().getResources()
        val  layoutManager = if (resources.getBoolean(R.bool.tablet))
         GridLayoutManager(getContext(), resources.getInteger(R.integer.recycler_view_column))
        else LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager)
    }

}