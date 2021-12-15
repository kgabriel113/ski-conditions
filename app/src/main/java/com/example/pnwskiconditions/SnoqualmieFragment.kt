package com.example.pnwskiconditions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SpinnerAdapter
import com.example.pnwskiconditions.databinding.FragmentSnoqualmieBinding


class SnoqualmieFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var binding: FragmentSnoqualmieBinding? = null
    private val fragmentViewModel: SnoqualmieViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentSnoqualmieBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = fragmentViewModel
            snoqualmieFragment = this@SnoqualmieFragment
        }
    }

    fun setArea(){
        Log.d("DEBUG", "selected new area")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.d("DEBUG", "on item selected: $p2")
        fragmentViewModel.setArea(p2)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}