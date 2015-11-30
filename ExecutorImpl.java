import java.util.concurrent.*;

public class ExecutorImpl implements Executor {

	public void execute(Runnable command) {
	
		if (command != null) {
			new Thread(command).start();
		}
	}
}