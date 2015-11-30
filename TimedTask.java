public class TimedTask implements Runnable{
	
	public static final int MAX_SLEEP_TIME = 1000;
	protected final int sleepyTime;
	private final int parentId;
	//

	
	public TimedTask(int time) {
		
		this( 0, time);
	}
	
	public TimedTask(int parentId, int time) {
	
		this.parentId = parentId;
		sleepyTime = Math.min(time, MAX_SLEEP_TIME);
	}
	
	public void run() {

		try {
//			System.out.println("Start task over " + sleepyTime + "(ms)");
			Thread.sleep(sleepyTime);
//			System.out.println("Sleepy time over " );
		} catch (InterruptedException e) {

				e.printStackTrace();
		} 
		System.out.println("Completed user: " + parentId +" task after " + sleepyTime + "(ms)");
	}
}