import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClassClinet {

	public static void main(String[] args) {
		List<Customer> customers  = ServiceClass.getCustomers();
		
		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		
		List<String> emailsOtherWay = customers.stream().map(Customer::getEmail).collect(Collectors.toList());
		
		System.out.println(emailsOtherWay);
		
		 List<String> phonesFlattened = customers.stream().flatMap(customer -> customer.getPhones().stream()).collect(Collectors.toList());
		 System.out.println(phonesFlattened);
		
		Map<String , List<Customer>> map = customers.stream().collect(Collectors.groupingBy(Customer::getName));
		 //customers.stream().collect(Collectors.groupingBy(Customer::getName),Collectors.joining())
		System.out.println(map);
		
		List<Integer> intList =  Arrays.asList(1,2,3);
		
		//way one
		intList.stream().mapToInt(Integer::intValue).sum();
		
		//way two
		intList.stream().mapToInt(i->i).sum();
		
		
			
				
	}

}
