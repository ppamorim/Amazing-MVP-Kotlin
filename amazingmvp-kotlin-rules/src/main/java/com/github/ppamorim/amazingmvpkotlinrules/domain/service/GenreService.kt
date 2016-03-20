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
package com.github.ppamorim.amazingmvpkotlinrules.domain.service

import okhttp3.OkHttpClient

 class GenreService : BaseService() {

     fun requestGenres(callback: ServiceCallback) {
         get("https://gist.githubusercontent.com/ppamorim/e26c4b6f63245a674516/"
                + "raw/5927897b401ef43167bdfac2c19692808bb5ec4e/json.json", callback)
     }

}