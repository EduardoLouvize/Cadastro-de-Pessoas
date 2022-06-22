package com.example.cadastrodepessoas.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cadastrodepessoas.R
import com.example.cadastrodepessoas.databinding.FragmentCadastroBinding


class CadastroFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navController = findNavController()
        val txtNome = view.findViewById<EditText>(R.id.txtNome)
        val txtEndereco = view.findViewById<EditText>(R.id.txtEndereco)
        val txtEstado = view.findViewById<EditText>(R.id.txtEstado)
        val txtCidade = view.findViewById<EditText>(R.id.txtCidade)
        val txtTelefone = view.findViewById<EditText>(R.id.txtTelefone)
        val txtEmail = view.findViewById<EditText>(R.id.txtEmail)

        val btnCadastrar = view.findViewById<Button>(R.id.btnCadastrar)
        btnCadastrar.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("nome", txtNome.text.toString())
            bundle.putString("endereco", txtEndereco.text.toString())
            bundle.putString("estado", txtEstado.text.toString())
            bundle.putString("cidade", txtCidade.text.toString())
            bundle.putString("telefone", txtTelefone.text.toString())
            bundle.putString("email", txtEmail.text.toString())

            navController.navigate(R.id.action_cadastroFragment_to_listaCadastradosFragment, bundle)
        }

        super.onViewCreated(view, savedInstanceState)
    }




}