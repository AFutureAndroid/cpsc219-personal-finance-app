package application;

import java.util.Comparator;

public class SortByTime implements Comparator <ExpenseDate> {
	
	
	@Override
	public int compare(ExpenseDate d1, ExpenseDate d2) {
		if(d1 == null || d2 == null) return 0;
		if(d1.getYear() == d2.getYear()) {
			if(d1.getMonth() == d2.getMonth()) {
				if(d1.getDay() == d2.getDay()) return 0;
				else if(d1.getDay() > d2.getDay()) return 1;
				else return -1;
			}
			else if(d1.getMonth() > d2.getMonth()) return 1;
			else return -1;
		}
		else if(d1.getYear() > d2.getYear()) return 1;
		else return -1;
	}
	

}
