package com.ariefaryudisyidik.store.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        navigateToStoreList()
        navigateToLogin()
    }

    private fun navigateToStoreList() {
        binding.layoutMenuHome.imgVisit.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.toStoreListFragment())
        }
    }

    private fun navigateToLogin() {
        binding.layoutMenuHome.imgLogout.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.toLoginFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}