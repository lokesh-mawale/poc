package util;

enum Level {
	LOW(0),
	MEDIUM(1),
	HIGH(2);
	
	 private final int value;

	Level(int i) {
		this.value = i;
	}
	
	 public int getValue() { return value; }
}

public class Test { 
	public static void main(String[] args) { 
			System.out.println(Level.LOW.getValue());
			
			
	} 
}

