package application;

public class Expense {
	private String expValue;
	
	public Expense(String expValue) {
		this.expValue = expValue;
	}
	
	public String getExpense() {
		return expValue;
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
				errorMessage = "Invalid input. Please use numbers ONLY.";
			}
			index++;
		}
		
		if (validValue) {
			expValue = valueAsString;
		}
		return errorMessage;
	}
	
	public boolean checkToAddExp(String exp) {
		if(exp == null) return false;
		
		for(int i = 0; i < exp.length(); i++) {
			if ((Character.isLetter(exp.charAt(i)) == true)) {
	            return false;
	         }
		}
		return true;
	}
}
