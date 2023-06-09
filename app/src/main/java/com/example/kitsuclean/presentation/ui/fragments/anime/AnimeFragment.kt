package com.example.kitsuclean.presentation.ui.fragments.anime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuclean.R
import com.example.kitsuclean.databinding.FragmentAnimeBinding
import com.example.kitsuclean.domain.utils.Resource
import com.example.kitsuclean.presentation.base.BaseFragment
import com.example.kitsuclean.presentation.ui.adapters.AnimeAdapter
import com.example.kitsuclean.presentation.ui.fragments.home.HomeFragmentDirections
import com.example.kitsueasyclean.presentation.models.DataItemUI
import com.example.kitsueasyclean.presentation.models.toUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initialize() {
        binding.animeRecView.adapter = animeAdapter
    }

    override fun setupSubscribes() {
        subscribeToFetchAnime()
    }

    private fun subscribeToFetchAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fetchAnime().collect {
                    when(it) {
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Loading -> {}
                        is Resource.Success -> {
                            animeAdapter.submitList(it.data?.map {
                                it.toUI()
                            })
                        }
                    }
                }
            }
        }
    }

    private fun onItemClick(model: DataItemUI) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAnimeDetailFragment(model)
        )
    }
}