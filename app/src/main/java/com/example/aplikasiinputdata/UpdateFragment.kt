package com.example.aplikasiinputdata

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.aplikasiinputdata.data.Warga
import com.example.aplikasiinputdata.data.WargaViewModel
import com.example.aplikasiinputdata.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private var _binding : FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private lateinit var mWargaViewModel: WargaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.etNamaWarga2.setText(args.currentWarga.namaWarga)
        binding.etTanggal2.setText(args.currentWarga.tanggalIuran)
        binding.etUang2.setText(args.currentWarga.UangIuran.toString())

        mWargaViewModel = ViewModelProvider(this).get(WargaViewModel::class.java)

        binding.btnUpdate.setOnClickListener {
            val id = args.currentWarga.id
//            updateDataToDatabase(id)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        binding.btnDelete.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Yakin ingin menghapus data ini?").setCancelable(false).setPositiveButton("Ya"){dialog, id -> deleteWarga()
            }.setNegativeButton("Tidak"){dialog, id -> }
            val alert = builder.create()
            alert.show()
        }
        return view

    }
    private fun deleteWarga(){
        val warga = Warga(args.currentWarga.id,args.currentWarga.namaWarga,args.currentWarga.tanggalIuran,args.currentWarga.UangIuran)
        mWargaViewModel.deleteWarga(warga)
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }

}