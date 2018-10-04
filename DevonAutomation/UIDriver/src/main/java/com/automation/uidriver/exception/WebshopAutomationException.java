package com.automation.uidriver.exception;

public class WebshopAutomationException extends Exception{

	  private static final long serialVersionUID = 0x1L;

	    public WebshopAutomationException(final Throwable cause){
	        super(cause);
	    }

	    public WebshopAutomationException(final String message, final Throwable cause){
	        super(message, cause);
	    }

	    public WebshopAutomationException(final String message){
	        super(message);
	    }


}
