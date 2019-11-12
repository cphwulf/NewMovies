/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package moviedvdshop.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import moviedvdshop.Model.Movie;
import moviedvdshop.Model.Order;

/*
*
+---------+------------+------------+------------+-----------+------------+---------------------+
| orderid | CustomerID | EmployeeID | OrderDate  | ShipperID | pickuptime | creationtime        |
+---------+------------+------------+------------+-----------+------------+---------------------+
|   10248 |         90 |          5 | 2019-09-22 |         3 | 09:55:12   | 2019-11-12 09:55:03 |
|   10249 |         81 |          6 | 2019-09-23 |         1 | 09:55:12   | 2019-11-12 09:55:03 |
|   10250 |         34 |          4 | 2019-09-26 |         2 | 09:55:12   | 2019-11-12 09:55:03 |
+---------+------------+------------+------------+-----------+------------+---------------------+
+----------+-------------+-----------------+------+----------+-------+
| movie_id | movie_title | director        | year | genre_id | Price |
+----------+-------------+-----------------+------+----------+-------+
|        1 | Labyrinth   | Jim Henson      | 1986 |        1 |   1.5 |
|        2 | Highlander  | Russell Mulcahy | 1986 |        1 |     3 |
|        3 | Alien       | Ridley Scott    | 1979 |        2 |     4 |
+----------+-------------+-----------------+------+----------+-------+
*
*/
public class OrderTest {
	Movie myMovie1;
	Movie myMovie2;
	Movie myMovie3;
	Order myOrder;
	String pickupDate;
	String pickupTime;
	String deliverDate;
	String deliverTime;
	
	
	@Before
	public void setUp() {
		//myOrder = new Order(orderid, customerid, employeeid, orderdate, pickuptime);
		myMovie1 = new Movie(1, "Labyrenth", "Jim Henson", "1986");
		myMovie2 = new Movie(2, "Highlander", "Russell Mulchahy","1986");
		myMovie3 = new Movie(3, "Alien", "Ridley Scott", "1979");
		pickupTime = "10:30:00";
		pickupDate = "2019-11-12";
		myOrder = new Order(90, 1,pickupTime, pickupDate);
		myOrder.setOrderID(10444);
	}
	
	
	
	@Test
	public void getorderDate() {
		String expected = "10:30:00";
		String actual = myOrder.getPickupTime();
		assertEquals(expected, actual);
	}
	@Test
	public void addMovieToOrder() {
		myOrder.addMovie(myMovie1);
		myOrder.addMovie(myMovie2);
		myOrder.addMovie(myMovie3);
		int expected = 3;
		int actual = myOrder.getNumsOfMovies();
		assertEquals(expected, actual);
	}


	
}
