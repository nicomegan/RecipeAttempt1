package com.example.recipeattempt1

import android.content.Context
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var boxStore: BoxStore private set // no one can set or change value

    fun init(context: Context) { //DataStore with ObjectBox object
        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
    }
}