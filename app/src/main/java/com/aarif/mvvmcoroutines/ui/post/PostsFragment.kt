package com.aarif.mvvmcoroutines.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aarif.mvvmcoroutines.R
import com.aarif.mvvmcoroutines.core.base.BaseFragment
import com.aarif.mvvmcoroutines.core.data.remote.APIResult
import com.aarif.mvvmcoroutines.databinding.FragmentPostsBinding
import com.aarif.mvvmcoroutines.utils.Utils
import com.aarif.mvvmcoroutines.utils.gone
import com.aarif.mvvmcoroutines.utils.visible
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


/**
 * @author AaR!F
 * @desc This fragment is responsible for getting weather information from the server and to present to the user
 */
open class PostsFragment : BaseFragment<PostsFragmentViewModel>() {

    lateinit var binding: FragmentPostsBinding

    @Inject
    lateinit var utils: Utils

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    internal lateinit var viewModel: PostsFragmentViewModel
    lateinit var adapter: PostsListAdapter

    override fun getViewModel(): PostsFragmentViewModel {
        viewModel = ViewModelProvider(viewModelStore, factory).get(PostsFragmentViewModel::class.java)
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PostsListAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posts, container, false)
        binding.viewModel=viewModel
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initView() {
        adapter = PostsListAdapter(context = requireContext())

        binding.recycler.layoutManager =
            LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL,
                false
            )


        binding.recycler.adapter = adapter
        initObservers()
    }

    private fun initObservers(){

        viewModel.posts.observe(viewLifecycleOwner) { result->
            when(result.status){
                APIResult.Status.LOADING->{
                    binding.progressbar.visible()
                }
                APIResult.Status.SUCCESS->{
                    if (result.data != null) {
                        adapter.refreshList(result.data)
                    }
                    binding.recycler.visible()
                    binding.progressbar.gone()
                }
                APIResult.Status.ERROR->{
                    result.message?.let {
                        Snackbar.make(
                            binding.recycler,
                            it,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    binding.recycler.visible()
                    binding.progressbar.gone()
                }
            }
        }
    }

}