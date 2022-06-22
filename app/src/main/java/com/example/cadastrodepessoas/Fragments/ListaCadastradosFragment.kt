package com.example.cadastrodepessoas.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cadastrodepessoas.R

class ListaCadastradosFragment : Fragment() {

    var nome: String = ""
    var endereco: String = ""
    var estado: String = ""
    var cidade: String = ""
    var telefone: String = ""
    var email: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        nome  = arguments?.getString("nome").toString()
        endereco  = arguments?.getString("endereco").toString()
        estado  = arguments?.getString("estado").toString()
        cidade  = arguments?.getString("cidade").toString()
        telefone  = arguments?.getString("telefone").toString()
        email  = arguments?.getString("email").toString()

        return inflater.inflate(R.layout.fragment_lista_cadastrados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtNome = view.findViewById<TextView>(R.id.lblNomeCadastrado)
        val txtEndereco = view.findViewById<TextView>(R.id.lblEnderecoCadastrado)
        val txtEstado = view.findViewById<TextView>(R.id.lblEstadoCadastrado)
        val txtCidade = view.findViewById<TextView>(R.id.lblCidadeCadastrada)
        val txtTelefone = view.findViewById<TextView>(R.id.lblTelefoneCdastrado)
        val txtEmail = view.findViewById<TextView>(R.id.lblEmailCadastrado)

        txtNome.text = nome
        txtEndereco.text = endereco
        txtEstado.text = estado
        txtCidade.text = cidade
        txtTelefone.text = telefone
        txtEmail.text = email

    }


}