package com.example.todo.starbucks.screen.home.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.example.todo.starbucks.databinding.FragmentHomeBinding
import com.example.todo.starbucks.domain.model.RecommendProduct
import com.example.todo.starbucks.domain.model.RecommendProducts

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setListAdapter()
    }

    private fun setListAdapter() {
        val topRecommendSectionAdapter = TopRecommendSectionAdapter()
        binding.rvHome.adapter = ConcatAdapter(topRecommendSectionAdapter)
        val list = RecommendProducts(
            "Stitch",
            listOf<RecommendProduct>(
                RecommendProduct("a", "b"),
                RecommendProduct("c", "q"),
                RecommendProduct("d", "w"),
                RecommendProduct("e", "e"),
            )
        )
        Log.d("test", "setListAdapter: ${list.title}")
        Log.d("test", "setListAdapter: ${list.products}")
        topRecommendSectionAdapter.submitList(listOf(list))
    }
}