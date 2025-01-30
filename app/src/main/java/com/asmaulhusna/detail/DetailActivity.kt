package com.asmaulhusna.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import com.asmaulhusna.R
import com.asmaulhusna.core.domain.model.AsmaulHusna
import com.asmaulhusna.databinding.ActivityDetailBinding
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailAsmaulHusna = getParcelableExtra(intent, EXTRA_DATA, AsmaulHusna::class.java)
        showDetailAsmaulHusna(detailAsmaulHusna)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun showDetailAsmaulHusna(detailAsmaulHusna: AsmaulHusna?) {
        detailAsmaulHusna?.let {
            supportActionBar?.title = it.latin
            binding.tvArab.text = it.arabic
            binding.tvLatin.text = it.latin
            binding.tvTranslationId.text = it.translationId
            binding.tvTranslationEn.text = it.translationEn

            var statusFavorite = it.isFavorite
            setStatusFavorite(statusFavorite)
            binding.btnFavorite.setOnClickListener { _ ->
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteAsmaulHusna(detailAsmaulHusna, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        binding.btnFavorite.setIconResource(if (statusFavorite) R.drawable.ic_favorite_black_24 else R.drawable.ic_baseline_favorite_border_24)
        binding.tvTitleFavorite.text =
            if (statusFavorite) getString(com.asmaulhusna.core.R.string.unfavorite) else getString(
                com.asmaulhusna.core.R.string.favorite
            )
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}