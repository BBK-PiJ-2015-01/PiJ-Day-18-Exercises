import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class RUIUser {
	
	private final ExecutorService executor = Executors.newCachedThreadPool();
	private final String EXCEEDS_MAX_WAIT_TIME_MSG = "The site is down, I will come back later...";
	
	public static final int TOLERANCE_MS = 5000;
	public static final int NUMBER_OF_REQUESTS = 10;
	private final int tolerance;
	//
	private static int userNum = 0;
	//
	private int userId;
	
	public RUIUser() {
		this(TOLERANCE_MS);
	}
	
	public RUIUser(int tolerance) {
		this.tolerance = tolerance;
		userId = ++userNum;
	}

	public void startUser(RUIApplication app) {
		

		Random r = new Random();
		
		for (int i = 0; i < NUMBER_OF_REQUESTS; i++ ) {			
			if (app.getMaxWait() > tolerance) {
				System.out.println(EXCEEDS_MAX_WAIT_TIME_MSG);
				try {
					Thread.sleep(TOLERANCE_MS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			} else {
				int waitTime = r.nextInt(TimedTask.MAX_SLEEP_TIME);
//				System.out.println("Schedule a task that takes " + waitTime + "  (ms)");
				app.execute(new TimedTask(userId, waitTime));
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("User " + userId + " has finished work");
	}
}