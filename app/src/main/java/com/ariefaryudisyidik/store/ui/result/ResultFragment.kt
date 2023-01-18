package com.ariefaryudisyidik.store.ui.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultBinding.bind(view)

        navigateToHome()
    }

    private fun navigateToHome() {
        binding.btnFinished.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.toStoreListFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}