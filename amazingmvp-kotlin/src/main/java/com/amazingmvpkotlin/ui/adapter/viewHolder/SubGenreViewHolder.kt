package com.amazingmvpkotlin.ui.adapter.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.amazingmvpkotlin.R
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre

class SubGenreViewHolder(view: View): RecyclerView.ViewHolder(view) {

//  val title by lazy { findViewById(R.id.genre_name) as TextView }

  fun configView(subGenre: SubGenre?) {
    if (subGenre == null) return
//    title.text = subGenre.title
  }

}