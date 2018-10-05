package nl.prowareness.restapi.exceptions;

public class InvalidMethodTypeException extends Throwable {

	private static final long serialVersionUID = 1L;
	
    public InvalidMethodTypeException(final String message, final Throwable cause){
        super(message, cause);
    }

	public InvalidMethodTypeException(String message) {
        super(message);
	}
	

}
