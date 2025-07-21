package Api2.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil1 {

    String path;

    public ExcelUtil1(String path)
    {
        this.path = path;

    }


    public int getrowcount(String sheetname) throws IOException {
        System.out.println("Reading Excel file from: " + path);
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowcount;


    }


    public int getcellcount(String sheetname, int rownum) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetname);
        Row row = sheet.getRow(rownum);
        int cellnum = row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellnum;

    }

    public String getcelldata(String sheetname, int rownum, int col) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetname);
        Row row = sheet.getRow(rownum);
        Cell cell = row.getCell(col);
        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";

        }
        workbook.close();
        fis.close();
        return  data;

    }



}
