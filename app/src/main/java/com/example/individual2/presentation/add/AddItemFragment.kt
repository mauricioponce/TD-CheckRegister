package com.example.individual2.presentation.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.individual2.R
import com.example.individual2.databinding.FragmentAddItemBinding
import com.example.individual2.presentation.ItemsViewModel

class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding

    private val viewModel: ItemsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(inflater, container, false)

        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.btAdd.setOnClickListener {
            val name = binding.inputTextItemName.text.toString()
            val quantity = binding.inputTextItemQuantity.text.toString().toInt()
            val price = binding.inputTextItemPrice.text.toString().toInt()

            viewModel.insertItem(name, quantity, price)

            showSuccessfulMessage()
            cleanUI()
        }
    }

    private fun showSuccessfulMessage() {
        Toast.makeText(requireContext(), R.string.successful_add, Toast.LENGTH_LONG).show()
    }

    private fun cleanUI() {
        binding.inputTextItemName.setText("")
        binding.inputTextItemQuantity.setText("")
        binding.inputTextItemPrice.setText("")
    }
}