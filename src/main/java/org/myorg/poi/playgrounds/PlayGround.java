package org.myorg.poi.playgrounds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PlayGround {
	private static final String LINUX_FILE = "/Users/jlu/Desktop/workbook.xls";

	public static void CreateWorkbook() {
		try {
			Workbook wb = new HSSFWorkbook();
			Sheet sheet1 = wb.createSheet("name1");
			Sheet sheet2 = wb.createSheet("name2");

			Row row1 = sheet1.createRow(0);
			Cell cell = row1.createCell(0);
			cell.setCellValue("hello excel");
			FileOutputStream fileOut = new FileOutputStream("LINUX_FILE");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ReadCellContent() {
		InputStream inp;
		try {
			inp = new FileInputStream(LINUX_FILE);

			HSSFWorkbook wb;
			wb = new HSSFWorkbook(new POIFSFileSystem(inp));

			ExcelExtractor extractor = new ExcelExtractor(wb);

			extractor.setFormulasNotResults(true);
			extractor.setIncludeSheetNames(false);
			String text = extractor.getText();
			System.out.println(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PlayGround.ReadCellContent();
	}
}
