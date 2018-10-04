package com.automation.uidriver.exception;


public class WebshopUIException extends Exception{
	  private static final long serialVersionUID = 0x1L;
	   
	    public WebshopUIException(final String message, final Throwable cause){
	        super(message, cause);
	    }
	    
	    public WebshopUIException(final String message){
	        super(message);
	    }
	    
}
