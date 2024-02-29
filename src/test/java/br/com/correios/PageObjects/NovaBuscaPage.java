package br.com.correios.PageObjects;

import org.openqa.selenium.By;

import br.com.correios.metodos.Metodos;

public class NovaBuscaPage extends Metodos{

	
	//Elementos
	
	private By digiteCepOuEndereco = By.xpath("//input[@id='endereco']");
	private By btnBuscar = By.xpath("//button[@name='btn_pesquisar']");
	
	
	public By getDigiteCepOuEndereco() {
		return digiteCepOuEndereco;
	}
	public By getBtnBuscar() {
		return btnBuscar;
	}
	
	
	
	
	
	//Metodos
	
	
	
	
}
