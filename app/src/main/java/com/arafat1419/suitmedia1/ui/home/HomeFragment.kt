package com.arafat1419.suitmedia1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private var username: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username = arguments?.getString(USERNAME_BUNDLE)

        val controller = findNavController().currentBackStackEntry?.savedStateHandle
        controller?.getLiveData<String>(EVENT_NAME_BUNDLE)?.observe(viewLifecycleOwner) {
            binding?.txtEvent?.text = it
        }
        controller?.getLiveData<Map<String, String>>(GUEST_BUNDLE)?.observe(viewLifecycleOwner) {
            binding?.txtGuest?.text = it[GUEST_NAME_BUNDLE]
            Toast.makeText(
                context,
                it[GUEST_DATE_BUNDLE]?.let { it1 -> dateCheck(it1.toInt()) }, Toast.LENGTH_SHORT
            ).show()
        }

        binding?.apply {
            btnEvent.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_eventFragment)
            }
            btnGuest.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_guestFragment)
            }
            txtName.text = username
        }
    }


    private fun dateCheck(date: Int): String {
        return if (date % 3 == 0 && date % 2 == 0) "IOS"
        else if (date % 3 == 0) "blackberry"
        else if (date % 2 == 0) "android"
        else "feature phone"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EVENT_NAME_BUNDLE = "event_name"
        const val GUEST_NAME_BUNDLE = "guest_name"
        const val GUEST_DATE_BUNDLE = "guest_date"
        const val GUEST_BUNDLE = "guest_bundle"
        const val USERNAME_BUNDLE = "username"
    }
}