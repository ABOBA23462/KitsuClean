package com.example.kitsuclean.presentation.ui.fragments.anime.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.kitsuclean.R
import com.example.kitsuclean.databinding.FragmentAnimeDetailBinding
import com.example.kitsuclean.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args: AnimeDetailFragmentArgs by navArgs()

    override fun setupSubscribes() {
        binding.tvAnimeDetail.text = args.model.attributes.titles.enJp
        Glide.with(binding.imgAnimeDetail).load(args.model.attributes.posterImage.large)
            .into(binding.imgAnimeDetail)
    }
}