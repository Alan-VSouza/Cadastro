# 📌 Projeto: Cadastro  

# Feito por: Alan Souza - SC3038319

## 📄 Descrição  
Este é um **aplicativo Android** desenvolvido para um **formulário de cadastro**, onde os usuários podem inserir suas informações pessoais e salvar os dados. O projeto faz parte de um exercício acadêmico para validar conhecimentos sobre:  

✔ **Componentes de UI** (Layouts, EditTexts, Buttons, Spinners, CheckBox, RadioGroup).  
✔ **Tratamento de eventos** (Listeners para clique e entrada de dados).  
✔ **Uso de recursos e Strings no XML**.  
✔ **Manipulação de `Toast` para feedback ao usuário.**  
✔ **Validação e formatação de dados (telefone e e-mail).**  
✔ **Instanciação de um objeto `Formulario` ao salvar os dados.**  

---

## 🛠 Funcionalidades  

🔹 **Preenchimento do formulário** com os seguintes campos:  
   - Nome Completo  
   - Telefone *(formatado automaticamente para (XX) XXXXX-XXXX)*  
   - E-mail *(verificação automática de formato válido)*  
   - Cidade  
   - Estado (UF) *(selecionável via Spinner)*  
   - Sexo *(Masculino/Feminino - RadioButton)*  
   - Opção para ingressar na lista de espera *(CheckBox)*  

🔹 **Validação dos dados antes do envio:**  
   - ⚠️ Bloqueia envio se algum campo estiver vazio.  
   - ⚠️ Exibe erro se o telefone ou e-mail estiverem em formato inválido.  

🔹 **Botão "Salvar"**  
   - Instancia um objeto `Formulario` com os dados preenchidos.  
   - Exibe um `Toast` confirmando o cadastro com as informações inseridas.  

🔹 **Botão "Limpar"**  
   - Reseta todos os campos do formulário.  
   - Exibe um `Toast` informando que os dados foram apagados.  

---

## 📲 Tecnologias Utilizadas  

✅ **Kotlin** (Linguagem principal)  
✅ **Android XML** (Construção da interface)  
✅ **ConstraintLayout, ScrollView, LinearLayout** (Organização do layout)  
✅ **EditText, Button, CheckBox, Spinner, RadioGroup** (Componentes de UI)  
✅ **Validação com `Patterns.EMAIL_ADDRESS` e `Regex` para telefone**  
✅ **Mensagens `Toast` para feedback do usuário**  
