package com.atif.revaliationnewspro.views.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.atif.revaliationnewspro.R
import com.atif.revaliationnewspro.databinding.FragmentNewsListBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apply = view.findViewById<Button>(R.id.ls_apply)
        apply.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        apply.setOnClickListener {
            val action = FilterFragmentDirections.actionFilterFragmentToNewsListFragment()
            findNavController().navigate(action)
        }
    }
}