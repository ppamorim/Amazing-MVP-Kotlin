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
package com.amazingmvpkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.amazingmvpkotlin.R
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre

class SubGenreAdapter(subGenres: List<SubGenre>):
        RecyclerView.Adapter<SubGenreAdapter.SubGenreViewHolder>() {

    var subGenres: List<SubGenre>? = subGenres

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SubGenreViewHolder? {
        return SubGenreViewHolder(LayoutInflater.from(parent!!.getContext())
                .inflate(R.layout.adapter_genre, parent, false))
    }

    override fun onBindViewHolder(holder: SubGenreViewHolder?, position: Int) {
        holder!!.configView(getItemAtPosition(position))
    }

    override fun getItemCount(): Int {
        return subGenres!!.size()
    }

    fun getItemAtPosition(position: Int): SubGenre {
        return subGenres!!.get(position)
    }

    class SubGenreViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title by lazy { findViewById(R.id.genre_name) as TextView }

        fun configView(subGenre: SubGenre) {
            title.setText(subGenre.title)
        }

    }

}

