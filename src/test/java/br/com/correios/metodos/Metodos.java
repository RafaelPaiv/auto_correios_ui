package br.com.correios.metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import br.com.correios.drivers.Drivers;
import io.cucumber.messages.types.Duration;

public class Metodos extends Drivers {

	public void digitar(By elemento, String texto) {

		/**
		 * Metodo para digitar textos em um elemento Web
		 */

		try {

			driver.findElement(elemento).sendKeys(texto);

		} catch (Exception e) {
			System.out.println("erro ao digitar o " + texto + " no elemento web " + elemento + ".");
		}
	}

	public void clicar(By elemento) {

		/**
		 * Metodo para clicar em um elemento Web
		 */

		try {

			driver.findElement(elemento).click();

		} catch (Exception e) {
			System.out.println("erro ao clicar no elemento web " + elemento + ".");
		}
	}

	public void submit(By elemento) {

		/**
		 * Metodo para enviar um dado diretamente em um elemento Web
		 */

		try {

			driver.findElement(elemento).submit();

		} catch (Exception e) {
			System.out.println("erro ao enviar o dado pelo elemento web " + elemento + ".");
		}
	}

	public void gerarEvidencia(String nomeEvidencia) {

		/**
		 * Metodo para gerar printscreen de telas Web
		 */

		try {

			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			File srcDest = new File("./evidencias/" + nomeEvidencia + ".png");
			FileUtils.copyFile(scrFile, srcDest);

		} catch (Exception e) {
			System.out.println("erro ao gerar a evidencia " + nomeEvidencia + ".");
		}
	}

	public void tirarPrint(String nomeEvidencia) {

		// Converta o driver em TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Tire o screenshot e armazene-o em um objeto File
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		// Especifique o local onde deseja salvar o arquivo de imagem
		File destFile = new File("./evidencias/" + nomeEvidencia + ".png");

		// Copie o arquivo de origem para o destino
		try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("erro");
			e.printStackTrace();
		}

	}

	public void validarTexto(By elemento, String textoEsperado) {

		/**
		 * Metodo para validar textos em uma pagina Web
		 */

		try {

			String textoSite = driver.findElement(elemento).getText();
			assertEquals(textoEsperado, textoSite);

		} catch (Exception e) {
			String textoSite = driver.findElement(elemento).getText();
			System.out.println("erro o texto esperado era: " + textoEsperado + ", no entento, o texto verificado foi: "
					+ textoSite + ".");
		}
	}

	public void apagarTexto(By elemento) {

		driver.findElement(elemento).clear();

	}
	

}
