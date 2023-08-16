package com.config;

public class Constants {
    //这里定义为public static的类型，方便其他任何类进行访问和调用
    public static final String URL="https://www.baidu.com";
    public static final String Path_TestData=".//src//test//java//com//dataEngine//dataEngine.xlsx";
    public static final String File_TestData="dataEngine.xlsx";

    //dataEngine.xlsx中一些单元格的索引值
    public static final int Col_TestCaseID=0;
    public static final int Col_TestScenarioID=1;
    public static final int Col_PageObject=3;
    public static final int Col_ActionKeyword=4;
    public static final int Col_RunMode = 2;

    //dataEngine.excel中sheet的名称
    public static final String Sheet_TestSteeps="TestSteps";
    public static final String Sheet_TestCase="TestCases";

    //测试登录用到的用户数据
    public static final String Username="xxxxxxx";
    public static final String Password="xxxxxxx";

    public static final String OR_Path = ".//src//test//java//com//config//OR.txt";
}
