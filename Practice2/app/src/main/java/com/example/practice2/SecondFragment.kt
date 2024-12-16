package com.example.pr2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.practice2.databinding.FragmentSecondBinding
import com.example.practice2.R

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Переход на третий фрагмент
        binding.nextFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }

        // Возвращение на первый фрагмент
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
