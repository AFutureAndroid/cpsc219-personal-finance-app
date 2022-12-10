package application;

/**
 * Creates expense with a field for value of the expense.
 * Includes input validation and getter/setter methods.
 *
 */
public class Expense {
	private String expValue;
	
	/**
	 * Constructs expense with string given.
	 *
	 * @param expValue Value of the expense.
	 */
	public Expense(String expValue) {
		this.expValue = expValue;
	}
	
	/**
	 * Getter for the expense value.
	 * 
	 * @return Value of the expense.
	 */
	public String getExpense() {
		return expValue;
	}
	
	/**
	 * The expense value is set to the input, only
	 * if the input is valid.
	 * 
	 * @param valueAsString New value the expense will be set to.
	 * @return Error message if given value not valid, empty string if input empty, else returns expense 
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
		
		if(valueAsString.isBlank() || valueAsString.isEmpty()) return "";
		
		if(validValue) {
			expValue = valueAsString;
		}
		return errorMessage;
	}
	
	/**
	 * If the string is valid returns True, or else False.
	 * @param exp The string being checked.
	 * @return True if input is valid, false otherwise.
	 */
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
