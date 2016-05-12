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
package com.github.ppamorim.amazingmvpkotlinrules.domain.model

import android.os.Parcel
import android.os.Parcelable

data class SubGenre(var id: Long,
               var title: String,
               var image: String,
               var details: String) : Parcelable {

  companion object {
    @JvmField final val CREATOR: Parcelable.Creator<Genre> =
      object : Parcelable.Creator<Genre> {
        override fun createFromParcel(source: Parcel) = Genre(source)
        override fun newArray(size: Int): Array<Genre?> = arrayOfNulls(size)
      }
  }

  constructor(parcel : Parcel) : this(
    parcel.readLong(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString())

  override fun writeToParcel(parcel: Parcel, flag: Int) {
    parcel.writeLong(id)
    parcel.writeString(title)
    parcel.writeString(image)
    parcel.writeString(details)
  }

  override fun describeContents(): Int {
    return 0
  }

}