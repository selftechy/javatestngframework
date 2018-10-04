package com.automation.tngtests.exceptions;


public class WebshopDataFailureException extends Exception{
	  private static final long serialVersionUID = 0x1L;
	   
	    public WebshopDataFailureException(final String message, final Throwable cause){
	        super(message, cause);
	    }
	    
	    public WebshopDataFailureException(final String message){
	        super(message);
	    }
	    
}
