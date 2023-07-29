package concurrency.waitNotify;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread{
	
	private Queue<Integer> queue;
	
	private Integer size;
	
	public Producer(Queue<Integer> queue, int size) {
		this.queue = queue;
		this.size  = size;
	}

	public void run() {
		while (queue.size() != size) {
			synchronized (queue) {
				while(queue.size() == size) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int i = new Random().nextInt(); 
				System.out.println("Producing value : " + i);
				queue.add(i);
				queue.notifyAll();

			}

		}
		
		System.out.println("Produced 10 ");
	}
	
}
