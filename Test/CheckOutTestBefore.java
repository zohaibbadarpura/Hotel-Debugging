package hotel;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;

public class CheckoutServiceCostTesting {
	static Booking bookingTest;
	static Guest guest;
	static Room room;
	static Date bookedArrival; 
	static int stayLength;
	static int numberOfOccupants;
	static long confirmationNumber;
	static CreditCard testCreditCard;
	static CreditCardType type;
	static int creditcardNumber = 555555555;
	static int ccv;
	static int roomId;
	static List <ServiceCharge> actualCharge;
	
	@BeforeClass
	public static void beforeClass() {
		bookedArrival = new Date(); 
		stayLength = 10;
		numberOfOccupants=2;
		roomId = 1234;
		type = type.VISA;
		ccv = 786;
		testCreditCard = new CreditCard(type, creditcardNumber, ccv);
		guest = new Guest("Adrian", "Melburn", 123456);
		room = new Room(roomId, RoomType.SINGLE);
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
	}
	
	@Before
	public void setUp(){
		bookingTest = new Booking (guest, room, bookedArrival, stayLength, numberOfOccupants, testCreditCard);
	}
	
	@After
	public void tearDown(){
		bookingTest = null;
		
	}
	@Test
	public void testCheckoutServiceCost(){
		double actualServiceCost = 45.6;
		bookingTest.addServiceCharge(ServiceType.ROOM_SERVICE, actualServiceCost);
		bookingTest.checkOut();
		assertEquals(bookingTest.getCharges().get(0).getCost(), actualServiceCost, 0.0000);
	}
}
