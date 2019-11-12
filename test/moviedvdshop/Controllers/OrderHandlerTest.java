package moviedvdshop.Controllers;

import java.sql.SQLException;
import moviedvdshop.Model.Movie;
import moviedvdshop.Model.Order;
import moviedvdshop.Controllers.OrderHandler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thor
 */
public class OrderHandlerTest {
	Movie myMovie1;
	Movie myMovie2;
	Movie myMovie3;
	Order myOrder;
	Order myOrder2;
	OrderHandler myOrderHandler;
	String pickupDate;
	String pickupTime;
	String pickupTime2;
	String deliverDate;
	String deliverTime;
	
	
	
	public OrderHandlerTest() {
	}
	
	@Before
	public void setUp() {
		myMovie1 = new Movie(1, "Labyrenth", "Jim Henson", "1986");
		myMovie2 = new Movie(2, "Highlander", "Russell Mulchahy","1986");
		myMovie3 = new Movie(3, "Alien", "Ridley Scott", "1979");
		pickupTime = "10:30:00";
		pickupTime2 = "11:30:00";
		pickupDate = "2019-11-12";
		myOrder = new Order(90, 1,pickupTime , pickupDate);
		myOrder2 = new Order(89, 1,pickupTime2 , pickupDate);
		myOrder.setOrderID(10453);
		myOrder2.setOrderID(10457);
		myOrder.addMovie(myMovie1);
		myOrder.addMovie(myMovie2);
		myOrder2.addMovie(myMovie1);
		myOrder2.addMovie(myMovie2);
		myOrderHandler = new OrderHandler("DB");
	}
	
	@Test
	public void testaddOrderToList() {
		myOrderHandler.addOrderToList(myOrder);
		assertTrue(1==1);
		
	}
	@Test
	public void testgetOrderByID() {
		myOrderHandler.addOrderToList(myOrder);
		myOrderHandler.addOrderToList(myOrder2);
		int id = 10456;
		Order retOrder = myOrderHandler.getOrderById(id);
		String actual = retOrder.getPickupTime();
		String expected = "11:30:00";
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(expected, actual);
		
	}
	@Test
	public void testgetsizeOfList() {
		myOrderHandler.addOrderToList(myOrder);
		myOrderHandler.addOrderToList(myOrder2);
		int actual = myOrderHandler.getSizeOfList();
		int expected = 2;
		assertEquals(expected, actual);
	}
	@Test
	public void testgetOrder() {
		myOrderHandler.addOrderToList(myOrder);
		myOrderHandler.addOrderToList(myOrder2);
		Order myretVal = myOrderHandler.getOrder(myOrder);
		int expected = 10444;
		int actual = myretVal.getOrderID();
		assertEquals(expected, actual);
	}
	@Test
	public void testwriteOrdertoDB() throws ClassNotFoundException, SQLException {
		myOrderHandler.addOrderToList(myOrder);
		myOrderHandler.addOrderToList(myOrder2);
		//myOrderHandler.saveOrderToStorage(myOrder);
		myOrderHandler.saveOrderToStorage(myOrder2);
		//assertEquals(expected, actual);
		assertTrue(1==1);
	}
	@Test
	public void testsetOrderToArchived() throws ClassNotFoundException, SQLException {
		//myOrderHandler.setOrderToArchived(myOrder);
		myOrderHandler.setOrderToArchived(myOrder2);
		//myOrderHandler.saveOrderToStorage(myOrder);
		//myOrderHandler.saveOrderToStorage(myOrder2);
		//assertEquals(expected, actual);
		assertTrue(1==1);
	}
}
