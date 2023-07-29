package methodref;

public class Test {
	
	public String test(String value) {
		
		return "Value test is "+value;
	}
	
	public String testOther(String value) {
		
		return "Value from testOther is "+value;
	}
	
	public static void main(String args[]) {
		
		Test testInstance = new Test();
		FunctInterface functInterfaca = testInstance::test;
		String val = functInterfaca.singleAbsMethod("Val Mod 1 ");
		System.out.println(val);
		FunctInterface functInterf = testInstance::testOther;
		String valNew = functInterf.singleAbsMethod("Val Mod 2");
		System.out.println(valNew);
		
		
		
		
	}

}
