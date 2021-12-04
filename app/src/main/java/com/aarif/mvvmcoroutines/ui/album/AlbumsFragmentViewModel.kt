package com.aarif.mvvmcoroutines.ui.album


import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AlbumsFragmentViewModel @Inject constructor(val repository: AlbumsRepository) : ViewModel(){
    val albums by lazy {
        repository.observeAlbums()
    }
}