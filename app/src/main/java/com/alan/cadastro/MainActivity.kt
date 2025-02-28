package com.alan.cadastro

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome: EditText = findViewById(R.id.et_nome)
        val etTelefone: EditText = findViewById(R.id.et_telefone)
        val etEmail: EditText = findViewById(R.id.et_email)
        val cbEspera: CheckBox = findViewById(R.id.cb_espera)
        val rgSexo: RadioGroup = findViewById(R.id.rg_sexo)
        val etCidade: EditText = findViewById(R.id.et_cidade)
        val spinnerUF: Spinner = findViewById(R.id.spinner_uf)
        val btnLimpar: Button = findViewById(R.id.btn_limpar)
        val btnSalvar: Button = findViewById(R.id.btn_salvar)

        val estados = arrayOf(
            "Selecione um estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
            "RO", "RR", "SC", "SP", "SE", "TO"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados)
        spinnerUF.adapter = adapter

        etTelefone.addTextChangedListener(object : TextWatcher {
            var isEditing = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isEditing || s.isNullOrEmpty()) return

                isEditing = true
                val clean = s.replace(Regex("[^0-9]"), "")
                val formatted = when {
                    clean.length <= 10 -> "(${clean.take(2)}) ${clean.drop(2).take(4)}-${clean.drop(6)}"
                    clean.length > 10 -> "(${clean.take(2)}) ${clean.drop(2).take(5)}-${clean.drop(7)}"
                    else -> clean
                }

                etTelefone.setText(formatted)
                etTelefone.setSelection(formatted.length)
                isEditing = false
            }
        })

        btnLimpar.setOnClickListener {
            etNome.text.clear()
            etTelefone.text.clear()
            etEmail.text.clear()
            cbEspera.isChecked = false
            rgSexo.clearCheck()
            etCidade.text.clear()
            spinnerUF.setSelection(0)
            etTelefone.error = null
            etEmail.error = null

            Toast.makeText(this, "Formulário limpo com sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val telefone = etTelefone.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val ingressarEspera = cbEspera.isChecked
            val cidade = etCidade.text.toString().trim()
            val uf = spinnerUF.selectedItem.toString()

            val sexoSelecionado = when (rgSexo.checkedRadioButtonId) {
                R.id.rb_masculino -> "Masculino"
                R.id.rb_feminino -> "Feminino"
                else -> "Não informado"
            }

            if (!telefone.matches(Regex("\\(\\d{2}\\) \\d{4,5}-\\d{4}"))) {
                etTelefone.error = "Formato inválido! Use: (XX) XXXXX-XXXX"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "E-mail inválido!"
                return@setOnClickListener
            }

            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cidade.isEmpty() || uf == "Selecione um estado") {
                Toast.makeText(this, "⚠️ Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val formulario = Formulario(
                nome, telefone, email, ingressarEspera, sexoSelecionado, cidade, uf
            )

            Toast.makeText(this, "✅ Cadastro Confirmado:\n${formulario}", Toast.LENGTH_LONG).show()
        }
    }
}
