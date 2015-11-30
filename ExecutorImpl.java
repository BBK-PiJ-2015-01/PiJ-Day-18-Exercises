import java.util.concurrent.*;
import java.util.*;

public class ExecutorImpl implements Executor {
	
	public final int MAX_SLEEP_TIME = 1000;
		
	private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

	public void execute(Runnable command) {
		
		if (command != null) {
			
			try {
				queue.put(command);		
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Runnable element = queue.poll();
		while(element != null) {
			
			new Thread(command).start();
			element = queue.poll();
		}
	}
	
	public int getMaxPendingTime() {
		
//		return queue.size();		
		return MAX_SLEEP_TIME * queue.size();		
	}
}