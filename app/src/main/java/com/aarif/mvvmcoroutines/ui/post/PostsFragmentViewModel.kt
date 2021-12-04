package com.aarif.mvvmcoroutines.ui.post


import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PostsFragmentViewModel @Inject constructor(val repository: PostsRepository) : ViewModel(){
    val posts by lazy {
        repository.observePosts()
    }
}