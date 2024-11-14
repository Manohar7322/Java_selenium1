package com.Supertails;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.*;

public class ReadFile {
	static ExtentReports extent;
	public static Properties Properties() throws IOException {
		Properties prob=new Properties();
		InputStream input=new FileInputStream("C:\\JAVA_WS\\SuperTails\\src\\test\\java\\com\\Supertails\\Supertails.properties");
		prob.load(input);
		return prob;
	}
	
	public static ExtentTest Test(String testdata) {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("Supertails.html");
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest(testdata);
		return test;
	}
	public static void Flush() {
		extent.flush();
	}

}
