package application;

public class Budget {
	private String budgetValue;
	
	public Budget(String budgetValue) {
		this.budgetValue = budgetValue;
	}
	
	public String getBudget() {
		return budgetValue;
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
				errorMessage = "Invalid input. Please ensure the input is in this format: x.xx";
			}
			else if (!Character.isDigit(c)) {
				validValue = false;
				errorMessage = "Invalid input.Please use numbers ONLY.";
			}
			index++;
		}
		
		if (validValue) {
			budgetValue = valueAsString;
		}
		return errorMessage;
	}
	
}
