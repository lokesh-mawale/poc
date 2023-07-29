package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(1);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
                
        Thread producerThread = new Thread(producer);
        
        producerThread.start();
        
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
      /*  
       try {
			producerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        
        try {
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
        
        
        CustomThread thread = new CustomThread();
        //thread.start();

	}

}
