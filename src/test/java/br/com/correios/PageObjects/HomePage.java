package br.com.correios.PageObjects;

import java.util.Set;

import org.openqa.selenium.By;

import br.com.correios.metodos.Metodos;

public class HomePage extends Metodos {

	// Elementos

	private By buscarCep = By.xpath("//input[@id='relaxation']");
	private By logradouroNome = By.xpath("//td[@data-th='Logradouro/Nome']");
	private By bairoDistrito = By.xpath("//td[@data-th='Bairro/Distrito']");
	private By LocalidadeUF = By.xpath("//td[@data-th='Localidade/UF']");
	private By CEP = By.xpath("//td[@data-th='CEP']");
	private By btnNovaBusca = By.xpath("//button[@id='btn_nbusca']");

	public By getBuscarCep() {
		return buscarCep;
	}

	public By getLogradouroNome() {
		return logradouroNome;
	}

	public By getBairoDistrito() {
		return bairoDistrito;
	}

	public By getLocalidadeUF() {
		return LocalidadeUF;
	}

	public By getCEP() {
		return CEP;
	}

	public By getBtnNovaBusca() {
		return btnNovaBusca;
	}
	
	
//Parametros
	

	

//Metodos

	public void validarCepEndereco() {

		String janelaPrincipal = driver.getWindowHandle();
		Set<String> janelasAbertas = driver.getWindowHandles();

		for (String janela : janelasAbertas) {

			if (!janela.equals(janelaPrincipal)) {

				driver.switchTo().window(janela);

			}
		}
		
		gerarEvidencia("CT01- Buscar CEP ou Endereco - caminho feliz");
		validarTexto(getLogradouroNome(), "Avenida Brigadeiro Faria Lima - de 2129 a 3251 - lado ímpar");
		validarTexto(getBairoDistrito(), "Jardim Paulistano");
		validarTexto(getLocalidadeUF(), "São Paulo/SP");
		validarTexto(getCEP(), "01452-000");

		driver.close();

	}

}
