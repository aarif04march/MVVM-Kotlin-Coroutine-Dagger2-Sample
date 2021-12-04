package com.aarif.mvvmcoroutines.ui.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.aarif.mvvmcoroutines.R
import com.aarif.mvvmcoroutines.core.base.BaseActivity
import com.aarif.mvvmcoroutines.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject


class MainActivity : BaseActivity<MainViewModel>() {

    private lateinit var binding: ActivityMainBinding
    @Inject internal lateinit var viewModel: MainViewModel

    override fun getViewModel(): MainViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initView()
    }

    private fun initView(){
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_nav)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_posts, R.id.navigation_albums, R.id.navigation_friends
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}