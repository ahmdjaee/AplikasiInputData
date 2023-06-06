package com.example.aplikasiinputdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiinputdata.data.WargaViewModel
import com.example.aplikasiinputdata.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding : FragmentListBinding? = null
    private val binding get() =_binding!!
    private lateinit var mWargaViewModel: WargaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        //Menyiapkan adapter
        val adapter = WargaListAdapter()
        val rvWarga = binding.rvWarga
        rvWarga.adapter = adapter

        rvWarga.layoutManager = LinearLayoutManager(requireContext())

        mWargaViewModel = ViewModelProvider(this).get(WargaViewModel::class.java)
        mWargaViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            warga -> adapter.setData(warga)
        })

        binding.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}