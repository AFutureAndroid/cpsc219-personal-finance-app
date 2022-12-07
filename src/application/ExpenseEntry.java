package application;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ExpenseEntry {
	private String expType;
	private String expNote;
	private String expAmount;
	
	public ExpenseEntry(String expType, String expNote, String expAmount) {
		expType = this.expType;
		expNote = this.expNote;
		expAmount = this.expAmount;
		//System.out.println("Entry: " + this.expType + "\t" + this.expNote + "\t" + this.expAmount + "-------");
	}	
	
	public String getEntry() {
		String entry = expType + "       " + expNote + "       " + expAmount;
		return entry;
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
	
	

//	private ChoiceBox<String> expType;
//	private TextField expNote;
//	private TextField expAmount;
//
//
//	public ExpenseEntry(ChoiceBox<String> type, TextField note, TextField amount) {
//		expType = type;
//		expNote = note;
//		expAmount = amount;
//	}
//	
//	public ChoiceBox<String> getExpType() {
//		return expType;
//	}
//
//	public void setExpType(ChoiceBox<String> expType) {
//		this.expType = expType;
//	}
//	
//
//
//	public TextField getExpNote() {
//		return expNote;
//	}
//
//	public void setExpNote(TextField expNote) {
//		this.expNote = expNote;
//	}
//
//	public TextField getExpAmount() {
//		return expAmount;
//	}
//
//	public void setExpAmount(TextField expAmount) {
//		this.expAmount = expAmount;
//	}
}
