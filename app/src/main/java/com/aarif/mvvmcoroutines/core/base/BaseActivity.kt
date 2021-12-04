package com.aarif.mvvmcoroutines.core.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModel
import com.aarif.mvvmcoroutines.utils.Utils
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity<V: ViewModel> : DaggerAppCompatActivity(){

    private lateinit var  viewModel: V
    public abstract fun getViewModel() : V

    @Inject lateinit var utils: Utils

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this.viewModel = if(viewModel == null) getViewModel() else viewModel
    }

}
