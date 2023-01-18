package com.ariefaryudisyidik.store.ui.storedetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentStoreDetailBinding

class StoreDetailFragment : Fragment(R.layout.fragment_store_detail) {

    private var _binding: FragmentStoreDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreDetailBinding.bind(view)

        navigateToResult()
    }

    private fun navigateToResult() {
        binding.btnVisit.setOnClickListener {
            findNavController().navigate(StoreDetailFragmentDirections.toResultFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}