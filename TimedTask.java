public class TimedTask implements Runnable{
	
	private final int MAX_SLEEP_TIME = 1000;
	protected final int sleepyTime;
	
	public TimedTask(int time) {
	
		sleepyTime = Math.max(time, MAX_SLEEP_TIME);
	}
	
	public void run() {
				
		try {
			Thread.sleep(sleepyTime);
		} catch (InterruptedException e) {
				e.printStackTrace();
		} 
	}
}