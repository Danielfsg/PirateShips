package com.danielfsg.pirateships.presentation.shipdetail

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.danielfsg.pirateships.databinding.FragmentPirateShipDetailsBinding
import com.danielfsg.pirateships.domain.model.PirateShip
import com.danielfsg.pirateships.presentation.extention.loadUrlImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PirateShipDetailFragment : Fragment() {

    private var _binding: FragmentPirateShipDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PirateShipDetailViewModel by viewModels()
    private val args: PirateShipDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        viewModel.loadPirateShipDetails(args.pirateShip)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPirateShipDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pirateShipLiveData.observe(viewLifecycleOwner, this::handlePirateShip)
    }

    private fun handlePirateShip(pirateShip: PirateShip) {
        binding.title.text = pirateShip.title
        binding.description.text = pirateShip.description
        binding.price.text = pirateShip.price
        binding.greeting.setOnClickListener { showGreeting(pirateShip.greetingType) }
        binding.image.transitionName = pirateShip.id.toString()

        binding.image.loadUrlImage(requireContext(), pirateShip.image)
    }

    private fun showGreeting(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}