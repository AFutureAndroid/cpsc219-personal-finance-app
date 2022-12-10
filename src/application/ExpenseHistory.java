package application;

import java.util.ArrayList;

/**
 * The expense history is created as a ArrayList of type ExpenseEntry.
 * Include method to add an entry to the expense history.
 */
public class ExpenseHistory {
	private ArrayList <ExpenseEntry> expTable;
	
	/**
	 * Constructor that creates an empty ArrayList for expense history.
	 */
	public ExpenseHistory() {
		expTable = new ArrayList<ExpenseEntry>();
		
	}
	/**
	 * An ExpenseEntry is added to the history.
	 * 
	 * @param entry The expense being added to the history.
	 */
	public void addEntry(ExpenseEntry entry) {
		expTable.add(entry);		
	}
	

}
