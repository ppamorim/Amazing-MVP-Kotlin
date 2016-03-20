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
package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle

class HomePresenterImpl : HomePresenter {

    var view : HomePresenter.View? = null

    override fun setViewInterface(view: HomePresenter.View) {
        this.view = view
    }

    override fun requestGenres(savedInstanceState: Bundle?) {
        throw UnsupportedOperationException()
    }

    override fun saveInstance(instance: Bundle?): Bundle? {
        return instance
    }

    override fun restoreInstance(instance: Bundle?) {
        throw UnsupportedOperationException()
    }

}