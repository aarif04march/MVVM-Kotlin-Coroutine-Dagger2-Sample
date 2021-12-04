package com.aarif.mvvmcoroutines.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject

abstract class BaseFragment<V: ViewModel> : DaggerDialogFragment() {

    private lateinit var  viewModel: V
    abstract fun getViewModel() : V

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.viewModel=getViewModel()
    }
}