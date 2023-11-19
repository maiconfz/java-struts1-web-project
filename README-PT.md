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

## Tarefas


1. Faça um fork deste repositório para fazer as alterações em seu próprio repositório

1. Crie uma página estática pública e outra privada (deve estar logado) exibindo qualquer informação
     - Adicione-os ao menu do cabeçalho e escolha um layout de página existente
     - Adicione alguns componentes de bootstrap, apenas mostre o uso deles

1. Crie a funcionalidade de logout
     - Ação, limpeza de sessão e redirecionamento para página de Login
     - O link de logout já está definido no cabeçalho da página

1. Crie 2 novos atributos para "People"
     - Data de nascimento (obrigatório e deve ser uma data válida)
     - Documento (Obrigatório apenas se a pessoa tiver 18 anos ou mais)
         - Tipo
         - Número (não precisa ser um número de documento válido)

1. Usando a área "People" como exemplo, crie uma nova para criar "Companies" conforme segue
     - Características
         - Criar
         - Editar
         - Lista
         - Excluir (deve ser feito na página de listagem e de forma assíncrona)
     - Dados a serem coletados (todos necessários)
         - Nome
         - Endereço
         - Número de IVA (não precisa ser um número de IVA válido)
         - País (lista do banco de dados)
         - Cidade (lista do banco de dados, filtrada pelo país selecionado)

1. Abra um pull request (O pull request não será aceito... é apenas para avaliação)

### Opcional

1. Converta o projeto em um projeto Maven/Gradle

### Opcional

1. Converta o projeto em um projeto Maven/Gradle

## Notas e dicas

1. Você pode usar o site https://www.lipsum.com/ para gerar textos
1. O nível de compilação java do projeto é 1.7, mas você pode usar um jdk 1.8 até 1.8.265 (não é possível usar recursos java 8)