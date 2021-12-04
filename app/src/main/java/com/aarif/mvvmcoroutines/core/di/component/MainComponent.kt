package com.aarif.mvvmcoroutines.core.di.component

import com.aarif.mvvmcoroutines.MCSApplication
import com.aarif.mvvmcoroutines.core.di.builder.ActivityBuilder
import com.aarif.mvvmcoroutines.core.di.module.AppModule
import com.aarif.mvvmcoroutines.core.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilder::class
    ]
)

interface MainComponent : AndroidInjector<MCSApplication>{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: MCSApplication): Builder
        fun build(): MainComponent
    }
}