package br.com.correios.PageObjects;

import java.util.Set;

import org.openqa.selenium.By;

import br.com.correios.metodos.Metodos;
import br.com.correios.utils.MassaDados;

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

	public void validarCepEndereco(String logradouro, String bairro, String uf, String cep)
			throws InterruptedException {

		String janelaPrincipal = driver.getWindowHandle();
		Set<String> janelasAbertas = driver.getWindowHandles();

		for (String janela : janelasAbertas) {

			if (!janela.equals(janelaPrincipal)) {

				driver.switchTo().window(janela);

			}
		}

		validarTexto(getLogradouroNome(), logradouro);
		validarTexto(getBairoDistrito(), bairro);
		validarTexto(getLocalidadeUF(), uf);
		validarTexto(getCEP(), cep);
		gerarEvidencia("CT01- " + driver.findElement(getCEP()).getText() + " validado");
		// driver.switchTo().window(janelaPrincipal);
		// Thread.sleep(1000);
		// driver.close();

	}

	public void buscarCEP(String cep) {

		/**
		 * Metodo para digitar textos em um elemento Web
		 */

		try {

			driver.findElement(getBuscarCep()).sendKeys(cep);

			submit(getBuscarCep());

		} catch (Exception e) {
			System.out.println("erro ao digitar o " + cep + " no elemento web " + getBuscarCep() + ".");
		}
	}
	
	
	public void validarLogradouro(String logradouro)
			throws InterruptedException {

		String janelaPrincipal = driver.getWindowHandle();
		Set<String> janelasAbertas = driver.getWindowHandles();

		for (String janela : janelasAbertas) {

			if (!janela.equals(janelaPrincipal)) {

				driver.switchTo().window(janela);

			}
		}

		validarTexto(getLogradouroNome(), logradouro);
		gerarEvidencia("CT01- " + driver.findElement(getCEP()).getText() + " validado");
		// driver.switchTo().window(janelaPrincipal);
		// Thread.sleep(1000);
		// driver.close();

	}
	
	
	
	
	
	
	

}
