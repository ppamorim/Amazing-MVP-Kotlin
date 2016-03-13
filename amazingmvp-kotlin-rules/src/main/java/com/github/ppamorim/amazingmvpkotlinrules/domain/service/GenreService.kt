package com.github.ppamorim.amazingmvpkotlinrules.domain.service

import okhttp3.OkHttpClient

 class GenreService : BaseService() {

     fun requestGenres(callback: ServiceCallback) {
         get("https://gist.githubusercontent.com/ppamorim/e26c4b6f63245a674516/"
                + "raw/5927897b401ef43167bdfac2c19692808bb5ec4e/json.json", callback)
     }

}