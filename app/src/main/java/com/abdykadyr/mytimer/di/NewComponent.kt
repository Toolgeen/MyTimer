package com.abdykadyr.mytimer.di

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class])

interface NewComponent {

    fun inject(fragment: Fragment)

    interface ApplicationComponentBuilder {

        @BindsInstance
        fun context(context: Context) : ApplicationComponentBuilder

        fun build() : NewComponent

    }

}