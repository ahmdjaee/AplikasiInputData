package com.example.aplikasiinputdata

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiinputdata.data.Warga
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class WargaListAdapter : RecyclerView.Adapter<WargaListAdapter.MyViewHolder>() {
    private var wargaList = emptyList<Warga>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WargaListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row2,parent,false))
    }

    override fun onBindViewHolder(holder: WargaListAdapter.MyViewHolder, position: Int) {
        val currentItem = wargaList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_id2).text = (position+1).toString()
        holder.itemView.findViewById<TextView>(R.id.tv_warga2).text = currentItem.namaWarga
        holder.itemView.findViewById<TextView>(R.id.tv_tanggal2).text = getCurrentDate()
        holder.itemView.findViewById<TextView>(R.id.tv_uang2).text = formatMoney(currentItem.UangIuran)
        holder.itemView.findViewById<TextView>(R.id.tv_ket).text = currentItem.keterangan

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout2).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
        if (position % 2 == 0){
            holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout2).setBackgroundResource(R.color.ungu_transparan)

        }else {
            holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout2).setBackgroundResource(R.color.pink_transparan)
        }
    }
    override fun getItemCount(): Int {
        return wargaList.size
        Log.d("Size of User", wargaList.size.toString())
    }

    fun setData(user:List<Warga>){
        this.wargaList = user
        notifyDataSetChanged()
    }

    private fun getCurrentDate ():String{
        val dateFormat = SimpleDateFormat("dd/MM//YYYY", Locale.getDefault())
        val date = Date()

        return dateFormat.format(date)
    }

    fun formatMoney(amount: Int): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("in","ID"))
        return formatter.format(amount)
    }
}