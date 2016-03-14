package com.amazingmvpkotlin.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.amazingmvpkotlin.ui.fragment.GenreFragment
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre

class GenreAdapter(fragmentManager: FragmentManager, genres: MutableList<Genre>):
        FragmentPagerAdapter(fragmentManager) {

    var fragment: Array<Fragment?> = arrayOf(genres.size(), {i -> GenreFragment() })

    override fun getCount(): Int {
        return fragment!!.size()
    }

    override fun getItem(position: Int): Fragment? {
        return fragment!!.get(position)
    }

}