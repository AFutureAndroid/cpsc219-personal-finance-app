package application;

public class ExpenseEntry {
	private String expType;
	private String expNote;
	private String expAmount;

	public ExpenseEntry(String type, String note, String amount) {
		expType = type;
		expNote = note;
		expAmount = amount;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public String getExpNote() {
		return expNote;
	}

	public void setExpNote(String expNote) {
		this.expNote = expNote;
	}

	public String getExpAmount() {
		return expAmount;
	}

	public void setExpAmount(String expAmount) {
		this.expAmount = expAmount;
	}

	
}
