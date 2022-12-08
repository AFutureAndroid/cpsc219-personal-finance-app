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

	@Override
	public String toString() {
		String format = expDate + "       " + expType + "       " + expNote + "       " + "$" + expAmount;
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
	
	public String getExpDate() {
		return expAmount;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
}
