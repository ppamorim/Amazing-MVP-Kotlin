package com.github.ppamorim.amazingmvpkotlinrules.domain.repository

/**
 * Request the first object of a determined class
 * that extends RealmObject and return the object.
 */
//fun <T> getFirst(clazz: Class<T>): T = realm.where(clazz).findFirst()

/**
 * Request all objects of a determined class that
 * extends RealmObject and return a list of these
 * objects.
 */
fun <T> getAll(clazz: Class<T>): List<T> = emptyList()

///**
// * Query a determined item on table, based on the
// * field of a determined model and filter.
// */
//fun <T> find(clazz: Class<T>, fieldName: String, filter: String):
//    List<T>? = realm.where(clazz).contains(fieldName, filter).findAll()