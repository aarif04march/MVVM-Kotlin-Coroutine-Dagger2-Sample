package com.aarif.mvvmcoroutines

import com.aarif.mvvmcoroutines.core.di.component.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MCSApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerMainComponent.builder().application(this).build()
}