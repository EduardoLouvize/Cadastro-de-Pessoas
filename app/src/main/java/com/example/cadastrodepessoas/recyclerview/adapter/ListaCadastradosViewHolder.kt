package com.example.cadastrodepessoas.recyclerview.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastrodepessoas.R
import com.example.cadastrodepessoas.model.Pessoa

class ListaCadastradosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val nome = itemView.findViewById<TextView>(R.id.lblNomeCadastrado)
    val endereco = itemView.findViewById<TextView>(R.id.lblEnderecoCadastrado)
    val estado = itemView.findViewById<TextView>(R.id.lblEstadoCadastrado)
    val cidade = itemView.findViewById<TextView>(R.id.lblCidadeCadastrada)
    val telefone = itemView.findViewById<TextView>(R.id.lblTelefoneCdastrado)
    val email = itemView.findViewById<TextView>(R.id.lblEmailCadastrado)

    fun vincula(pessoa: Pessoa) {

        nome.text = pessoa.nome
        endereco.text = pessoa.endereco
        estado.text = pessoa.estado
        cidade.text = pessoa.cidade
        telefone.text = pessoa.telefone
        email.text = pessoa.email
    }


}