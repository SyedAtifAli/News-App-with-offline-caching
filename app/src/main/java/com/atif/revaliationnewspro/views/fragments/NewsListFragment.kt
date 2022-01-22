package com.atif.revaliationnewspro.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.atif.revaliationnewspro.R
import com.atif.revaliationnewspro.databinding.FragmentNewsListBinding
import com.atif.revaliationnewspro.model.api.NewsApi
import com.atif.revaliationnewspro.model.api.Retrofithelper
import com.atif.revaliationnewspro.model.roomdb.NewsDatabase
import com.atif.revaliationnewspro.repo.NewsRepository
import com.atif.revaliationnewspro.view_models.NewsListViewModel
import com.atif.revaliationnewspro.view_models.ViewModelFactory
import com.atif.revaliationnewspro.views.adapters.Adapter

class NewsListFragment : Fragment(R.layout.fragment_news_list) {
    var _binding: FragmentNewsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val api = Retrofithelper.getInstance().create(NewsApi::class.java)
        val database = NewsDatabase.getDBInstance(requireContext().applicationContext)
        val repo = NewsRepository(api, database)
        val viewmodel =
            ViewModelProvider(this, ViewModelFactory(repo)).get(NewsListViewModel::class.java)


        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewmodel.news.observe(viewLifecycleOwner, Observer {
            val adapter = Adapter(it,findNavController())
            binding.recyclerView.adapter = adapter
            binding.progressBar.visibility = View.GONE
        })

        binding.filterFab.setOnClickListener {
            val action = NewsListFragmentDirections.actionNewsListFragmentToFilterFragment()
            findNavController().navigate(action)
        }

        val adapter = ArrayAdapter(
            view.context,
            android.R.layout.simple_spinner_item, resources.getStringArray(R.array.sortString)
        )
        binding.sortSpinner.adapter = adapter
    }

}