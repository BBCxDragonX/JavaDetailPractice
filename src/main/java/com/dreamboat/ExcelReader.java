package com.dreamboat;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static void main(String[] args) {
        String excelFilePath = "D:\\CodeDump\\ExcelFiles\\samplecolumn.xlsx"; // Update with your actual file path
        String sheetName = "samplesheet"; // Update with your sheet name
        String tableName = sheetName; // Assuming sheet name is the same as the table name

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            StringBuilder queryBuilder = new StringBuilder("SELECT ");

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if(row.getRowNum()!=0) {
                Cell column1Cell = row.getCell(0);
                Cell column2Cell = row.getCell(1);

                String column1 = column1Cell.getStringCellValue();
                String column2 = column2Cell.getStringCellValue();

                queryBuilder.append(column1).append(" AS ").append(column2);

                if (rowIterator.hasNext() ) {

                    queryBuilder.append(", ");
                }

                }
            }

            queryBuilder.append(" FROM ").append(tableName);
            System.out.println("Generated SQL query:");
            System.out.println(queryBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
