package com.danielfsg.pirateships.presentation.shiplist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.danielfsg.pirateships.databinding.FragmentPirateShipsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PirateShipsListFragment : Fragment() {

    private var _binding: FragmentPirateShipsListBinding? = null
    private val binding get() = _binding!!

    private val adapter: PirateShipsListAdapter by lazy {
        PirateShipsListAdapter()
    }

    private val viewModel: PirateShipsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadPirateShips()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPirateShipsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.adapter = adapter

        viewModel.pirateShipsLiveData.observe(viewLifecycleOwner, {
            binding.progressCircular.isVisible = false
            binding.list.isVisible = true
            adapter.submitList(it)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}