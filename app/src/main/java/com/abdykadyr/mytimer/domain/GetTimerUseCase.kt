package com.abdykadyr.mytimer.domain

import javax.inject.Inject

class GetTimerUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(myTimerId: Int) = repository.getTimerUseCase(myTimerId)
}