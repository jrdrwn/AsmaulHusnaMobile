package com.asmaulhusna.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asmaulhusna.core.databinding.ItemListAsmaulHusnaBinding
import com.asmaulhusna.core.domain.model.AsmaulHusna

class AsmaulHusnaAdapter :
    ListAdapter<AsmaulHusna, AsmaulHusnaAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((AsmaulHusna) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemListAsmaulHusnaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListAsmaulHusnaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AsmaulHusna) {
            binding.tvArab.text = data.arabic
            binding.tvLatin.text = data.latin
//            binding.tvTranslationId.text =
//                itemView.context.getString(R.string.translation_id, data.translationId)
//            binding.tvTranslationEn.text =
//                itemView.context.getString(R.string.translation_en, data.translationEn)

        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<AsmaulHusna> =
            object : DiffUtil.ItemCallback<AsmaulHusna>() {
                override fun areItemsTheSame(oldItem: AsmaulHusna, newItem: AsmaulHusna): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: AsmaulHusna,
                    newItem: AsmaulHusna
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }


}