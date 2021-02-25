package com.readexcel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {
    public static void main(String[] args) throws IOException {

        File inputFile=new File("./TestData/challenge.xlsx");

        FileInputStream excelFile=new FileInputStream(inputFile);

        XSSFWorkbook workbook=new XSSFWorkbook(excelFile);



    }
}
