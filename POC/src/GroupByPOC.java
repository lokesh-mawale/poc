import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByPOC {
	
	public static void main(String[] args) {
		
		GroupByPOC poc  = new GroupByPOC();
		poc.solution();
		List<Item>  items = getItems();
		int[] A = {1, 3, 6, 4, 1, 2};
		
		 Set<Integer> collect9 = Arrays.stream(A).distinct().sorted().boxed().collect(Collectors.toSet());
		List<Integer> intList = Arrays.asList(1,2,2,4,6,1,5);
		 Set<Integer> set = new HashSet();
		 System.out.println("---");
		 intList.stream().filter(n-> !set.add(n)).forEach(System.out::println);;
		 System.out.println("----");
		
		intList.stream().sorted((o1,o2)-> o2-o1).forEach(System.out::println);
		Integer reduce = intList.stream().reduce(0,(a,b)-> a+b);
		List<Integer> uniqueInts = intList.stream().distinct().collect(Collectors.toList());
		
		List<Integer> secondAndthirdHighest = uniqueInts
				.stream()
				.sorted((i1,i2)-> i2-i1 )
				.skip(1)
				.limit(2)
				.collect(Collectors.toList());
		
		
		
		
		Map<Integer, Long>  map1 = intList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("map 1"+map1);
		
		map1.forEach((key,value)->{
			if(value >1) {
				System.out.println("duplicate elements "+key);
			}
		});
		
		Map<String, List<Item>>  groupByPropToObject = items.stream()
				.collect(Collectors.groupingBy(Item::getName));

		//	System.out.println("Group By Property To Object :: " +groupByPropToObject);

		//System.out.println("===================================================");

		Map<String, Integer> result = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
		//System.out.println("Item names grouped by the quantity :: " +result);

		//System.out.println("===================================================");


		Map<BigDecimal, Set<String>> resultNew = items.stream()
				.collect(
						Collectors.groupingBy(
								Item::getPrice,
								TreeMap::new,
								Collectors.mapping(Item::getName, Collectors.toSet())
								)
						);

		//System.out.println("Item names grouped by their prices :: "+resultNew);


		//System.out.println("===================================================");

		List<Employee> employees =  getEmployees();
		
		   Map<Integer, List<Employee>> collect8 = employees.stream()
		.sorted((o1,o2) -> o1.getAge() -o2.getAge())
		.collect(Collectors.groupingBy(Employee::getAge,LinkedHashMap::new,Collectors.toList()));
		
		
		//sort by department and then group by department
		//**** Importan to note 
		LinkedHashMap<String, List<String>> collect7 = employees.stream()
		.sorted((o1,o2)->o1.getDepartment().compareTo(o2.getDepartment()))
		.collect(Collectors.groupingBy(Employee::getDepartment,LinkedHashMap::new, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		List<String> strList1 = new ArrayList<>();
		strList1.add("val1");
		strList1.add("val2");
		
		List<String> strList2 = new ArrayList<>();
		strList2.add("val3");
		strList2.add("val4");
		
		PojoObj obj1 = new PojoObj("field1", strList1);
		PojoObj obj2 = new PojoObj("field2", strList2);
		
		List<PojoObj> poJoObjList = new ArrayList<>();
		poJoObjList.add(obj2);
		poJoObjList.add(obj1);
		//***********************************Important
		//count sum of age of employee from department sorted by department name
		//sort by property
		//group by another property 
		//coutin
		LinkedHashMap<String, Double> collect4 = employees.stream()
		.sorted((o1,o2)-> o1.getDepartment().compareTo(o2.getDepartment()))
		.collect(Collectors.groupingBy(Employee::getDepartment,LinkedHashMap::new,Collectors.averagingDouble(Employee::getAge)));
		
		
		 Map<String, Integer> collect5 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getAge)));
		 
		Set<Entry<String, Integer>> collect6 = collect5.entrySet().stream()
		.sorted((o1,o2)-> o1.getKey().compareTo(o2.getKey()))
		.collect(Collectors.toSet());
		
		List<String> collect = poJoObjList.stream().
				map(obj->obj.getList()).
				flatMap(list->list.stream()).collect(Collectors.toList());
		List<List<String>> collect2 = poJoObjList.stream().map(obj->obj.getList()).collect(Collectors.toList());
		System.out.println( employees.stream().map(Employee::getName).collect(Collectors.toList()));

		//System.out.println( employees.stream().map(e ->e.getAge()*2).collect(Collectors.toList()));

		//System.out.println(employees.stream().filter(e->e.getAge() > 30).collect(Collectors.toList()));

		//System.out.println(employees.stream().filter(e->e.getAge() > 30).collect(Collectors.groupingBy(Employee::getAge,Collectors.mapping(Employee::getName, Collectors.toList()))));

		//System.out.println(employees.stream().map(Employee::getName));

		System.out.println("Priting Distinct Departments");
		employees.stream().map(Employee::getDepartment).distinct().forEach(s->System.out.println(s));
		System.out.println("===================================================");

		System.out.println("Count of Employee from each department");
		Map<String, Long> countByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		Map<String, List<String>> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
		Map<String, Long>  newDepts = employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
		
		
		
		
		System.out.println(countByDepartment);
		System.out.println("===================================================");

		System.out.println("Average age of Male and Female Employees");
		Map<String, Double> avgAgeByGender = employees.stream()
														.collect(Collectors.groupingBy(Employee::getGender,
																Collectors.averagingDouble(Employee::getAge)));
		System.out.println(avgAgeByGender);
		System.out.println("===================================================");

		//group by age mapped to the list
		Map<Integer, List<String>>  groupByAge = employees.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Group By Age "+groupByAge);
		System.out.println("===================================================");
		
		Map<Integer, List<Employee>>  groupByAgeDetails = employees.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.toList()));
		Map<Integer, List<Employee>>  groupByAgeDetails1 = employees.stream().collect(Collectors.groupingBy(e->e.getAge(),Collectors.toList()));
		System.out.println("Group By Age With Details "+groupByAgeDetails);
		System.out.println("===================================================");

		
		 Map<String, Integer> ageSumByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.summingInt(Employee::getAge)));
		 System.out.println("Age Sum By Gender "+ageSumByGender);
		 
		 
		 Map<String, Double> avgAge = employees.stream()
		 .collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingDouble(e->e.getAge())));
		 
		 System.out.println(avgAge);
	}

	/**
	 * @return 
	 * 
	 */
	private static List<Employee> getEmployees() {
		Employee e1 = new Employee("John", 38,"Male","HR");
		Employee e2 = new Employee("Tim", 33,"Male","HR");
		Employee e3 = new Employee("Anita", 33,"Female","HR");
		Employee e4 = new Employee("Peter", 38,"Male","HR");
		Employee e5 = new Employee("Nathan", 22,"Male","IT");
		Employee e6 = new Employee("Georgia", 23,"Female","IT");
		Employee e7 = new Employee("Lord", 23,"male","FIN");
		List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6,e7);
		return employees;
	}

	/**
	 * @return 
	 * 
	 */
	private static List<Item> getItems() {
		return Arrays.asList(
		        new Item("apple", 10, new BigDecimal("9.99")),
		        new Item("banana", 20, new BigDecimal("19.99")),
		        new Item("orange", 10, new BigDecimal("29.99")),
		        new Item("watermelon", 10, new BigDecimal("29.99")),
		        new Item("papaya", 20, new BigDecimal("9.99")),
		        new Item("apple", 10, new BigDecimal("9.99")),
		        new Item("banana", 10, new BigDecimal("19.99")),
		        new Item("apple", 20, new BigDecimal("9.99"))
		);
		
		
	}
	
	public int solution() {
		
		int[] A = {-1, -3,-1};
		
		Set<Integer> treeSet = new TreeSet<>();
		for(int i:A) {
			treeSet.add(i);
	}
         Set<Integer> sortedUniqueElements = Arrays.stream(A).
        distinct().
        boxed().sorted( (o1,o2)-> o2-o1).collect(Collectors.toSet());
         int nextElem = 0;
        for(Integer elem:treeSet){
            nextElem = elem+1;
            if(!sortedUniqueElements.contains(nextElem) && nextElem > 0){
               break;
            }else if(nextElem < 0){
            	nextElem = nextElem++;
            	
            }
        }
        return 1;

    }
}
