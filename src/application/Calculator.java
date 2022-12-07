package application;

public class Calculator {
	private double budgetValue;
	private double expenseValue;
	private double balValue;
	
	public Calculator(double bdg, double exp) {
		budgetValue = bdg;
		expenseValue = exp;
	}
	
	public Calculator(Calculator toCopy) {
		this.budgetValue = toCopy.budgetValue;
		this.expenseValue = toCopy.expenseValue;
	}
	
	public double getCurrentBalance() {
		balValue = budgetValue - expenseValue;
		return balValue;		
	}
	
	public double getExpense() {
		return expenseValue - budgetValue;
	}
	
	
	String setValue(String valueAsString) {
		String errorMessage = "";
		int index = 0;
		int decPoint = 0;
		boolean validValue = true;
		
		for (char c : valueAsString.toCharArray()) {
			if (c == '.' && decPoint == 0 && index != 0) {
				decPoint++;
			}
			else if (c == '.' && decPoint > 0) {
				validValue = false;
				errorMessage = "This is not a valid input, should be a value greater than 0";
			}
			else if (!Character.isDigit(c)) {
				validValue = false;
				errorMessage = "The input: " + c + " is invalid. Only use numbers.";
			}
			index++;
		}
		
		if (validValue) {
			budgetValue = Double.parseDouble(valueAsString);
		}
		if (budgetValue < 0) {
			errorMessage = String.format("Expense value should not be less than 0." + 
			"Invalid input: %.02f", expenseValue);
			budgetValue = 0;
		}
		return errorMessage;		
	}
}
