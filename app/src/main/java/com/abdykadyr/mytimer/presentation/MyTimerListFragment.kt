package com.abdykadyr.mytimer.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abdykadyr.mytimer.databinding.FragmentMyTimerListBinding

class MyTimerListFragment : Fragment(), AddTimerDialogFragment.NoticeDialogListener {

    private var _binding: FragmentMyTimerListBinding? = null
    private val binding: FragmentMyTimerListBinding
        get() = _binding ?: throw RuntimeException("FragmentMyTimerListBinding is null")

    private val viewModel by lazy {
        ViewModelProvider(this)[TimerListViewModel::class.java]
    }

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

        val timerListAdapter = TimerListAdapter()
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
        Log.d("ADD_TIMER_FRAGMENT", "hours $hours, minutes $minutes")
        viewModel.addTimer(hours, minutes)
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dismiss()
    }

}