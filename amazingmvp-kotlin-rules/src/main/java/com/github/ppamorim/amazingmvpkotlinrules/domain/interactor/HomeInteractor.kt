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
package com.github.ppamorim.amazingmvpkotlinrules.domain.interactor

import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre

/**
 * This interface represents the connection between
 * the presenter and Interactor {@link HomeInteractorImpl}.
 * The callback will return the result of this
 * interactor for the presenter.
 */
interface HomeInteractor {
    fun execute(callback: Callback?)
    interface Callback {
        fun onGenresLoaded(subGenres: List<Genre>)
        fun onGenresEmpty()
        fun onErrorLoad()
        fun onNoConnection(reason: Int)
    }
}