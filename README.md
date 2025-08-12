# 🎟️ Ticket-Master

## 📖 Descrição

Ticket-Master é um simulador de sistema de criação e gerenciamento de chamados. Inicialmente desenvolvido com API REST usando JSON para criação de usuários e analistas, o projeto evoluiu para uma interface web com Thymeleaf, permitindo que usuários criem tickets, selecionem nível de prioridade e recebam notificações por e-mail no ato da criação. Analistas podem visualizar todos os chamados criados e gerar relatórios em PDF ou CSV. 📩📊

---

## 🛠️ Tecnologias Utilizadas

- ☕ Java 22  
- 🚀 Spring Boot  
- 🐘 PostgreSQL  
- 🌐 Thymeleaf  
- 📦 Maven  
- 📧 JavaMail  
- 📄 iTextPDF  
- 📊 Apache POI  

---

## ✨ Funcionalidades Principais

- 👥 Cadastro e autenticação de usuários e analistas via REST e interface web  
- 📝 Criação de chamados com seleção de prioridade  
- 📩 Envio automático de e-mail para o usuário no momento da criação do chamado  
- 👀 Visualização e gerenciamento de chamados para analistas  
- 📊 Geração de relatórios em PDF e CSV dos chamados registrados  

---

## 🚀 Como Rodar o Projeto

### ⚙️ Pré-requisitos

- ☕ Java 22 instalado  
- 🐘 PostgreSQL configurado e em execução  
- 📦 Maven instalado  
- 📧 Configuração SMTP para envio de e-mails  

### 📋 Passos

1. Clone este repositório  
2. Configure o banco de dados no arquivo `application.properties` (ou `application.yml`) com suas credenciais do PostgreSQL  
3. Configure as propriedades SMTP para o envio de e-mails  
4. No terminal, na pasta raiz do projeto, execute:

   ```bash
   mvn clean install
   java -jar target/ticket-master.jar
