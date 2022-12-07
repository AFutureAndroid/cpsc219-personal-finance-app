package application;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ExpenseEntry {
	private ChoiceBox<String> expType;
	private TextField expNote;
	private TextField expAmount;

	public ExpenseEntry(ChoiceBox<String> type, TextField note, TextField amount) {
		expType = type;
		expNote = note;
		expAmount = amount;
	}

	
	
	
	public ChoiceBox<String> getExpType() {
		return expType;
	}

	public void setExpType(ChoiceBox<String> expType) {
		this.expType = expType;
	}

	public TextField getExpNote() {
		return expNote;
	}

	public void setExpNote(TextField expNote) {
		this.expNote = expNote;
	}

	public TextField getExpAmount() {
		return expAmount;
	}

	public void setExpAmount(TextField expAmount) {
		this.expAmount = expAmount;
	}

	
}
