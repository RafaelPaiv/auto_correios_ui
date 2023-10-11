package br.com.correios.navegadores;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.correios.drivers.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navegadores extends Drivers {

	public static void abrirNavegador(String site) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(site);

	}
	
	public static void fecharNavegador() {
		
		driver.quit();
		
	}

}
