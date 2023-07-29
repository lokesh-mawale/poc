package enums;

public enum Test {
	
	VAL1("value 1"),
	VAL2("value 2"),
	VAL3("value 3");
	
	private String value;

	private Test(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	

}
