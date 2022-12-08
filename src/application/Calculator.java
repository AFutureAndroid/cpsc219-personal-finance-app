package application;


public class Calculator {
    double budgetValue;
    double expenseValue;
    double balanceValue;
	
	Calculator(double exp, double bal){
		expenseValue = exp;
		balanceValue = bal;
	}
	
    
    public double updateBalance() {
    	balanceValue = budgetValue - expenseValue;
    	return expenseValue;
    }
    
	public double updateExpense() {
    	return expenseValue;
	}
    
	public String setValue(String valueAsString) {
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
		if (budgetValue < 0) {
			errorMessage = String.format("Expense value should not be less than 0." + 
			"Invalid input: %.02f", expenseValue);
			budgetValue = 0;
		}
		
		if (validValue) {
			budgetValue = Double.parseDouble(valueAsString);
		}
		return errorMessage;		
	}




}
