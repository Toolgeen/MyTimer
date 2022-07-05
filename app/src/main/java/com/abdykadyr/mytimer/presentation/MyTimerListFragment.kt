package com.abdykadyr.mytimer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdykadyr.mytimer.R
import com.abdykadyr.mytimer.databinding.FragmentMyTimerListBinding
import java.lang.RuntimeException

class MyTimerListFragment : Fragment() {

    private var _binding: FragmentMyTimerListBinding? = null
    private val binding: FragmentMyTimerListBinding
    get() = _binding ?: throw RuntimeException("FragmentMyTimerListBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyTimerListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bAddTimer.setOnClickListener {
            AddTimerDialogFragment().show(parentFragmentManager, AddTimerDialogFragment.TAG)
        }

    }

    companion object {
        fun getInstance() = MyTimerListFragment()
    }

}