#Author: your.email@your.domain.com

@regressivos @positivos
Feature: Busca CEP ou Endereco
  Como usuario do site
  Quero pesquisar um CEP ou endereco no campo Busca CEP ou Endereco
  Para encontrar um CEP ou endereco desejado

Background:

	 Given que acesso a home page do site


  @CT01
  Scenario: Busca CEP ou endereco
  
   When envio dados para busca no campo Busca CEP ou Endereco
   Then valido CEP ou Endereco

  