package com.ariefaryudisyidik.store.ui.storelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentStoreListBinding
import com.ariefaryudisyidik.store.ui.adapter.StoreListAdapter
import com.ariefaryudisyidik.store.utils.EventObserver
import com.ariefaryudisyidik.store.utils.Resource
import com.ariefaryudisyidik.store.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreListFragment : Fragment(R.layout.fragment_store_list) {

    private var _binding: FragmentStoreListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: StoreListViewModel by viewModels()
    private lateinit var storeListAdapter: StoreListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreListBinding.bind(view)

        setupRecyclerView()
        observeData()
        navigateToHome()
        navigateToStoreDetail()
    }

    private fun setupRecyclerView() {
        storeListAdapter = StoreListAdapter(viewModel::onStoresClicked)
        binding.rvStoreList.adapter = storeListAdapter
    }

    private fun observeData() {
        viewModel.getStoreList.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    storeListAdapter.submitList(result.data)
                }
                is Resource.Error -> {
                    requireContext().toast(result.message)
                }
            }
        }
    }

    private fun navigateToHome() {
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun navigateToStoreDetail() {
        viewModel.navigateToStoreDetail.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(StoreListFragmentDirections.toStoreDetailFragment(it))
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}