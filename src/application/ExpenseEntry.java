package application;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ExpenseEntry {
	private String expType;
	private String expNote;
	private String expAmount;
	
	public ExpenseEntry(String expType, String expNote, String expAmount) {
		this.expType = expType;
		this.expNote = expNote;
		this.expAmount = expAmount;
		//System.out.println("Entry: " + this.expType + "\t" + this.expNote + "\t" + this.expAmount + "-------");
	}	
	
	@Override
	public String toString() {
		String format = expType + "       " + expNote + "       " + "$" + expAmount;
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
}
