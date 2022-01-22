package com.atif.revaliationnewspro.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.atif.revaliationnewspro.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CountryFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apply = view.findViewById<Button>(R.id.ls_apply_btn)
        apply.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        apply.setOnClickListener {
            val action = CountryFragmentDirections.actionCountryFragmentToNewsListFragment()
            findNavController().navigate(action)
        }

    }
}