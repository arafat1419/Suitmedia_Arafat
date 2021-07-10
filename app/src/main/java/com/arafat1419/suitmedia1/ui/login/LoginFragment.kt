package com.arafat1419.suitmedia1.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.databinding.FragmentLoginBinding
import com.arafat1419.suitmedia1.ui.home.HomeFragment

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            btnNext.setOnClickListener {
                if (edtName.text?.length == 0) Toast.makeText(
                    context,
                    "Silahkan masukkan nama anda",
                    Toast.LENGTH_SHORT
                )
                    .show()
                else {
                    val bundle = bundleOf(HomeFragment.USERNAME_BUNDLE to edtName.text.toString())
                    it.findNavController()
                        .navigate(R.id.action_loginFragment_to_homeFragment, bundle)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}