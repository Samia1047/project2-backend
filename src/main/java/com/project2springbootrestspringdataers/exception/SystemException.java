package com.project2springbootrestspringdataers.exception;

public class SystemException extends Exception{

	@Override
	public String getMessage() {
		return "System Error! Please try again later!!";
	}
	
}
