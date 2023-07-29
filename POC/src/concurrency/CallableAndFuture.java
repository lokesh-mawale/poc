package concurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static void main(String[] args) {
		
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		List<Future> allFutures = new ArrayList<Future>();
		Future<Integer> future = service.submit(new Task());
		allFutures.add(future);
		
		for(Future fut : allFutures) {
			try {
				Integer val = (Integer) fut.get();
				System.out.println(val);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		
	}

}

class Task implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		return new Random().nextInt();
	}
	
}
