package com.newnius.util;

import android.util.Log;
import org.apache.log4j.Logger;
import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * log message and save them
 *
 * @author Newnius
 * @version 0.1.0(Android)
 *
 * Dependencies
 *   log4j-1.2.x.jar,
 *   android-logging-log4j-1.0.x.jar
 *
 * Notice:
 *   1. need permission in Android
 *   2. must call init(LogConfigurator logConfigurator) once before call getLogger()
 *      set in MainActivity.java configureLogger()
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 */
public class CRLogger {
    private static LogConfigurator logConfigurator;
    private final String TAG;
    private Logger log4jLogger = null;


    public static void init(LogConfigurator configurator){
        logConfigurator = configurator;
        logConfigurator.configure();
    }

    /*
    * @param tag
    *
    * */
    private CRLogger(String tag){
        if(logConfigurator==null){
            throw new ExceptionInInitializerError("You have to call init(LogConfigurator) first");
        }
        this.TAG = tag;
        this.log4jLogger = Logger.getLogger(tag);
    }


    public static CRLogger getLogger(Class clazz) {
        return new CRLogger(clazz.getName());
    }

    public static CRLogger getLogger(String tag) {
        return new CRLogger(tag);
    }

    public static void debug(String tag, String msg) {
        Log.d(tag, msg);
    }

    public void debug(String msg) {
        Log.d(TAG, msg);
    }

    public static void info(String tag, String msg) {
        getLogger(tag).info(msg);
    }

    public void info(String msg) {
        log4jLogger.info(msg);
    }

    public static void warn(String tag, String msg) {
        getLogger(tag).warn(msg);
    }

    public void warn(String msg) {
        log4jLogger.warn(msg);
    }

    public static void error(String tag, String msg) {
        getLogger(tag).error(msg);
    }

    public void error(String msg) {
        log4jLogger.error(msg);
    }

    public static void error(String tag, Exception ex) {
        getLogger(tag).error(ex);
    }

    public void error(Exception ex) {
        log4jLogger.error(ex.getMessage(), ex);
    }

}
