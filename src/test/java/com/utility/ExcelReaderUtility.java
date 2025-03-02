package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String fileName) {
		// XLSX file
		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//LoginData.xlsx");
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = null;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Iterator<Row> rowIterator;
		XSSFSheet xssfSheet;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();

			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();

			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);

				User user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();

			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
