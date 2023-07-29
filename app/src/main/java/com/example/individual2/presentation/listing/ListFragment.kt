package com.example.individual2.presentation.listing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.individual2.R
import com.example.individual2.databinding.FragmentListBinding
import com.example.individual2.presentation.ItemsViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private val viewModel: ItemsViewModel by activityViewModels()

    private val adapter = ItemsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        initRecyclerView()
        loadData()
        initListener()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.listItems.adapter = adapter
    }

    private fun loadData() {
        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initListener() {
        binding.addItem.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }
}