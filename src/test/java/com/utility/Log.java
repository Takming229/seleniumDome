package com.utility;

import com.config.ActionsKeywords;

import org.apache.log4j.Logger;

public class Log {
    //初始化log4j log
    private static Logger logger = Logger.getLogger(Log.class.getName());
    //运行测试用例之前的日志输出
    public static void startTestCase(String stestCaseName){
        logger.info("*******************************************");
        logger.info("$$$$$$$$$$        "+stestCaseName+"        $$$$$$$$$$$$$$$$");
        logger.info("*******************************************");
    }
    //用例执行结束后日志输出
    public static void endTestCase(String sTestCaseName){
        logger.info("XXXXXXXXXXX   "+sTestCaseName+"XXXXXXXXXXXXXXX");
        logger.info("X");
        logger.info("X");
    }

    //以下是不同日志级别的方法，方便需要的时候调用，一般info和error用得最多
    public static void info(String massage){
        logger.info(massage);
    }

    public static void warn(String message){
        logger.warn(message);
    }

    public static void error(String message){
        logger.error(message);
    }

    public static void fatal(String message){
        logger.fatal(message);
    }
    public static void debug(String message){
        logger.debug(message);
    }
}
