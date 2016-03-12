package com.amazingmvpkotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

abstract class AbstractActivity : AppCompatActivity() {

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(getLayoutId())
        ButterKnife.bind(this)
    }

    abstract fun getLayoutId(): Int

}