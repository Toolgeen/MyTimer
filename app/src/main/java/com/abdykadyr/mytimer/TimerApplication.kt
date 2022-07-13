package com.abdykadyr.mytimer

import android.app.Application
import com.abdykadyr.mytimer.di.DaggerNewComponent

class TimerApplication : Application() {

    val component by lazy {
        DaggerNewComponent.builder()
            .context(this)
            .build()
    }

}