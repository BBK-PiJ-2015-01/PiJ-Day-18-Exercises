import java.util.concurrent.*;

public class RUIApplication {
	
	private final ExecutorImpl e = new ExecutorImpl();
		
	public int getMaxWait() {
		
		return e.getMaxPendingTime();
	}
	
	public void execute(Runnable r) {
		e.execute(r);
	}
}