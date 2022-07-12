package com.abdykadyr.mytimer.di

import androidx.lifecycle.ViewModel
import com.abdykadyr.mytimer.presentation.TimerListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    @IntoMap
    @StringKey("TimerListViewModel")
    @Binds
    fun bindTimerListViewModel(impl : TimerListViewModel) : ViewModel

}