package com.arafat1419.suitmedia1.ui.event.map

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.arafat1419.suitmedia1.R
import com.arafat1419.suitmedia1.data.DataEvent
import com.arafat1419.suitmedia1.databinding.FragmentMapsBinding
import com.arafat1419.suitmedia1.ui.event.EventViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {
    private lateinit var maps: GoogleMap

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: EventViewModel
    private lateinit var data: List<DataEvent>
    private lateinit var mapAdapter: MapAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            btnBack.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnBack.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.btn_add -> findNavController().popBackStack()
                }
                true
            }

            rvEvent.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val layoutManager = rvEvent.layoutManager as LinearLayoutManager
                        val position = layoutManager.findFirstVisibleItemPosition()
                        moveCamera(data[position].latLng)
                    }
                }
            })
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(rvEvent)
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync {
            this.maps = it
            loadData()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.event_menu, menu)
    }

    private fun loadData() {
        if (activity != null) {
            viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[EventViewModel::class.java]
            data = viewModel.getEvent()
            showMarker(data)
            mapAdapter = MapAdapter()
            mapAdapter.setData(data)
            setRecyclerView()
        }
    }

    private fun showMarker(event: List<DataEvent>?) {
        event?.forEach {
            maps.addMarker(MarkerOptions()
                .title(it.name)
                .position(it.latLng))
        }
        maps.moveCamera(CameraUpdateFactory.newLatLngZoom(event?.get(0)?.latLng, 15.0F))
    }

    private fun moveCamera(latLng: LatLng) {
        maps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f))
    }

    private fun setRecyclerView() {
        binding?.rvEvent?.apply {
            layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = mapAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}