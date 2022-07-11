package com.abdykadyr.mytimer.domain

import javax.inject.Inject

class DeleteTimerUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(myTimerId: Int) = repository.deleteTimerUseCase(myTimerId)
}