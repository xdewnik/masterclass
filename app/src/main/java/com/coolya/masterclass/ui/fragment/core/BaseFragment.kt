package com.coolya.masterclass.ui.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment: Fragment() {
    abstract fun layout(): Int
    abstract fun title(): String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.let{
            it.title = title()
        }
        return inflater.inflate(layout(), container, false)
    }


    fun navigateTo(action: Int, args: Bundle? = null){
        findNavController().navigate(action, args)
    }



}