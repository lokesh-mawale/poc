package casestudy;

public enum Category {
	
	FOOD(10),
	ELECTORNICS(10),
	TOYS(10);

	private int discount;

	private Category(int discount) {
		this.discount = discount;
	}

	public int getDiscount() {
		return discount;
	}
	
}
