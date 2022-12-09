package application;

import java.util.ArrayList;

public class ExpenseHistory {
	private ArrayList <ExpenseEntry> expHistory;
	
	public ExpenseHistory() {
		expHistory = new ArrayList<ExpenseEntry>();		
	}

	public ArrayList <ExpenseEntry> getExpHistory() {
		return expHistory;
	}
	
//	public void addEntry(ExpenseEntry entry) {
//		expTable.add(entry);		
//	}
	

	
}