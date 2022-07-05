package com.abdykadyr.mytimer.presentation

import androidx.recyclerview.widget.DiffUtil
import com.abdykadyr.mytimer.domain.MyTimer

class TimerDiffCallback: DiffUtil.ItemCallback<MyTimer>() {

    override fun areItemsTheSame(oldItem: MyTimer, newItem: MyTimer): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyTimer, newItem: MyTimer): Boolean {
        return oldItem == newItem
    }

}