
public class Series {

	public static void main(String[] args) {
		
		System.out.println("series 1 12 123 1234 ...");
		int number = 5;
		
		for (int i=1;i<=number;i++) {
			
			for(int j=1;j<=i;j++) {
				
				System.out.print(j);
				
			}
			System.out.println();
		}
		
		System.out.println("........");
		System.out.println("series 1 4 9 16 25 36 ...");
		
		for(int i=1;i<=number;i++) {
			System.out.println(i*i);
			
		}

	}

}
