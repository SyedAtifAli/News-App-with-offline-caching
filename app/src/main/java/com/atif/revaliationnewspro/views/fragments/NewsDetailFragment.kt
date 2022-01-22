package com.atif.revaliationnewspro.views.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.atif.revaliationnewspro.R
import com.atif.revaliationnewspro.databinding.FragmentNewsDetailBinding
import com.atif.revaliationnewspro.databinding.FragmentNewsListBinding
import com.bumptech.glide.Glide

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {
    private val args: NewsDetailFragmentArgs by navArgs()

    var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.heading = args.headline
        binding.source = args.source
        binding.date = args.source
        binding.desc = args.desc

        if(args.urltoimage == null){
            binding.detailimg.setImageResource(R.drawable.placeholder_news)
        }
        else  Glide.with(binding.detailimg).load(args.urltoimage).into(binding.detailimg)

        val i = Intent(Intent.ACTION_VIEW, Uri.parse(args.url))
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        binding.seemore.setOnClickListener {
            i.setPackage("com.android.chrome")
            try {
                startActivity(i)
            } catch (e: ActivityNotFoundException) {
                // Chrome is probably not installed
                // Try with the default browser
                i.setPackage(null)
                startActivity(i)
            }
        }


    }

}