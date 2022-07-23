package com.cxi.compose_study

import android.app.Application
import com.blankj.utilcode.util.Utils

class App : Application() {

    companion object{
        lateinit var app:Application
    }
    
    override fun onCreate() {
        super.onCreate()
        app = this
        Utils.init(this)
    }
    
}