package com.automation.tngtests.exceptions;


public class WebshopFeatureFileException extends Exception{
	  private static final long serialVersionUID = 0x1L;
	   
	    public WebshopFeatureFileException(final String message, final Throwable cause){
	        super(message, cause);
	    }
	    
	    public WebshopFeatureFileException(final String message){
	        super(message);
	    }
	    
}
