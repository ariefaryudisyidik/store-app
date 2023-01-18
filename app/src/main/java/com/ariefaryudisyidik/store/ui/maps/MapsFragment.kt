package com.ariefaryudisyidik.store.ui.maps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentHomeBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class MapsFragment : Fragment(R.layout.fragment_maps), OnMapReadyCallback {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onMapReady(p0: GoogleMap) {

    }
}