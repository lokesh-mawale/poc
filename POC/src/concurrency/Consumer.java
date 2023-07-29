package concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	
	private BlockingQueue<Message> queue;
	
	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Message message ;
		try {
			while((message = queue.take()).getMsg() != "exit") {
				//Thread.sleep(10);
				System.out.println("Consumed "+message.getMsg());
				System.out.println("-----");
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	

}
