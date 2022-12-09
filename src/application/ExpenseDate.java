package application;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class ExpenseDate {
	private LocalDate expDate;
	private int year;
	private int month;
	private int day;
	
//	public ExpenseDate(LocalDate expDate, int y, int m, int d) {
//		this.expDate = expDate;
//		this.year = y;
//		this.month = m;
//		this.day = d;
//	}
	
//	public ExpenseDate(int y, int m, int d) {
//		this.year = y;
//		this.month = m;
//		this.day = d;	}
	
	public LocalDate getExpDate() {
		return expDate;
	}
	
	public void setExpDate(LocalDate expDate) {
		this.expDate.of(expDate.getDayOfYear(), expDate.getMonthValue(), expDate.getDayOfMonth()); 
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return this.day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	public String dateToHistory() {
		String format = this.year + "-" + this.month + "-" + this.day;
		return format;
	}

//	public LocalDate getValue() {	
//		return expDate.getValue();
//	}

	
	

}
