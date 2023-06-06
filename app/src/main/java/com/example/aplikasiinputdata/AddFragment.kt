package com.example.aplikasiinputdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aplikasiinputdata.data.Warga
import com.example.aplikasiinputdata.data.WargaViewModel
import com.example.aplikasiinputdata.databinding.FragmentAddBinding


class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var mWargaViewModel:WargaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        mWargaViewModel = ViewModelProvider(this).get(WargaViewModel::class.java)
        binding.btnSave.setOnClickListener {
            insertDataToDatabase()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        return view
    }

    private fun insertDataToDatabase(){
        val namaWarga = binding.etNamaWarga.text.toString()
//        val tanggal = binding.etTanggal.text.toString()
        val keterangan = binding.etKeterangan.text.toString()
        val uang = Integer.parseInt(binding.etUang.text.toString())

        val warga = Warga (0, namaWarga, keterangan, uang)
        mWargaViewModel.addWarga(warga)
    }
}