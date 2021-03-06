package com.abdykadyr.mytimer.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abdykadyr.mytimer.TimerApplication
import com.abdykadyr.mytimer.databinding.FragmentMyTimerListBinding
import com.abdykadyr.mytimer.domain.MyTimer
import javax.inject.Inject

class MyTimerListFragment : Fragment(), AddTimerDialogFragment.NoticeDialogListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TimerListViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as TimerApplication).component
    }

    private var _binding: FragmentMyTimerListBinding? = null
    private val binding: FragmentMyTimerListBinding
        get() = _binding ?: throw RuntimeException("FragmentMyTimerListBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyTimerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)
        val timerListAdapter = TimerListAdapter()
        timerListAdapter.onStartTimerClick = {
            if (isTimerStarted(viewModel.getTimer(it))) {
                Log.d("BUTTON_START_TIMER", "PAUSED #$it")
                viewModel.pauseTimer(it)
            } else {
                Log.d("BUTTON_START_TIMER", "STARTED #$it")
                viewModel.startTimer(it)
            }
        }
        binding.rvMyTimerList.adapter = timerListAdapter
        viewModel.timerList.observe(viewLifecycleOwner) {
            timerListAdapter.submitList(it)
        }


        binding.bAddTimer.setOnClickListener {
            AddTimerDialogFragment().show(childFragmentManager, AddTimerDialogFragment.TAG)
        }

    }

    companion object {
        fun getInstance() = MyTimerListFragment()
    }

    override fun onDialogPositiveClick(hours: Int, minutes: Int) {
        viewModel.addTimer(hours, minutes)
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dismiss()
    }

    private fun isTimerStarted(myTimer: MyTimer): Boolean {
        return myTimer.whenStartedTime != 0
    }
}