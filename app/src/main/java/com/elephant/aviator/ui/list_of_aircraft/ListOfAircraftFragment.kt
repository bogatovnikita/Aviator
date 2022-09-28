package com.elephant.aviator.ui.list_of_aircraft

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elephant.aviator.adapters.AircraftCardAdapter
import com.elephant.aviator.databinding.FragmentListOfAircraftBinding
import com.elephant.domain.models.InfoModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListOfAircraftFragment : Fragment() {
    private var _binding: FragmentListOfAircraftBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListOfAircraftViewModel by viewModel<ListOfAircraftViewModel>()
    private lateinit var adapter: AircraftCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListOfAircraftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObserve()
    }

    private fun initAdapter() {
        adapter = AircraftCardAdapter(object : AircraftCardAdapter.Listener {
            override fun onCLickInfoModel(infoModel: InfoModel) {
                navigateTo(infoModel)
            }
        })
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerView.layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        binding.recyclerView.adapter = adapter
    }

    private fun initObserve() {
        viewModel.state.observe(viewLifecycleOwner) {
            adapter.submitList(it.listOfAircraft)
        }
    }

    private fun navigateTo(aircraft: InfoModel) {
        findNavController().navigate(
            ListOfAircraftFragmentDirections.actionListOfAircraftFragmentToDescriptionAircraftFragment(
                aircraft = aircraft
            )
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}