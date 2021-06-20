package com.danielfsg.pirateships.presentation.shiplist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danielfsg.pirateships.databinding.ItemListBinding
import com.danielfsg.pirateships.domain.model.PirateShip
import com.danielfsg.pirateships.presentation.extention.loadUrlImage

class PirateShipsListAdapter :
    ListAdapter<PirateShip, RecyclerView.ViewHolder>(PirateShipsListAdapterCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PirateShipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PirateShipViewHolder).bind(getItem(position))
    }

    inner class PirateShipViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pirateShip: PirateShip) {
            binding.title.text = pirateShip.title
            binding.price.text = pirateShip.price
            binding.image.transitionName = pirateShip.id.toString()
            binding.image.loadUrlImage(itemView.context, pirateShip.image)

            val action = PirateShipsListFragmentDirections.actionOpenDetail(pirateShip)
            val extras = FragmentNavigatorExtras(binding.image to binding.image.transitionName)
            binding.root.setOnClickListener { it.findNavController().navigate(action, extras) }

        }
    }

}

private class PirateShipsListAdapterCallBack : DiffUtil.ItemCallback<PirateShip>() {
    override fun areItemsTheSame(oldItem: PirateShip, newItem: PirateShip): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PirateShip, newItem: PirateShip): Boolean {
        return oldItem == newItem
    }
}
