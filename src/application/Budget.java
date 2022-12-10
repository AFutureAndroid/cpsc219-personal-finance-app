package application;

/**
 * Defines the budget value as a string.
 * Includes getter and setter methods for the value.
 */
public class Budget {
	private String budgetValue;
	
	/**
	 * Constructs a budget with value given.
	 * 
	 * @param budgetValue Initial value for the budget.
	 */
	public Budget(String budgetValue) {
		this.budgetValue = budgetValue;
	}
	
	/**
	 * Gets current value for budget.
	 * 
	 * @return Value of the budget.
	 */
	public String getBudget() {
		return budgetValue;
	}
	
	/**
	 * Value of budget is set to given string, assuming the value is valid.
	 * 
	 * @param valueAsString New budget value given as string.
	 * @return If not valid: return error message, if valid: empty string.
	 */
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
				errorMessage = "Invalid input. Please ensure the input is in this format: x.xx";
			}
			else if (!Character.isDigit(c)) {
				validValue = false;
				errorMessage = "Invalid input. Please use numbers ONLY.";
			}
			index++;
		}
		
		if (validValue) {
			budgetValue = valueAsString;
		}
		return errorMessage;
	}
	
}
