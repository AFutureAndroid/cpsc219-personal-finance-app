package application;

import java.util.Comparator;

/**
 * Compares two expense entries based on their dates.
 * Can be used to sort entries by date.
 */
public class SortByTime implements Comparator <ExpenseEntry> {
	
	@Override
	public int compare(ExpenseEntry e1, ExpenseEntry e2) {
		if(e1 == null || e2 == null) return 0;
		if(e1.getExpDate().getYear() == e2.getExpDate().getYear()) {
			if(e1.getExpDate().getMonthValue() == e2.getExpDate().getMonthValue()) {
				if(e1.getExpDate().getDayOfMonth() == e2.getExpDate().getDayOfMonth()) return 0;
				else if (e1.getExpDate().getDayOfMonth() > e2.getExpDate().getDayOfMonth()) return 1;
				else return -1;
			}
			else if(e1.getExpDate().getMonthValue() > e2.getExpDate().getMonthValue()) return 1;
			else return -1;
		}
		else if(e1.getExpDate().getYear() > e2.getExpDate().getYear()) return 1;
		else return -1;
	}
		
		

	

}