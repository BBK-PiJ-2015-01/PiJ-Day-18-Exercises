import java.util.concurrent.*;

public class TestScript {

	public static void main(String[] args) {
	
		new TestScript().launch();
	}
	
	private void launch() {
	
		RUIApplication e = new RUIApplication();
		System.out.println("Run multiple user application");
		final int limit = 30;
		for(int i = 0; i < limit; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
	//				System.out.println("Start up a new user");
					RUIUser user = new RUIUser();
					user.startUser(e);
				}
			}).start();
		}
	
	}

}