package concurrency.waitNotify;

import java.util.Queue;

public class Consumer extends Thread{

	private Queue<Integer> queue;

	private Integer size;

	public Consumer(Queue<Integer> queue, Integer size) {
		this.queue = queue;
		this.size = size;
	}
	
	public void run() {
		
		while (queue.size() != size) {
			
			synchronized (queue) {
				
				while(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				int i= queue.poll();
				System.out.println("Consumed "+i);
				queue.notifyAll();
				
			}
			
		}
		System.out.println("Consumed 10");
	}
	
	

}
