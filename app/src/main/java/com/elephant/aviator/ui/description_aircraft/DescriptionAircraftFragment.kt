package com.elephant.aviator.ui.description_aircraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.elephant.aviator.adapters.AircraftDescriptionAdapter
import com.elephant.aviator.databinding.FragmentDescriptionAircraftBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DescriptionAircraftFragment : Fragment() {
    private var _binding: FragmentDescriptionAircraftBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<DescriptionAircraftFragmentArgs>()
    private val viewModel: DescriptionAircraftViewModel by viewModel<DescriptionAircraftViewModel>()
    private val adapter = AircraftDescriptionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescriptionAircraftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAircraftDescriptionList()
        initAdapter()
        initObserver()
    }

    private fun initObserver() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.textList)
        }
    }

    private fun initAircraftDescriptionList() {
        viewModel.initState(args.aircraft)
    }

    private fun initAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}