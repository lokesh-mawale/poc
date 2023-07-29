package concurrency.waitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class MainClient {

	public static void main(String[] args) {
		
		String emailString = "lokesh.mawale.ext@holcim.com";
		String partOne = emailString.split("@")[0];
		
		String emailOne = partOne+"@lafargeholcim.com";
		
		String emailTwo = partOne+"@lafarge.com";

		 Queue<Integer> queue = new LinkedList<>();
		 
		 Producer producer = new Producer(queue, 10);
		 
		 Consumer consumer = new Consumer(queue, 10);
		 
		 producer.start();
		 consumer.start();
	}

}
