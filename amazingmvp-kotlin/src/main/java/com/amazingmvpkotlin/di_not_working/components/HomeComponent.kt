///*
//* Copyright (C) 2016 Pedro Paulo de Amorim
//*
//* Licensed under the Apache License, Version 2.0 (the "License");
//* you may not use this file except in compliance with the License.
//* You may obtain a copy of the License at
//*
//* http://www.apache.org/licenses/LICENSE-2.0
//*
//* Unless required by applicable law or agreed to in writing, software
//* distributed under the License is distributed on an "AS IS" BASIS,
//* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//* See the License for the specific language governing permissions and
//* limitations under the License.
//*/
//package com.amazingmvpkotlin.di_not_working.components
//
//import com.amazingmvpkotlin.di_not_working.HomeModule
//import com.amazingmvpkotlin.di_not_working.scopes.ActivityScope
//import com.amazingmvpkotlin.ui.activity.HomeActivity
//import com.github.ppamorim.amazingmvpkotlinrules.presenter.HomePresenter
//import dagger.Component
//
//@ActivityScope
//@Component(dependencies = arrayOf(ApplicationComponent::class),
//    modules = arrayOf(HomeModule::class))
//interface HomeComponent {
//  fun inject(homeActivity: HomeActivity)
//  fun homePresenter(): HomePresenter
//}