package application;

import java.time.LocalDate;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ExpenseEntry {
	private LocalDate expDate;
	private String expType;
	private String expNote;
	private String expAmount;
	
	public ExpenseEntry(LocalDate expDate, String expType, String expNote, String expAmount) {
		this.expDate = expDate;
		this.expType = expType;
		this.expNote = expNote;
		this.expAmount = expAmount;
	}

	public String getEntry() {
		String format = "Date:      " + expDate + "\n" +
						"Type:      " + expType + "\n" + 
						"Amount: " + "$" + expAmount + "\n" +
						"Note:      " + expNote ; 				
		return format;
	}
	
	public String dateToHistory() {	
		String format = " " + expDate.toString();
		return format;
	}
	
	public String typeToHistory() {
		String format = expType;
		return format;
	}
	
	public String amountToHistory() {
		String format = expAmount;
		return format;
	}
	
	public String noteToHistory() {
		String format = expNote;
		return format;
	}
	
	
	public String getExpType() {
		return expType;
	}
	
	public void setExpType(String expType) {
		this.expType = expType;
	}	
	
	public String getExpNote() {
		return expNote;
	}

	public void setExpNote(String expNote) {
		this.expNote = expNote;
	}

	public String getExpAmount() {
		return expAmount;
	}

	public void setExpAmount(String expAmount) {
		this.expAmount = expAmount;
	}
	
	public LocalDate getExpDate() {
		int year = expDate.getYear();
		int month = expDate.getMonthValue();
		int day = expDate.getDayOfMonth();
		LocalDate format = LocalDate.of(year, month, day);
		return format;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
}
