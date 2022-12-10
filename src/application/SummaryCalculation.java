package application;

import java.util.ArrayList;
import java.util.Collections;

public class SummaryCalculation {
	
	private ArrayList<ExpenseEntry> expHistory;
	private double expense;
	
	public SummaryCalculation(ArrayList<ExpenseEntry> expHistory) {
		this.expHistory = expHistory;
	}

	public double getAvgExpPerDay() {
		int n = expHistory.size();
		double sum = 0.0;
		double avgExp = 0.0;
		for(int i = 0; i < expHistory.size(); i++) {
			double exp = Double.parseDouble(expHistory.get(i).getExpAmount());
			sum = sum + exp;
		}
		avgExp = sum / n;
		return avgExp;
	}
	
	public double getMaxExp(){
		double maxExp = 0.0;
		ArrayList allAmounts = new ArrayList();
		for(int i = 0; i < expHistory.size(); i++) {
			double exp = Double.parseDouble(expHistory.get(i).getExpAmount());
			allAmounts.add(exp);
		}
		maxExp = (double) Collections.max(allAmounts);		
		return maxExp;
	}
	
	public double getMinExp(){
		double minExp = 0.0;
		ArrayList allAmounts = new ArrayList();
		for(int i = 0; i < expHistory.size(); i++) {
			double exp = Double.parseDouble(expHistory.get(i).getExpAmount());
			allAmounts.add(exp);
		}
		minExp = (double) Collections.min(allAmounts);		
		return minExp;
	}
	
	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public ArrayList<ExpenseEntry> getExpHistory() {
		return expHistory;
	}

	public void setExpHistory(ArrayList<ExpenseEntry> expHistory) {
		this.expHistory = expHistory;
	}
	
	
	
	
}
