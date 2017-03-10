import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi
 *
 */
public class DonationManagerTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.ManagerLoadcontainer(new DonationPackage("Pens",12));
			manager.ManagerLoadcontainer(new DonationPackage("Books",12));
			manager.ManagerLoadcontainer(new DonationPackage("NoteBooks",11));
			manager.ManagerLoadcontainer(new DonationPackage("chairs",20));
			manager.ManagerLoadcontainer(new DonationPackage("laptop",14));
			 
			 
		} catch (ContainerException e) {
			fail("Should not throw exception ");
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.ManagerQueueVolunteer(new  Volunteer("John"));
			manager.ManagerQueueVolunteer(new  Volunteer("Adam"));
			manager.ManagerQueueVolunteer(new  Volunteer("Nichole"));
			manager.ManagerQueueVolunteer(new  Volunteer("Allan"));
			manager.ManagerQueueVolunteer(new  Volunteer("Mary"));
			manager.ManagerQueueVolunteer(new  Volunteer("David"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e);
		}
	 
	}

	/**
	 * Test method for  ManagerQueueRecipient, should be implemented by STUDENTS
	 */
	@Test
	public void testManagerQueueRecipientSTUDENT() {
		 
	}

 
	@Test
	public void testDonatePackage() {
	    Volunteer v1;
	    Recipient r1;
	    DonationPackage d1,d2;
	    
	    v1 = new Volunteer("Monica"); 
		r1 =  new Recipient("MC College");
		
		d1 =  new DonationPackage("Pens",10);
		d2 =  new DonationPackage("Books",20);
		
		try {
			manager.ManagerLoadcontainer(d1);
			manager.ManagerLoadcontainer(d2);
			assertEquals(manager.donatePackage(),1 );  //There are no volunteers in the queue
			
			manager.ManagerQueueVolunteer(v1); //add a volunteer
			
			assertEquals(manager.donatePackage(),2 );  // There are no recipients in the queue
			
			manager.ManagerQueueRecipient(r1);   //Add a recipient
			assertEquals(manager.donatePackage(),0);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			manager.ManagerQueueRecipient(new Recipient("Justin"));
			assertEquals(manager.donatePackage(),0); //There is no recipient in the queue
			assertFalse(manager.vLine.volunteerLineEmpty());
			assertTrue(manager.container.isEmpty());
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

}
