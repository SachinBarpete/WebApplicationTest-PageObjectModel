package com.bridgelabz.qa.excelreport;

import org.automationtesting.excelreport.Xl;

/**
 * @author : Sachin Barpete
 * @purpose : for generating excel report of the test cases
 */
public class GenrateExcelReport {
	public static void main(String[] args) {
		try {
			Xl.generateReport("excel-report.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
