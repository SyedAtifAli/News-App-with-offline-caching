package com.atif.revaliationnewspro.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.atif.revaliationnewspro.R
import com.atif.revaliationnewspro.databinding.ActivityMainBinding
import com.atif.revaliationnewspro.views.fragments.NewsListFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // NavController manages app navigation within a NavHost.
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHost =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHost.findNavController()
        // setting up toolbar and nav-controller
        setSupportActionBar(binding.toolbar.toolbar)
        setupActionBarWithNavController(navController)

        binding.toolbar.selectCountry.setOnClickListener {
            val action = NewsListFragmentDirections.actionNewsListFragmentToCountryFragment()
            navHost.findNavController().navigate(action)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        // return true based on the place we are in
        // if we are in home fragment super call will be executed
        // else navigateUp() will be executed
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}