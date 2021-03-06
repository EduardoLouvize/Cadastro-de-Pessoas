package com.example.cadastrodepessoas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.cadastrodepessoas.R


class TelaInicialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tela_inicial, container, false)


        val btnTelaCadastro = view.findViewById<Button>(R.id.btnTelaCadastro)
        btnTelaCadastro.setOnClickListener {
            val navController = findNavController()

            navController.navigate(R.id.action_telaInicialFragment_to_cadastroFragment)


        }
        return view

    }
}