package com.studybro.model;

public interface SbConstant 
{
	
	interface ContentType 
	{
		String TEXT_HTML = "text/html";
		String TEXT_CSS = "text/css";
		String APPLICATION_JAVASCRIPT = "application/javascript";
		String TEXT_JAVASCRIPT = "text/javascript";
		String APPLICATION_JSON = "application/json";
	}
	
	interface EmailType
	{
		
		String CONFIRMATION_ACCOUNT="templates/confirmAccount.html";
		String CONFIRMATION_SUBJECT="Please Verify Your Email Address to Activate your account";
		
	}
	
	
}
