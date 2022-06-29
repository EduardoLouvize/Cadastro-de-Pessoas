package com.example.cadastrodepessoas.dao

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cadastrodepessoas.model.Pessoa

class PessoasDao : ViewModel() {



    fun adicionar(pessoa: Pessoa) {
        pessoas.add(pessoa)
    }

    fun listarTodos(): List<Pessoa> {
        return pessoas
    }


    fun estahEmdia(emDia: Boolean){
        _emDiaStatus.value = emDia
        Log.i("TAG", "estahEmdia: ${_emDiaStatus.value}")
    }

    fun verificaEmDia():LiveData<Boolean>{
        Log.i("TAG", "verificaEmDia: ${_emDiaStatus.value}")
        return _emDiaStatus
    }

    companion object {
        private val pessoas = mutableListOf<Pessoa>()

        private var _emDiaStatus = MutableLiveData<Boolean>()
    }
}