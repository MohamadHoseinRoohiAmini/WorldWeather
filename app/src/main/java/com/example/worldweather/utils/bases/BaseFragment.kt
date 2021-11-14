package com.example.worldweather.utils.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.worldweather.BR

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutRecourceId: Int) :
    Fragment() {
    protected abstract val viewModel: VM
    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<B>(inflater, layoutRecourceId, container, false).also {
            binding = it
        }.root

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        viewModel.setLatLonTehran()
        init()
        observedLiveData()
    }

    abstract fun init()

    open fun observedLiveData() {

    }

    fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}