package com.danielfsg.pirateships.presentation.shiplist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danielfsg.pirateships.R
import com.danielfsg.pirateships.databinding.ItemListBinding
import com.danielfsg.pirateships.domain.model.PirateShip

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
            binding.price.text =
                String.format(itemView.context.getString(R.string.card_price), pirateShip.price)

            binding.root.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_pirateShipsListFragment_to_pirateShipDetailFragment,
                    bundleOf("pirateShip" to pirateShip)
                )
            }

            Glide.with(itemView.context)
                .load(pirateShip.image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_terrain_24)
                .error(R.drawable.ic_baseline_terrain_24)
                .fallback(R.drawable.ic_baseline_terrain_24)
                .into(binding.image)


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
