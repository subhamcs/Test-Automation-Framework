package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
public class MyRetryAnalyzer implements IRetryAnalyzer{

	//interfaces are also the parents entity to the class what needs to be done is taken care here 
	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	//private static final int MAX_NUMBER_OF_ATTEMPTS  = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currentAttempt =1;
	
	@Override
	public boolean retry(ITestResult result) { //(ITestResult stores the information about the failed test)--> return in true or false to proceed further
		// TODO Auto-generated method stub
		
		if(currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}
	
	
	

}
