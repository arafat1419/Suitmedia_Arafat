package com.arafat1419.suitmedia1.ui.event.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.databinding.FragmentEventBinding
import com.arafat1419.suitmedia1.ui.event.EventViewModel

class EventFragment : Fragment() {

    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding

    private lateinit var eventAdapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEventBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            btnBack.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            btnBack.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.btn_add -> findNavController().navigate(R.id.action_eventFragment_to_mapsFragment)
                }
                true
            }
        }
        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.event_menu, menu)
    }

    private fun loadData() {
        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[EventViewModel::class.java]
            val event = viewModel.getEvent()

            eventAdapter = EventAdapter()
            eventAdapter.setData(event)
            setRecyclerView()
        }
    }

    private fun setRecyclerView() {
        binding?.rvEvent?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = eventAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        binding?.rvEvent?.adapter = null
    }
}