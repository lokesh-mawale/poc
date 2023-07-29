import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {
	 int number = 12;
	 
	 boolean isPrime = IntStream.range(2, number).noneMatch(n->number%n==0);
	 
	 System.out.println("Is Number "+number +" is Prime? "+isPrime);
	 

	}

}
