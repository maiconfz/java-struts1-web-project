# Projeto web Java 7, Struts 1, jQuery, Bootstrap 3... para avaliações

[![en](https://img.shields.io/badge/lang-en-red.svg)](./README.md)
[![pt](https://img.shields.io/badge/lang-pt-green.svg)](./README-PT.md)

Projeto para avaliar o conhecimento necessário para trabalhar com projetos legados utilizando as seguintes tecnologias:

- Java 7
- JDBC connections
- Servlets
- Struts 1
- JSP/Scriptlets/JSTL
- Configuração do projeto na IDE Eclipse
- Jquery
- Bootstrap 3.x

## Notas e dicas

1. Você pode usar o site <https://www.lipsum.com/> para gerar textos
1. O "nível de compilação do Java" do projeto é 7, mas você deve usar o Java 8u202 e não pode usar os recursos do Java 8. (Você pode baixar o jdk em <https://www.oracle.com/pt/java/technologies/javase/javase8-archive-downloads.html>)

## Tarefas

1. Faça um fork deste repositório para fazer as alterações em seu próprio repositório

1. Configure o projeto para rodar em um servidor Tomcat 7, com java 8u202

1. Crie uma página estática pública e outra privada (deve estar logado) exibindo qualquer informação
     - Adicione-os ao menu do cabeçalho e escolha um layout de página existente
     - Adicione alguns componentes de bootstrap, apenas mostre o uso deles

1. Crie a funcionalidade de logout
     - Action, limpeza de sessão e redirecionamento para página de Login
     - O link de logout já está definido no cabeçalho da página

1. Crie um novo atributo para o "User"
     - email (Obrigatório e deve ser um email válido. Use regex ou qualquer lib para validá-lo)

1. Utilizando a área do "User" como exemplo, crie a área "Companies" com as seguintes funcionalidades:
     - Características
         - Lista
         - Criar
         - Editar
         - Excluir
     - Dados a serem coletados (todos necessários)
         - Nome
         - Endereço
         - Número de IVA (não precisa ser um número de IVA válido)
         - País (lista do banco de dados)
         - Cidade (lista do banco de dados, filtrada pelo país selecionado)

1. Abra um pull request (O pull request não será aceito... é apenas para avaliação)

### Opcional

1. Converta o projeto em um projeto Maven/Gradle
