package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle

interface Presenter {
    fun saveInstance(instance: Bundle): Bundle
    fun restoreInstance(instance: Bundle)
}