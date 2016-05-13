/*
* Copyright (C) 2016 Pedro Paulo de Amorim
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.amazingmvpkotlin.ui.adapter.viewPager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.amazingmvpkotlin.ui.fragment.GenreFragment
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.domain.util.Tags

class GenreAdapter(fragmentManager: FragmentManager, val genres: List<Genre>):
        FragmentPagerAdapter(fragmentManager) {

  override fun getCount(): Int = genres.count()
  override fun getPageTitle(position: Int) = genres[position].title

  override fun getItem(position: Int): Fragment? {
    val genreFragment = GenreFragment()
    val bundle = Bundle()
    bundle.putParcelableArray(Tags.SUBGENRES.value, genres[position].subGenres.toTypedArray())
    genreFragment.arguments = bundle
    return genreFragment
  }

}