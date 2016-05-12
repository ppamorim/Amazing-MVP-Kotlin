package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle

interface InstanceState {
  fun saveInstanceState(bundle : Bundle?) : Bundle?
  fun restoreInstanceState(bundle : Bundle?)
}