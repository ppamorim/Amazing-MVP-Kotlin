package com.github.ppamorim.amazingmvpkotlinrules.presenter

open class PresenterImpl<T, U> {
  var view : T? = null
  var interactor : U? = null
  constructor(interactor: U?) {
    this.interactor = interactor
  }
}