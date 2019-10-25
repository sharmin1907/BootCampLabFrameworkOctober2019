package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    HSSFWorkbook wb = null;
    HSSFSheet sheet = null;
    int numberOfRows, numberOfCol;

    public static void main(String[] args) throws IOException {
        ExcelReader excelReader = new ExcelReader();
        System.out.println("Multiple *******");
        String[] data = excelReader.getValueByColumn("/Users/peoplentech/Documents/WeekDays-February/WebAutomation/Generic/src/main/resources/Book.xls");
        for (int a = 1; a < data.length; a++) {
            System.out.println(data[a]);
        }
        System.out.println("Specific ********");
        String fileReader2 = excelReader.getValueOf("/Users/peoplentech/Documents/WeekDays-February/WebAutomation/Generic/src/main/resources/Book.xls", 0, 1);
        System.out.println(fileReader2);
    }

    public String[] getValueByColumn(String path) throws IOException {
        String[] data;
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1];
        for (int i = 1; i < data.length; i++) {
            HSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                HSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i] = cellData;
            }
        }
        return data;
    }

    public String getValueOf(String path, int Cell, int Row) throws IOException {
        String data = null;
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        HSSFRow rows = sheet.getRow(Row);
        HSSFCell cell = rows.getCell(Cell);
        String cellData = getCellValue(cell);
        data = cellData;

        return data;
    }

    public String getCellValue(HSSFCell cell) {
        Object value = null;
        int dataType = cell.getCellType();
        switch (dataType) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
        }
        return value.toString();
    }
}
