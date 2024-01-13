package com.example.tvmazeinterview.presentation

import android.app.Application

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TVMazeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}