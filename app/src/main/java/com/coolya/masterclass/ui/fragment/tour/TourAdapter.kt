package com.coolya.masterclass.ui.fragment.tour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coolya.masterclass.R
import com.coolya.masterclass.data.Tour
import kotlinx.android.synthetic.main.item_tour.view.*

class TourAdapter : ListAdapter<Tour, TourViewHolder>(async) {

    var listener: TourClick = TourClick.empty

    companion object async : DiffUtil.ItemCallback<Tour>() {
        override fun areItemsTheSame(oldItem: Tour, newItem: Tour): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Tour, newItem: Tour): Boolean =
            oldItem.name == newItem.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.item_tour, parent, false)
            .run { TourViewHolder(this) }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { listener.onClick(getItem(position)) }
    }
}

interface TourClick{
    companion object empty: TourClick{
        override fun onClick(tour: Tour) {

        }

    }

    fun onClick(tour:Tour)

}

class TourViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(tour: Tour) {
        view.tour_name.text = tour.name

    }

}