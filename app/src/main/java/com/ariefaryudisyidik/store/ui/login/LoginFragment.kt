package com.ariefaryudisyidik.store.ui.login

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ariefaryudisyidik.store.R
import com.ariefaryudisyidik.store.databinding.FragmentLoginBinding
import com.ariefaryudisyidik.store.utils.Resource
import com.ariefaryudisyidik.store.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        login()
    }

    private fun login() {
        binding.apply {
            btnLogin.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()

                viewModel.login(username, password).observe(viewLifecycleOwner) { result ->
                    when (result) {
                        is Resource.Loading -> {
                            showLoading(true)
                        }
                        is Resource.Success -> {
                            showLoading(false)
                            if (!result.data.isNullOrEmpty()) {
                                findNavController().navigate(LoginFragmentDirections.toHomeFragment())
                            } else {
                                requireContext().toast(getString(R.string.error_login))
                            }
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            requireContext().toast(result.message)
                        }
                    }
                }
            }
        }
    }

    private fun showLoading(isVisible: Boolean) {
        binding.progressBar.isVisible = isVisible
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}