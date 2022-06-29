package com.example.cadastrodepessoas.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastrodepessoas.R
import com.example.cadastrodepessoas.dao.PessoasDao
import com.example.cadastrodepessoas.model.Pessoa
import com.example.cadastrodepessoas.recyclerview.adapter.ListaPessoasAdapter

class ListaCadastradosFragment : Fragment() {

    lateinit var viewModel: PessoasDao


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_cadastrados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PessoasDao::class.java)

        val recyclerCadastrados = view.findViewById<RecyclerView>(R.id.recyclerCadastrados)
        val listaPessoas = viewModel.listarTodos()
        Log.i("ListaCadastrados", "onViewCreated: $listaPessoas")
        recyclerCadastrados?.adapter = ListaPessoasAdapter(view.context, listaPessoas)

        exportaListaPessoas(listaPessoas)
    }

    private fun exportaListaPessoas(pessoas: List<Pessoa>?) {
        val btnExportar = view!!.findViewById<Button>(R.id.btnExportar)
        btnExportar.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, pessoas.toString())
            startActivity(shareIntent)
        }
    }


}