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

class Genre : Parcelable {

//    public val CREATOR: Parcelable.Creator<Genre> = object:Parcelable.Creator<Genre> {
//        override fun createFromParcel(parcelIn:Parcel): Genre {
//            return Genre(parcelIn)
//        }
//
//        override fun newArray(size: Int): Array<Genre> {
//            return Array<Genre>()
//        }
//    }

    var id : Long? = 0
    var title : String? = null
    var subGenres : MutableList<SubGenre>? = null

    constructor(parcel : Parcel) {
        this.id = parcel.readLong()
        this.title = parcel.readString()
//        parcel.readTypedList<SubGenre>(subGenres, SubGenre.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flag: Int) {
        parcel.writeLong(id as Long)
        parcel.writeString(title)
        parcel.writeTypedList<SubGenre>(subGenres)
    }

    override fun describeContents(): Int {
        return 0
    }

}