package com.example.datecalculator;

public class DateRangeCalculatorException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DateRangeCalculatorException(String message) {
		super(message);
	}

	public DateRangeCalculatorException(Throwable throwable) {
		super(throwable);
	}
}
