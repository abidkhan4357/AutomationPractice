package com.qa.ui.ExtentReportsListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReporterNG implements IReporter {
private ExtentReports extent; //we are making it private, because we do not want ot share our results wiht others//

//this method contains array concept, we have 3 argument, first is we are saying that entire xml suite is all the suites class we will run//
//next is the Isuite is the child suites like homePage suite// And String outputDirectory will tell us if it pass or fail// 
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
		String outputDirectory) {
	extent = new ExtentReports(outputDirectory + File.separator //calling the object I created, then I created a new object 
	          + "Extent.html", true); //and saying the outputDirectory, and the file seperator sperators nicely with \, and 
										//we are  saying our file name will be Extent.html and boolean true is  will generate 
										//it only when test will give result

	//map obtians a unique value, can not be duplicate, and it will map it to one location, the location is our extent report
	//map is an interface in java and understaing whihc passed,fail,and skipped and it maps it and are holding it in a string.
	// we are holding the result in results variables which will have our pass, fail, skip//
	for (ISuite suite : suites) //having two conditons here, with the colon allows  to put it in condtional statement so if 
								 //we want to run a suite or mutiple suite// 
	  
	{
		Map<String, ISuiteResult> result = suite.getResults();

		//context allowing our extent report to 
		for (ISuiteResult r : result.values()) {
			ITestContext context = r.getTestContext();

			buildTestNodes(context.getPassedTests(), LogStatus.PASS); //gets the result status//
			buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
			buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
		}
	}

	extent.flush(); // adding the result and attaching to html report.
	extent.close();  //so once adding the report to html .close closes the report
}

//using a private method with 3 parameters which has test results, test status, and  extendTest test is where we are holding the test
private void buildTestNodes(IResultMap tests, LogStatus status) {
	ExtentTest test;

	//. size will check if there is some test in string test if their is it will for to the loop//
	if (tests.size() > 0) {
		for (ITestResult result : tests.getAllResults()) {
			test = extent.startTest(result.getMethod().getMethodName()); 

			test.setStartedTime(getTime(result.getStartMillis()));  //this will get the local machine time start and finish//
			test.setEndedTime(getTime(result.getEndMillis()));         //it will show us how long it took for us to run and finish the test//

			for (String group : result.getMethod().getGroups())    //this will stamp the time from your local machine//
				test.assignCategory(group);							//and group it//

			if (result.getThrowable() != null) {         //if their is a error log it///
				test.log(status, result.getThrowable());
				
				//here I said create a String file and it points to my directory and said create a folder screenshot and appending it to fail method string and apppend the method and name and screen shot extention//
				String file = System.getProperty("user.dir")+"/Screenshots/"+"FailureMethod"+result.getMethod().getMethodName()+".png";
				
				test.log(status, test.addScreenCapture(file)); //this will actaully capture the screenshot when it fails//
				
			} else {
				test.log(status, "Test " + status.toString().toLowerCase()   
						+ "ed");
			}

			extent.endTest(test);
		}
	}
}

//Another method that return data //which is in java The class Date represents a specific instantin time, with millisecond precision//
private Date getTime(long millis) {       
	Calendar calendar = Calendar.getInstance(); //Gets a calendar using the default time zone and locale//
	calendar.setTimeInMillis(millis);           //Sets this Calendar's current time from the given long value//
	return calendar.getTime();          //since we use calender get instance this will return calendar and.gettime is getting the time. and .gettime returns Date object representing this Calendar's time value  // 
}
}
