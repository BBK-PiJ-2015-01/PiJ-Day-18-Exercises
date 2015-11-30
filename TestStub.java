import org.junit.*;
import static org.junit.Assert.*;

//
//	Don't forget org.junit.runner.JUnitCore !
//
public class TestStub {

	private RUIApplication instance;
	
	@Before
	public void init() {
		
		instance = new RUIApplication();
	}
	
	//@Test
	public void singleUser() {
		
		System.out.println("Run single user application");
		RUIUser user = new RUIUser();
		user.startUser(instance);
	}
	
	@Test
	public void twoUsers() {
		
		System.out.println("Run two user application");
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Start up a new user");
				RUIUser user = new RUIUser();
				user.startUser(instance);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Start up a new user");
				RUIUser user = new RUIUser();
				user.startUser(instance);
			}
		}).start();
		
		try { 
			Thread.sleep(10000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Completed two user application test");
		}
	}
}