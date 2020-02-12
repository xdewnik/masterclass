package com.coolya.masterclass.ui.fragment.tour

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.coolya.masterclass.R
import com.coolya.masterclass.data.Tour
import com.coolya.masterclass.ui.fragment.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_tour.*

class TourFragment: BaseFragment() {
    override fun layout(): Int = R.layout.fragment_tour
    override fun title(): String = "hui"

    private lateinit var inputAdapter: TourAdapter

    private val tourList: MutableList<Tour> = ArrayList<Tour>().apply {
        add(Tour("hui"))
        add(Tour("hui1"))
        add(Tour("hui2"))
        add(Tour("hui3"))
        add(Tour("hui4"))
        add(Tour("hui5"))
        add(Tour("hui6"))
        add(Tour("hui7"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(tour_recyler){
            if(adapter == null){
                inputAdapter = TourAdapter()
                inputAdapter.listener = object: TourClick {
                    override fun onClick(tour: Tour) {
                        Toast.makeText(requireContext(), tour.name, Toast.LENGTH_SHORT).show()
                    }

                }
                inputAdapter.submitList(tourList)
                adapter = inputAdapter
            }
        }
    }
}