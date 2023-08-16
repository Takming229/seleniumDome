package com.executionEngine;

import com.config.ActionsKeywords;
import com.config.Constants;
import com.utility.ExcelUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.utility.Log;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverScript {
//声明一个public static的类对象，所以我们可以在main方法范围之外去使用
    public static ActionsKeywords actionsKeywords;
    public static String  sActionKeyword;
    //下面是返回类型是方法，这里用到反射类
    public static Method method[];

    //新建一个properties对象
    public static Properties OR;
    public static String sPageObject;


    public static int iTestStep;
    public static int iTestLastStep;
    public static String sTestCaseID;
    public static String sRunMode;
    public DriverScript() throws  NoSuchMethodException, SecurityException, ClassNotFoundException {
        //actionsKeywords = new ActionsKeywords();
        //method = actionsKeywords.getClass().getMethods();
        //采用上面的我们初始化'ActionsKeywords'类的一个对象也可以，下面的代码是查找反射资料，是这么获取class对象的
         Class<ActionsKeywords> actionsKeywords =ActionsKeywords.class;
        method = actionsKeywords.getMethods();
    }


   //public static void main(String[] args) throws ClassNotFoundException, IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        @Test
        public void login() throws ClassNotFoundException, NoSuchMethodException, IOException, InvocationTargetException, IllegalAccessException {
        //由于上面初始化反射类写在构造函数，而main方法是第一个最新，如果不添加
        //下面这个当前类的初始化代码，就会包method.length空指针异常，我这里暂时这里处理
       // String excel_path = "D:\\testDome\\seleniumDome\\src\\test\\java\\com\\dataEngine\\dataEngine.xlsx";

            DOMConfigurator.configure("log4j.xml");
            Log.startTestCase("Login_01");
            Log.info("加载和读取Excel数据文件");
        String excel_path = Constants.Path_TestData;
        ExcelUtils.setExcelFile(excel_path);
        //申明一个对象仓库文件字符串对象
        String Path_OR = Constants.OR_Path;
       //创建一个文件输入流对象
        FileInputStream fs = new FileInputStream(Path_OR);
        //创建一个Properties对象
        OR = new Properties(System.getProperties());
        //加载全部对象仓库文件
        OR.load(fs);

        DriverScript startEngine = new DriverScript();
        Log.info("开始执行测试用例");
        startEngine.execute_TestCase();
        Log.info("测试用例执行结束");

//        ExcelUtils.setExcelFile(excel_path,Constants.Sheet_TestSteeps);
//        for (int iRow = 1;iRow <= 6; iRow++){
//            //3表示Excel中keyword对应的列索引，也就是左边数起第四列
//            sActionKeyword = ExcelUtils.getCellData(iRow,Constants.Col_ActionKeyword);
//            //获取对应Excel页面对象的名称，返回是一个String对象
//            sPageObject = ExcelUtils.getCellData(iRow,Constants.Col_PageObject);
//            execute_Actions();
//        }
    }
    private void execute_TestCase() throws InvocationTargetException, IllegalAccessException {
        //获取测试用例数量
        int iTotalTestCase = ExcelUtils.getRowCount(Constants.Sheet_TestCase);
        //外层for循环，有多少个测试用例就执行多少次循环
        for (int iTestcase = 1; iTestcase <=iTotalTestCase ; iTestcase++) {
            //从test case 表获取测试ID
            sTestCaseID = ExcelUtils.getCellData(iTestcase,Constants.Col_TestCaseID,Constants.Sheet_TestSteeps);

            //获取当前测试用例的Run mode的值
            sRunMode = ExcelUtils.getCellData(iTestcase,Constants.Col_RunMode,Constants.Sheet_TestCase);

            //RunMode的值控制用例是否被执行
            if (sRunMode.equals("Yes")){
                //只有当前Run mode的单元格数据是yes，下面代码才会被执行
                iTestStep = ExcelUtils.getRowContains(sTestCaseID,Constants.Col_TestCaseID,Constants.Sheet_TestSteeps);
                iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteeps, sTestCaseID, iTestStep);

                //下面这个for循环次数就等于测试用例的步骤数
                for (;iTestStep<=iTestLastStep;iTestStep++){
                    sActionKeyword = ExcelUtils.getCellData(iTestStep,Constants.Col_ActionKeyword,Constants.Sheet_TestSteeps);
                    sPageObject = ExcelUtils.getCellData(iTestStep,Constants.Col_PageObject,Constants.Sheet_TestSteeps);
                    execute_Actions();
                }
            }
        }
    }

    private static void execute_Actions() throws InvocationTargetException, IllegalAccessException {
        //遍历每一个关键字驱动方法（在actionKeyword.java中）
        //下面method.length表示方法个数，method变量表示任何一个关键字方法
        for (int i = 0; i < method.length; i++) {
            //开始对比代码中的关键字方法名称和Excel中关键字这列值是否匹配
            if (method[i].getName().equals(sActionKeyword)){
                //一但匹配到相关关键字方法，就会调用对应的关键字静态方法
                method[i].invoke(actionsKeywords,sPageObject);
                //一但任何关键字被执行，利用break语句去跳出for循环
                break;
            }
        }
    }





//    public void login() throws IOException, InterruptedException {
//        String excel_path = "D:\\testDome\\seleniumDome\\src\\test\\java\\com\\dataEngine\\dataEngine.xlsx";
//        //加载读取Excel文件
//        ExcelUtils.setExcelFile(excel_path,"TestSteps");
//
//        for (int iRow=1;iRow<=9;iRow++){
//            String sActionKeyword = ExcelUtils.getCellData(iRow,3);
//            //和Excel文件中关键字进行对比
//            if (sActionKeyword.equals("openBrowser")){
//                //如果excel文件中存在openBrowser的关键字就会调用openBrowser()方法，进行相关操作；下面其他关键字同理
//                ActionsKeywords.openBrowser();
//            }else if (sActionKeyword.equals("openURL")){
//                ActionsKeywords.openUrl();
//            }else if (sActionKeyword.equals("click_Login_link")){
//                ActionsKeywords.click_Login_link();
//            }else if (sActionKeyword.equals("input_Username")){
//                ActionsKeywords.input_Username();
//            } else if (sActionKeyword.equals("input_Password")) {
//                ActionsKeywords.input_Password();
//            } else if (sActionKeyword.equals("click_Submit")) {
//                ActionsKeywords.click_Submit();
//            }else  if (sActionKeyword.equals("closeBrowser")){
//                Thread.sleep(1000);
//                ActionsKeywords.closeBrowser();
//            }
//        }
//    }

}
