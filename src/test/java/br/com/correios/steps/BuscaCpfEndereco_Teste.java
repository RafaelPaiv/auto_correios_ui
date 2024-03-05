package br.com.correios.steps;

import java.io.IOException;

import br.com.correios.PageObjects.HomePage;
import br.com.correios.metodos.Metodos;
import br.com.correios.navegadores.Navegadores;
import br.com.correios.utils.MassaDados;
import br.com.correios.utils.MassaDeDados;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuscaCpfEndereco_Teste {
	
	Metodos metodo = new Metodos();
	HomePage home = new HomePage();
	MassaDados massa = new MassaDados();
	MassaDeDados mas = new MassaDeDados();
	
	@Given("que acesso a home page do site")
	public void queAcessoAHomePageDoSite() {
		
		Navegadores.abrirNavegador("https://www.correios.com.br/");
	  
	}
	@When("envio dados para busca no campo Busca CEP ou Endereco")
	public void envioDadosParaBuscaNoCampoBuscaCEPOuEndereco() {
		
		home.buscarCEP(mas.incerirCEP());
	    
	}
	@Then("valido CEP ou Endereco")
	public void validoCEPOuEndereco() throws IOException {
		
		
		massa.buscarDadosExcel();
		Navegadores.fecharNavegador();
		
		
	}



	
	
	

}
