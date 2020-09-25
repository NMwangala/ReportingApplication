package io.mwangala.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	public static Date parseDate(String date) {
	    try {
	    	System.out.println("" +DATE_FORMAT.parse(date));
	        return DATE_FORMAT.parse(date);
	    } catch (Exception e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	
	public static int StringToInt(String value) {
		return Integer.valueOf(value);
	}
	
	public static Double StringToDouble(String value) {
		return Double.valueOf(value);
	}
	public static String doubleToString(Double value) {
		if (value == null)
	        return null;
	    if (value.isNaN() || value.isInfinite())
	        return value.toString();

	    // Pre Java 8, a value of 0 would yield "0.0" below
	    if (value.doubleValue() == 0)
	        return "0";
	    return new BigDecimal(value.toString()).stripTrailingZeros().toPlainString();
		
	}
	
}
