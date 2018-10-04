package com.automation.uidriver.utilities;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;


public class Utils {

	private static final Logger LOGGER = Logger.getLogger(Utils.class);
	
	public static void waitForGivenTime(int i) {

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			LOGGER.error("InterruptedException: ", e);
		}
	}
	
	
	public static boolean checkAllFieldsInGivenObjectAreNull(Object givenObject){
		boolean isNull = true;

		for (Field field : givenObject.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value=null;
			try {
				value = field.get(givenObject);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				LOGGER.error("Workbook could not be closed: "+e);
			} 
			if (value != null) {
				isNull=false;
			}
		}	
		return isNull;
	}
	
	
	

}
