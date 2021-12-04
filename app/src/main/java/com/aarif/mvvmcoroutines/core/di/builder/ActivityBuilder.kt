package com.aarif.mvvmcoroutines.core.di.builder

import com.aarif.mvvmcoroutines.ui.album.AlbumsFragment
import com.aarif.mvvmcoroutines.ui.album.AlbumsFragmentModule
import com.aarif.mvvmcoroutines.ui.friends.FriendsFragment
import com.aarif.mvvmcoroutines.ui.friends.FriendsFragmentModule
import com.aarif.mvvmcoroutines.ui.main.MainActivity
import com.aarif.mvvmcoroutines.ui.main.MainActivityModule
import com.aarif.mvvmcoroutines.ui.post.PostsFragment
import com.aarif.mvvmcoroutines.ui.post.PostsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [PostsFragmentModule::class])
    abstract fun contributePostsFragment(): PostsFragment

    @ContributesAndroidInjector(modules = [AlbumsFragmentModule::class])
    abstract fun contributeAlbumsFragment(): AlbumsFragment

    @ContributesAndroidInjector(modules = [FriendsFragmentModule::class])
    abstract fun contributeFriendsFragment(): FriendsFragment

}