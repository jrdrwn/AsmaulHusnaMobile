package com.asmaulhusna.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asmaulhusna.core.data.Resource
import com.asmaulhusna.core.ui.AsmaulHusnaAdapter
import com.asmaulhusna.databinding.FragmentHomeBinding
import com.asmaulhusna.detail.DetailActivity
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val asmaulHusnaAdapter = AsmaulHusnaAdapter()
        asmaulHusnaAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        homeViewModel.asmaulHusna.observe(viewLifecycleOwner) { result ->
            if (result != null) {
                when (result) {
                    is Resource.Loading -> {
                        binding.loading.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        binding.loading.visibility = View.GONE
                        with(binding.rvAsmaulHusna) {
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = asmaulHusnaAdapter
                        }
                        asmaulHusnaAdapter.submitList(result.data)
                    }

                    is Resource.Error -> {
                        binding.loading.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}