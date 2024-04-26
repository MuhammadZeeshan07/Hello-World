package org.youCater.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;


public class HTMLReport {
    static ExtentReports extent;
    static ExtentSparkReporter reporter;

    public static ExtentReports getReporterObject() {
        extent = new ExtentReports();
        String reportsPath = System.getProperty("user.dir") + "/reports/testCasesResult";
        reporter = new ExtentSparkReporter(reportsPath);
        reporter.config().setReportName("YouCater Test Report");
        reporter.config().setDocumentTitle("YouCater Test Report");
        extent.attachReporter(reporter);
        return extent;
    }

   
}
