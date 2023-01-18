package com.ariefaryudisyidik.store.ui.storelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentStoreListBinding

class StoreListFragment : Fragment(R.layout.fragment_store_list) {

    private var _binding: FragmentStoreListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreListBinding.bind(view)

        navigateToStoreDetailFragment()
    }

    private fun navigateToStoreDetailFragment() {
        binding.tvVisit.setOnClickListener {
            findNavController().navigate(StoreListFragmentDirections.toStoreDetailFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}