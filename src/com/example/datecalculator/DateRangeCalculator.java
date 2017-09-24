package com.example.datecalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DateRangeCalculator {

	public static void main(String[] args) throws DateRangeCalculatorException {
		
		String[] inputArgs = promptInput(); //Accepts User input
		
		String inputStartDate = inputArgs[0];
		String inputEndDate = inputArgs[1];

		Calendar startDate = new GregorianCalendar();
		Calendar endDate = new GregorianCalendar();

		List<String> evenMonthList = new ArrayList<String>();
		evenMonthList.add("JANUARY");
		evenMonthList.add("MARCH");
		evenMonthList.add("MAY");
		evenMonthList.add("JULY");
		evenMonthList.add("AUGUST");
		evenMonthList.add("OCTOBER");
		evenMonthList.add("DECEMBER");
		
		try{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		Date date = dateFormat.parse(inputStartDate);
		startDate.setTime(date);
		date = dateFormat.parse(inputEndDate);
		endDate.setTime(date);
		
		//Compare Dates
		if ((endDate.compareTo(startDate) < 0)) {
			throw new DateRangeCalculatorException("Input Start Date Value Should be Less than End Date Value. Please re-run and try again.");
		}

		//Get date between given interval
		System.out.println("No of Days between the given dates= " + daysBetween(startDate.getTime(), endDate.getTime()));
		
		//Get Months between given interval
		getMonths(startDate, endDate, evenMonthList);
		
		}catch(ParseException parseException){
			throw new DateRangeCalculatorException("Input Date values are not in the proper format. Enter values in YYYY-MM-DD Format. Please re-run and try again.");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @param d1
	 * @param d2
	 * @return
	 * 
	 * Get Number of Days Between 2 Given dates
	 */
	public static int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param evenMonthList
	 * @return
	 * 
	 * Get Number Of Months between 2 Dates
	 */
	public static float getMonths(Calendar startDate, Calendar endDate, List<String> evenMonthList) {
		int yearDiff = endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR);
		int monthsBetween = endDate.get(Calendar.MONTH) - startDate.get(Calendar.MONTH) + 12 * yearDiff;
		monthsBetween = monthsBetween - 1;
		int date2 = endDate.get(Calendar.DAY_OF_MONTH);
		int date1 = startDate.get(Calendar.DAY_OF_MONTH);

		float datediff = 0;
		if (date1 > date2) {
			String month = Month.of(endDate.get(Calendar.MONTH)).name();
			if (evenMonthList.contains(month)) {
				datediff = (float) ((31 - date1) + date2) / 31;
			} else {
				datediff = (float) ((30 - date1) + date2) / 30;
			}
		} else {
			String month = Month.of(endDate.get(Calendar.MONTH) + 1).name();
			if (evenMonthList.contains(month)) {
				datediff = (float) (date2 - date1) / 31;
			} else {
				datediff = (float) (date2 - date1) / 30;
			}
		}
		float MonthDifference = monthsBetween > 1 ? monthsBetween + datediff : datediff;

		System.out.println("Approximate Number Of Months Between Given dates : " + MonthDifference);
		return MonthDifference;

	}

	/**
	 * Accepts user input
	 * @return
	 */
	public static String[] promptInput() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter Start Date (YYYY-MM-DD) : ");
		String inputStartDate = inputScanner.next();
		System.out.println("Enter End Date (YYYY-MM-DD) : ");
		String inputEndDate = inputScanner.next();
		String[] inputParams = {inputStartDate, inputEndDate};
		return inputParams;
	}

}
