package com.example.todo.starbucks.screen.order.detailorder

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todo.starbucks.databinding.FragmentDetailOrderBinding
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.screen.order.Notification
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailOrderFragment : Fragment() {

    private val DEFAULT_STRING = ""
    private lateinit var binding: FragmentDetailOrderBinding
    private val bundleOrder by lazy { requireArguments().getSerializable("order") as Order }
    private val viewModel by viewModel<DetailOrderViewModel> {
        parametersOf(bundleOrder.id ?: DEFAULT_STRING)
    }
    private val notification by lazy { Notification(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setFullScreen()
        binding = FragmentDetailOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        setNavigation()
        observeData()
        binding.btnOrder.setOnClickListener { notification.notify(binding.tvName.text.toString()) }
    }

    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.detail.collectLatest { state ->
                when (state) {
                    is DetailOrderState.Loading -> handlerLoading()
                    is DetailOrderState.GetDetail -> handlerSuccess(state)
                    else -> handlerError()
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isFavorite.collect { isFavorite ->
                binding.btnLike.isSelected = isFavorite
            }
        }
    }

    private fun handlerSuccess(state: DetailOrderState.GetDetail) {
        with(binding) {
            setVisible(true)
            progressBar.visibility = View.GONE
            btnRetry.visibility = View.GONE
            state.detail.price = bundleOrder.price
            order = state.detail
        }
    }

    private fun handlerError() {
        with(binding) {
            setVisible(false)
            progressBar.visibility = View.GONE
            btnRetry.visibility = View.VISIBLE
        }
        binding.btnRetry.setOnClickListener {
            viewModel.getDetail(bundleOrder.id ?: DEFAULT_STRING)
        }
    }

    private fun handlerLoading() = with(binding) {
        setVisible(false)
        progressBar.visibility = View.VISIBLE
        btnRetry.visibility = View.GONE
    }

    private fun setFullScreen() {
        requireActivity().window?.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            this.statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun setNavigation() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setVisible(isVisible: Boolean) = with(binding) {
        if (!isVisible) {
            tvKcal.visibility = View.GONE
            tvKcalText.visibility = View.GONE
            tvSugar.visibility = View.GONE
            tvSugarText.visibility = View.GONE
            tvSodium.visibility = View.GONE
            tvSodiumText.visibility = View.GONE
            tvProtein.visibility = View.GONE
            tvProteinText.visibility = View.GONE
            tvCaffeine.visibility = View.GONE
            tvCaffeineText.visibility = View.GONE
            tvSatFat.visibility = View.GONE
            tvSatFatText.visibility = View.GONE
            tvAllergyText.visibility = View.GONE
            tvAllergy.visibility = View.GONE
            ivMain.visibility = View.GONE
            tvName.visibility = View.GONE
            btnLike.visibility = View.GONE
            tvDescription.visibility = View.GONE
            tvNameEvg.visibility = View.GONE
            tvPrice.visibility = View.GONE
        } else {
            tvKcal.visibility = View.VISIBLE
            tvKcalText.visibility = View.VISIBLE
            tvSugar.visibility = View.VISIBLE
            tvSugarText.visibility = View.VISIBLE
            tvSodium.visibility = View.VISIBLE
            tvSodiumText.visibility = View.VISIBLE
            tvProtein.visibility = View.VISIBLE
            tvProteinText.visibility = View.VISIBLE
            tvCaffeine.visibility = View.VISIBLE
            tvCaffeineText.visibility = View.VISIBLE
            tvSatFat.visibility = View.VISIBLE
            tvSatFatText.visibility = View.VISIBLE
            tvAllergyText.visibility = View.VISIBLE
            tvAllergy.visibility = View.VISIBLE
            ivMain.visibility = View.VISIBLE
            tvName.visibility = View.VISIBLE
            btnLike.visibility = View.VISIBLE
            tvDescription.visibility = View.VISIBLE
            tvNameEvg.visibility = View.VISIBLE
            tvPrice.visibility = View.VISIBLE
        }
    }
}