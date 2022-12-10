package application;

import java.time.LocalDate;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *Defines an expense with fields date, type, note, and amount.
 *Generates strings for entry fields and includes getter and
 *setter methods.
 */
public class ExpenseEntry {
	private LocalDate expDate;
	private String expType;
	private String expNote;
	private String expAmount;
	
	/**
	 * Constructs Expense entry with date, type, note, and amount.
	 * 
	 * @param expDate Date of the expense.
	 * @param expType Type of the expense.
	 * @param expNote Any notes for the expense.
	 * @param expAmount Money amount for expense.
	 */
	public ExpenseEntry(LocalDate expDate, String expType, String expNote, String expAmount) {
		this.expDate = expDate;
		this.expType = expType;
		this.expNote = expNote;
		this.expAmount = expAmount;
	}
	
	/**
	 * Getter for string representation of the expense.
	 * Includes all fields in the entry.
	 * 
	 * @return A string representation of the expense.
	 */
	public String getEntry() {
		String format = "Date:      " + expDate + "\n" +
						"Type:      " + expType + "\n" + 
						"Amount: " + "$" + expAmount + "\n" +
						"Note:      " + expNote ; 				
		return format;
	}
	
	/**
	 * Returns a string representation of expiry date.
	 * 
	 * @return The expiration date of this object in the format "yyyy-MM-dd"
	 */
	public String dateToHistory() {	
		String format = " " + expDate.toString();
		return format;
	}
	
	/**
	 * Returns the expense type as a string.
	 * 
	 * @return Type of the expense as a string.
	 */
	public String typeToHistory() {
		String format = expType;
		return format;
	}
	
	/**
	 * The expense amount is converted to a string.
	 * 
	 * @return The expense as a string.
	 */
	public String amountToHistory() {
		String format = expAmount;
		return format;
	}
	
	/**
	 * Changes the note in the entry to a string.
	 * 
	 * @return The note as a string.
	 */
	public String noteToHistory() {
		String format = expNote;
		return format;
	}
	
	/**
	 *  Converts the expense type to a string.
	 *  
	 * @return The expense type as a string.
	 */
	public String getExpType() {
		return expType;
	}
	
	/**
	 * Sets the type for the expense to given string.
	 * 
	 * @param expType The new type for this expense.
	 */
	public void setExpType(String expType) {
		this.expType = expType;
	}	
	
	/**
	 * Sets the note content for the expense to given string.
	 * 
	 * @param expNote Value the expense will be set to.
	 */
	public String getExpNote() {
		return expNote;
	}
	
	/**
	 * Sets the note for the expense to given string.
	 * @param expNote Note you want add to expense.
	 */
	public void setExpNote(String expNote) {
		this.expNote = expNote;
	}
	
	/**
	 * Sets the money value for the expense to given string.
	 * 
	 * @param expAmount Value the expense will be set to.
	 */
	public String getExpAmount() {
		return expAmount;
	}
	
	/**
	 * Sets the money value for the expense to given string.
	 * 
	 * @param expAmount Value the expense will be set to.
	 */
	public void setExpAmount(String expAmount) {
		this.expAmount = expAmount;
	}
	
	/**
	 * Gets the expiry date of type LocalDate.
	 * 
	 * @return Date of the expense in form:year, month, day.
	 */
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
