package com.abdykadyr.mytimer.di

import com.abdykadyr.mytimer.data.RepositoryImpl
import com.abdykadyr.mytimer.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DomainModule {

    @Binds
    abstract fun provideRepository(impl: RepositoryImpl) : Repository
}