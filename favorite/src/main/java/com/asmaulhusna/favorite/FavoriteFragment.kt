package com.asmaulhusna.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asmaulhusna.core.ui.AsmaulHusnaAdapter
import com.asmaulhusna.detail.DetailActivity
import com.asmaulhusna.favorite.databinding.FragmentFavoriteBinding
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavoriteViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        loadKoinModules(favoriteModule)
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

        viewModel.favoriteAsmaulHusna.observe(viewLifecycleOwner) { result ->

            with(binding.rvAsmaulHusna) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = asmaulHusnaAdapter
            }
            asmaulHusnaAdapter.submitList(result)
            binding.tvEmptyFavorite.visibility =
                if (result.isNotEmpty()) View.GONE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}