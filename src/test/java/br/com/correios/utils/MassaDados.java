package br.com.correios.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.correios.PageObjects.HomePage;
import br.com.correios.PageObjects.NovaBuscaPage;
import br.com.correios.drivers.Drivers;
import br.com.correios.metodos.Metodos;

public class MassaDados extends Drivers {

	Metodos metodo = new Metodos();
	HomePage home = new HomePage();
	NovaBuscaPage nBusca = new NovaBuscaPage();
	String caminhoMassaDadosCorreios = "src/test/resources/testData/MassaDadosCorreios.xlsx";

	MassaDeDados mas = new MassaDeDados();

	public String buscarDadosExcel() throws IOException {

		try {

			FileInputStream inputStream = new FileInputStream(caminhoMassaDadosCorreios);

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = workbook.getSheet("PlanilhaLista");

			int linhas = sheet.getLastRowNum();
			int colunas = sheet.getRow(0).getLastCellNum();

			System.out.println(linhas);

			for (int r = 0; r <= linhas; r++) {

				XSSFRow row = sheet.getRow(r);
				
				
				
				
				
				

				if (row != null) { // Verifica se a linha não é nula

					String celulaCPFPesquisar = row.getCell(0).getStringCellValue();
					String celulaLogradouro = row.getCell(1).getStringCellValue();
					String celulaBairro = row.getCell(2).getStringCellValue();
					String celulaUF = row.getCell(3).getStringCellValue();
					String celulaCPF = row.getCell(4).getStringCellValue();

					// home.validarLogradouro(celulaLogradouro);

					if (!celulaLogradouro.isEmpty()) {
						// Realize a ação desejada somente se celulaLogradouro não estiver vazia.
						String janelaPrincipal = driver.getWindowHandle();
						Set<String> janelasAbertas = driver.getWindowHandles();

						for (String janela : janelasAbertas) {
							if (!janela.equals(janelaPrincipal)) {
								driver.switchTo().window(janela);
							}
						}

						metodo.validarTexto(home.getLogradouroNome(), celulaLogradouro);
						metodo.gerarEvidencia("CT01- " + driver.findElement(home.getCEP()).getText() + " validado");
						driver.close();

						if (r > 0) {

							driver.switchTo().window(janelaPrincipal);
							Thread.sleep(1000);
							metodo.apagarTexto(home.getBuscarCep());

							metodo.digitar(home.getBuscarCep(), celulaCPFPesquisar);
							metodo.submit(home.getBuscarCep());

							// home.validarCepEndereco(celulaLogradouro, celulaBairro, celulaUF, celulaCPF);

						}

					}
				}
				
				
				
				
				
				
				
				
				
				

				if (row != null) { // Verifica se a linha não é nula

					for (int c = 0; c <= colunas; c++) {

						XSSFCell cell = row.getCell(c);

						if (cell != null) { // Verifica se a célula não é nula

							switch (cell.getCellType()) {
							case STRING:
								System.out.println(cell.getStringCellValue());
								break;
							case NUMERIC:
								System.out.println(cell.getNumericCellValue());
								break;
							case BOOLEAN:
								System.out.println(cell.getBooleanCellValue());
								break;

							}
						}

					}

				}

			}

		} catch (Exception e) {
			System.out.println("erro ao ler a planilha: " + e.getMessage());
		}

		return null; // retorna null se não encontrar um cep na planilha

	}

}
