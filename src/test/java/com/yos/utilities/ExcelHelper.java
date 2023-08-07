package com.yos.utilities;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelHelper {

    private Workbook workbook;
    private Sheet sheet;
    private final String filePath;

    public ExcelHelper(String filePath) {
        this.filePath = filePath;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fileInputStream);
            } else if (filePath.endsWith(".xls")) {
                workbook = new HSSFWorkbook(fileInputStream);
            } else {
                throw new IllegalArgumentException("Invalid file format. Supported formats are .xlsx and .xls");
            }
            sheet = workbook.getSheetAt(0); // Default to the first sheet
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSheet(int sheetIndex) {
        if (sheetIndex >= 0 && sheetIndex < workbook.getNumberOfSheets()) {
            sheet = workbook.getSheetAt(sheetIndex);
        } else {
            throw new IllegalArgumentException("Invalid sheet index: " + sheetIndex);
        }
    }

    public void setSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet \"" + sheetName + "\" not found in the workbook");
        }
    }

    public void writeData(String value, int rowNum,int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
    }

    public String readData(int rowNum,int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row != null) {
            Cell cell = row.getCell(colNum);
            if (cell != null) {
                return cell.toString();
            }
        }
        return "";
    }

    public Map<String, Integer> getColumnHeaders() {
        Map<String, Integer> headers = new HashMap<>();
        Row headerRow = sheet.getRow(0);
        if (headerRow != null) {
            for (Cell cell : headerRow) {
                headers.put(cell.toString(), cell.getColumnIndex());
            }
        }
        return headers;
    }
    public void clearData(int startRow, int endRow, int startColumn, int endColumn) {
        for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                for (int colNum = startColumn; colNum <= endColumn; colNum++) {
                    Cell cell = row.getCell(colNum);
                    if (cell != null) {
                        row.removeCell(cell);
                    }
                }
            }
        }
    }
    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
