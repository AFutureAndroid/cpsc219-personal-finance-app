package application;

import java.util.ArrayList;

public class ExpenseHistory {
	private ArrayList <ExpenseEntry> expTable;
	
	public ExpenseHistory() {
		expTable = new ArrayList<ExpenseEntry>();
		
	}
	
	public void addEntry(ExpenseEntry entry) {
		expTable.add(entry);
		
	}
	
	
}
