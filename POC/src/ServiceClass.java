import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceClass {
	
	public static List<Customer> getCustomers(){
		
		return Stream.of(
				new Customer(1,"Lokesh","lokesh@test.com",Arrays.asList("1","2") ),
				new Customer(2,"Shweta","Shweta@test.com",Arrays.asList("3","4") ),
				new Customer(1,"Vivaan","Vivaan@test.com",Arrays.asList("5","6"))
				).collect(Collectors.toList());
		
	}

}
