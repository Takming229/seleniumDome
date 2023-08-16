package com.utility;

import com.config.Constants;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    //设置Excel文件路径，方便读取到文件

    public static void setExcelFile(String Path) throws IOException {

        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        //ExcelWSheet = ExcelWBook.getSheet(SheetName);
    }
    //读取Excel文件单元格数据
    public static String getCellData(int RowNum, int ColNum, String SheetName){

        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        try{
            Cell =ExcelWSheet.getRow(RowNum).getCell(ColNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String CellData = Cell.getStringCellValue();
            return CellData;
        }catch (Exception e){
            return "";
        }
    }
    //得到一共多少行数据
    public static int getRowCount(String SheetName){
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        int number = ExcelWSheet.getLastRowNum()+1;

        return number;
    }
        //得到测试用例的行号
    public static int getRowContains(String sTestCaseName, int colNum, String SheetName){
        int i;
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        int rowCount = ExcelUtils.getRowCount(SheetName);
        for (i = 0; i< rowCount;i++) {
            if (ExcelUtils.getCellData(i,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
                break;
            }
        }
        return i;
    }

    //计算一个测试用例有多少个步骤
    public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestcaseStart){
        for (int i = iTestcaseStart; i < ExcelUtils.getRowCount(SheetName); i++) {
            if (!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID,SheetName))){
                int number = i;
                return number;
            }
        }
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        int number = ExcelWSheet.getLastRowNum()+1;
        return number;
    }
}
