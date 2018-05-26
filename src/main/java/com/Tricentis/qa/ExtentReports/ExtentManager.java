package com.Tricentis.qa.ExtentReports;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
public static ExtentReports getInstance(String Tc_Name) {
		
		Date date = new Date();		
		
		String originalDateFormat = date.toString();
		
		String modifiedDateFormat = originalDateFormat.replace(":","_").replace(" ","_");

		String FileName = Tc_Name+" "+modifiedDateFormat+".html";
		
		String FilePath = "reports//"+FileName;
		
		ExtentReports report = new ExtentReports(FilePath, true, DisplayOrder.NEWEST_FIRST);
		
		report.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));

		report.addSystemInfo("Selenium Version", "2.53.1").addSystemInfo(
				"Environment", "QA");
		
		return report;
		
	}
}
