import java.util.concurrent.*;
import java.util.*;

public class ExecutorImpl implements Executor {
	
	public final int MAX_SLEEP_TIME = 1000;
		
	private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

	public synchronized void execute(Runnable command) {
		
		if (command != null) {
			
			try {
				queue.put(command);		
//				System.out.println("Queue size is " + queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Runnable element = queue.poll();
//		System.out.println("Element to run is " + element);
		while(element != null) {
			
			new Thread(command).start();
//			System.out.println("Get next element to run. Size is " + queue.size());
			element = queue.poll();
//			System.out.println("Done ");
		}
	}
	
	public int getMaxPendingTime() {
		
		return MAX_SLEEP_TIME * queue.size();		
	}
}