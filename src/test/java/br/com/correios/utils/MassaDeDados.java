package br.com.correios.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.correios.metodos.Metodos;

public class MassaDeDados extends Metodos {

	// Caminho para planilha excel

	String caminhoPlanilhaExcel = "src/test/resources/testData/MassaDadosCorreios.xlsx";

	public String incerirCEP() {

		try {

			FileInputStream arquivo = new FileInputStream(new File(caminhoPlanilhaExcel));
			// Abre arquivo excel e cria uma instância de planilha
			Workbook planilha = new XSSFWorkbook(arquivo);

			// Seleciona a primeira aba da planilha
			org.apache.poi.ss.usermodel.Sheet abaPlanilha = planilha.getSheetAt(0);

			for (Row linha : abaPlanilha) {

				Cell celula = linha.getCell(0); // Obtém a primeira célula da linha

				// Verifica o tipo da célula
				switch (celula.getCellType()) {
				case STRING:
					// Se for uma célula de tipo texto, retorna o valor como CEP
					return celula.getStringCellValue();
				case NUMERIC:
					// Se for uma célula de tipo texto, retorna o valor como CEP
					return String.valueOf((int) celula.getNumericCellValue());

				}

			}

		} catch (Exception e) {
			System.err.println("erro ao ler planilhas");
		}

		return null; // retorna null se não encontrar um cep na planilha

	}

}
