package moviedvdshop.Model;

import java.sql.SQLException;
import moviedvdshop.DataMappers.CustomerMapperDB;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
*
+------------+------------------------+----------------+--------------------------------+--------------+------------+-----------+
| CustomerID | Email                  | ContactName    | Address                        | City         | PostalCode | Phone     |
+------------+------------------------+----------------+--------------------------------+--------------+------------+-----------+
|          1 | Alfreds@Futterkiste.dk | Maria Anders   | Obere Str. 57                  | Berlin       | 12209      | 531148907 |
|          2 | Ana@Trujillo.dk        | Ana Trujillo   | Avda. de la Constitución 2222  | México D.F.  | 05021      | 418171223 |
|          3 | Antonio@Moreno.dk      | Antonio Moreno | Mataderos 2312                 | México D.F.  | 05023      | 183135340 |
+------------+------------------------+----------------+--------------------------------+--------------+------------+-----------+
* @author thor
*/
public class CustomerTest {
	int customerID;
	String customerName;
	String email;
	String address;
	String city;
	String postalCode;
	String phone;
	CustomerMapperDB customerMapperDB;
	
	
	@Before
	public void setUp() {
		customerName = "Ana Trujillo";
		email = "Ana@Trujillo.dk";
		phone = "418171223";
		address = "Avda. de la Constitución 2222";
		city = "México D.F.";
		postalCode = "05021";
		customerID = 2;
		customerMapperDB = new CustomerMapperDB();
	}
	
	@Test
	public void testgetCustomerIdFromPhone() throws ClassNotFoundException, SQLException {
		Customer tmpCustomer = customerMapperDB.getCustomerFromPhone(phone);
		int expected = 2;
		int actual = tmpCustomer.getCustomerid();
		assertEquals(expected, actual);

	}
	@Test
	public void testgetCustomerIdFromEmail() throws ClassNotFoundException, SQLException {
		Customer tmpCustomer = customerMapperDB.getCustomerFromPhone(phone);
		String expected = "Ana@Trujillo.dk";
		String actual = tmpCustomer.getEmail();
		assertEquals(expected, actual);
	}
	
}
