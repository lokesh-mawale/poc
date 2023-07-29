package util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class heirarchy {

	public static void main(String[] args) {

		
	//	int[] array1 = {2,1,3,5,6};
		
		
		int[] array1 = {1, 49, 29, 95, 90, 10, 24, 84, 17, 19, 6}  ;        // count 11

		//int[] array2 = {1,-1,2};
		
		int[] array2 =    {-1, 17, 6, 49, 29, 1, 6, 29, 10, 6, 1} ;   
		
		Set<Integer> managerSet = new LinkedHashSet<Integer>();
		managerSet.add(-1);
		
		Set<Integer> tempSet = new LinkedHashSet<Integer>();
		
		boolean noMatch = true;
		
		while(noMatch) {
			for(Integer mgrInteger : managerSet) {
				for(int i=0; i <array1.length;i++) {
					if(array2[i] == mgrInteger) {
						System.out.print(array1[i]+" ");
						tempSet.add(array1[i]);
					}
				}
				System.out.print(":");
			}
			System.out.println();
			if(tempSet.isEmpty()) {
				noMatch = false;
			}else {
				managerSet = tempSet;
				tempSet =  new LinkedHashSet<>();
			}
		}
		
		
	}

}
