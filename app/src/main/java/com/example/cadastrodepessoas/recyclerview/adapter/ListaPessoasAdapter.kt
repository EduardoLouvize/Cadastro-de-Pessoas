package com.example.cadastrodepessoas.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastrodepessoas.R
import com.example.cadastrodepessoas.model.Pessoa

class ListaPessoasAdapter(
    private val context: Context,
    private val pessoas: List<Pessoa>?
) : RecyclerView.Adapter<ListaCadastradosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaCadastradosViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.pessoa_item, parent, false)
        return ListaCadastradosViewHolder(view)
    }

    override fun getItemCount(): Int = pessoas!!.size

    override fun onBindViewHolder(holder: ListaCadastradosViewHolder, position: Int) {

        val pessoa = pessoas?.get(position)
        holder.vincula(pessoa!!)


    }


}
