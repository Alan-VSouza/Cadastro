package com.alan.cadastro

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressarEspera: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return """
            - Cadastro realizado com sucesso
            
            Nome: $nome
            Telefone: $telefone
            Email: $email
            Lista de espera: ${if (ingressarEspera) "Sim" else "Não"}
            Sexo: $sexo
            Cidade: $cidade
            Estado: $uf
        """.trimIndent()
    }
}
