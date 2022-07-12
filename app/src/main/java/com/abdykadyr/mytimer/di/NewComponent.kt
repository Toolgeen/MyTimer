package com.abdykadyr.mytimer.di

import androidx.fragment.app.Fragment
import dagger.Component

@Component(modules = [DomainModule::class])
interface NewComponent {

    fun inject(fragment: Fragment)

}