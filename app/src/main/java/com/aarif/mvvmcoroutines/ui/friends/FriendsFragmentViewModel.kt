package com.aarif.mvvmcoroutines.ui.friends


import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FriendsFragmentViewModel @Inject constructor(val repository: FriendsRepository) : ViewModel(){
    val friends by lazy {
        repository.observeFriends()
    }
}