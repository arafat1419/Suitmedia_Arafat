package com.arafat1419.suitmedia1.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.arafat1419.suitmedia1.databinding.FragmentGuestBinding

class GuestFragment : Fragment() {

    private var _binding: FragmentGuestBinding? = null
    private val binding get() = _binding

    private lateinit var guestAdapter: GuestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGuestBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[GuestViewModel::class.java]
            val guest = viewModel.getGuest()

            guestAdapter = GuestAdapter()
            guestAdapter.setData(guest)
            setRecyclerView()
        }
    }

    private fun setRecyclerView() {
        binding?.rvGuest?.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = guestAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        binding?.rvGuest?.adapter = null
    }
}