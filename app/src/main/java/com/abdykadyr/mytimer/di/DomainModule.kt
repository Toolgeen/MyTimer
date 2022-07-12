package com.abdykadyr.mytimer.di

import com.abdykadyr.mytimer.data.RepositoryImpl
import com.abdykadyr.mytimer.domain.Repository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun provideRepository(impl: RepositoryImpl) : Repository
}