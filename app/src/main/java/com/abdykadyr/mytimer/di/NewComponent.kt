package com.abdykadyr.mytimer.di

import android.content.Context
import com.abdykadyr.mytimer.presentation.MyTimerListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])

interface NewComponent {

    fun inject(fragment: MyTimerListFragment)

    @Component.Builder
    interface ApplicationComponentBuilder {

        @BindsInstance
        fun context(context: Context) : ApplicationComponentBuilder

        fun build() : NewComponent

    }

}