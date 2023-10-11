package br.com.correios.steps;

import br.com.correios.PageObjects.HomePage;
import br.com.correios.metodos.Metodos;
import br.com.correios.navegadores.Navegadores;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuscaCpfEndereco_Teste {
	
	Metodos metodo = new Metodos();
	HomePage home = new HomePage();
	
	@Given("que acesso a home page do site")
	public void queAcessoAHomePageDoSite() {
		
		Navegadores.abrirNavegador("https://www.correios.com.br/");
	  
	}
	@When("envio dados para busca no campo Busca CEP ou Endereco")
	public void envioDadosParaBuscaNoCampoBuscaCEPOuEndereco() {
		
		metodo.digitar(home.getBuscarCep(), "01452-000");
		metodo.submit(home.getBuscarCep());
	    
	}
	@Then("valido CEP ou Endereco")
	public void validoCEPOuEndereco() {
		
		home.validarCepEndereco();
		Navegadores.fecharNavegador();
		
	    
	}



	
	
	

}
