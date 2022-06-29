package com.example.cadastrodepessoas.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cadastrodepessoas.R
import com.example.cadastrodepessoas.dao.PessoasDao
import com.example.cadastrodepessoas.model.Pessoa


class CadastroFragment : Fragment() {

    private lateinit var viewModel: PessoasDao
    lateinit var pessoaCriada: Pessoa

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
        val lblNome = view.findViewById<TextView>(R.id.lblNome)
        val lblEndereco = view.findViewById<TextView>(R.id.lblEndereco)
        val lblEstado = view.findViewById<TextView>(R.id.lblEstado)
        val lblCidade = view.findViewById<TextView>(R.id.lblCidade)
        val lblTelefone = view.findViewById<TextView>(R.id.lblTelefone)
        val lblEmail = view.findViewById<TextView>(R.id.lblEmail)
        val txtNome = view.findViewById<EditText>(R.id.txtNome)
        val txtEndereco = view.findViewById<EditText>(R.id.txtEndereco)
        val txtEstado = view.findViewById<EditText>(R.id.txtEstado)
        val txtCidade = view.findViewById<EditText>(R.id.txtCidade)
        val txtTelefone = view.findViewById<EditText>(R.id.txtTelefone)
        val txtEmail = view.findViewById<EditText>(R.id.txtEmail)
        val chbEmdia = view.findViewById<CheckBox>(R.id.chbEmDia)

        var estaEmDia: Boolean

        val btnCadastrar = view.findViewById<Button>(R.id.btnCadastrar)
        btnCadastrar.setOnClickListener {

            if ((txtNome.text.toString() != "") and ( txtEndereco.text.toString() != "") and (txtEstado.text.toString() != "")
                and (txtCidade.text.toString() != "") and (txtTelefone.text.toString() != "")
                and (txtEmail.text.toString() != "")) {

                pessoaCriada = Pessoa(
                    txtNome.text.toString(),
                    txtEndereco.text.toString(),
                    txtEstado.text.toString(),
                    txtCidade.text.toString(),
                    txtTelefone.text.toString(),
                    txtEmail.text.toString(),
                    chbEmdia.isChecked
                )

                viewModel = ViewModelProvider(this).get(PessoasDao::class.java)
                viewModel.adicionar(pessoaCriada)

                navController.navigate(R.id.action_cadastroFragment_to_listaCadastradosFragment)
            } else {
                Toast.makeText(view.context, "Os campos devem estar preenchidos", Toast.LENGTH_SHORT).show()
            }
        }

        chbEmdia.setOnClickListener {
            viewModel = ViewModelProvider(this).get(PessoasDao::class.java)
            estaEmDia = chbEmdia.isChecked
            viewModel.estahEmdia(estaEmDia)
            viewModel.verificaEmDia().observe(this) {
                if (it) {
                    lblNome.setBackgroundColor(Color.CYAN)
                    txtNome.setBackgroundColor(Color.CYAN)
                    lblEndereco.setBackgroundColor(Color.CYAN)
                    txtEndereco.setBackgroundColor(Color.CYAN)
                    lblEstado.setBackgroundColor(Color.CYAN)
                    txtEstado.setBackgroundColor(Color.CYAN)
                    lblCidade.setBackgroundColor(Color.CYAN)
                    txtCidade.setBackgroundColor(Color.CYAN)
                    lblTelefone.setBackgroundColor(Color.CYAN)
                    txtTelefone.setBackgroundColor(Color.CYAN)
                    lblEmail.setBackgroundColor(Color.CYAN)
                    txtEmail.setBackgroundColor(Color.CYAN)
                } else {
                    lblNome.setBackgroundColor(Color.MAGENTA)
                    txtNome.setBackgroundColor(Color.MAGENTA)
                    lblEndereco.setBackgroundColor(Color.MAGENTA)
                    txtEndereco.setBackgroundColor(Color.MAGENTA)
                    lblEstado.setBackgroundColor(Color.MAGENTA)
                    txtEstado.setBackgroundColor(Color.MAGENTA)
                    lblCidade.setBackgroundColor(Color.MAGENTA)
                    txtCidade.setBackgroundColor(Color.MAGENTA)
                    lblTelefone.setBackgroundColor(Color.MAGENTA)
                    txtTelefone.setBackgroundColor(Color.MAGENTA)
                    lblEmail.setBackgroundColor(Color.MAGENTA)
                    txtEmail.setBackgroundColor(Color.MAGENTA)
                }
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}