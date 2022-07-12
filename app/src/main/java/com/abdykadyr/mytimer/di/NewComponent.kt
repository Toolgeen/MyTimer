package com.abdykadyr.mytimer.di

import dagger.Component

@Component(modules = [DomainModule::class])
interface NewComponent {

    fun inject()

}