import java.util.concurrent.*;


public class TextLoop implements Runnable {
	
	public static final int COUNT = 10;
	private final String name;
//	final int cores = Runtime.getRuntime().availableProcessors();
//	private static final Executor executor = new ThreadPoolExecutor(4, cores, 10, TimeUnit.MILLISECONDS,  new  LinkedBlockingQueue<Runnable>() );

	
	public TextLoop(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i = 0; i < COUNT; i++) {
			System.out.println("Loop:" + name + ", iteration:" + i + ".");
		}
	}
	public static void main(String args[]) {
		
//		int cores = Runtime.getRuntime().availableProcessors();
//		Executor executor = new ThreadPoolExecutor(4, cores, 10, TimeUnit.MILLISECONDS,  new  LinkedBlockingQueue<Runnable>() );
		ExecutorService executor = Executors.newCachedThreadPool();
		if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			System.out.println("USAGE: java TextLoop <mode>");
			System.out.println("     mode 0: without threads");
			System.out.println("     mode 1: with threads");
		} else if (args[0].equals("0")) {
			for (int i = 0; i < 10; i++) {
				Runnable r = new TextLoop("Thread " + i);
				r.run();
			}
		} else {
			for (int i = 0; i < 10; i++) {
				Runnable r = new TextLoop("Thread " + i);
				Thread t = new Thread(r);
				System.out.println("Starting thread for " + i);
				executor.execute(t);
				System.out.println("Completed thread for " + i);
//				t.start();
			}
		}
		executor.shutdown();
	}
}