package com.abdykadyr.mytimer.di

import com.abdykadyr.mytimer.data.RepositoryImpl
import com.abdykadyr.mytimer.domain.Repository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideRepository(impl: RepositoryImpl) : Repository {
        return impl
    }

}