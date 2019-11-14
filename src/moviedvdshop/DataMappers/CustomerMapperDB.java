/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package moviedvdshop.DataMappers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import moviedvdshop.Model.Customer;
import moviedvdshop.Model.Movie;
import moviedvdshop.Util.DBConnector;

/**
 *
 * @author thor
 */
public class CustomerMapperDB implements CustomerMapperI{
	
	public Customer getCustomerFromPhone(String phone) throws ClassNotFoundException, SQLException {
		Customer retValCustomer = null;
		//DB connection
		/*
		+------------+------------------------+----------------+--------------------------------+--------------+------------+-----------+
		| CustomerID | Email                  | ContactName    | Address                        | City         | PostalCode | Phone     |
		+------------+------------------------+----------------+--------------------------------+--------------+------------+-----------+
		|          1 | Alfreds@Futterkiste.dk | Maria Anders   | Obere Str. 57                  | Berlin       | 12209      | 531148907 |
		|          2 | Ana@Trujillo.dk        | Ana Trujillo   | Avda. de la Constitución 2222  | México D.F.  | 05021      | 418171223
		*/
		//TOD: Get movie from DB
		String query = "Select * from customers where  phone = ?";
		
		Connection myConnector = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		myConnector = DBConnector.getConnector();
		
		pstmt = myConnector.prepareStatement(query);
		pstmt.setString(1,phone);
		rs = pstmt.executeQuery();
		// what if more than one with same phone? Mistake
		if (rs.next()) {
			retValCustomer = new Customer(rs.getInt("CustomerID"));
			String email = rs.getString("email");
			String myphone = rs.getString("phone");
			String name = rs.getString("contactname");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String postalcode = rs.getString("email");
			retValCustomer.setEmail(email);
			retValCustomer.setName(name);
			retValCustomer.setAddress(address);
			retValCustomer.setCity(city);
			retValCustomer.setPostalcode(postalcode);
			
		} else {
			System.out.println("No phone in DB. Create Customer instead");
			//Check for null as return value
		}
		
		
		rs.close();
		pstmt.close();
		myConnector.close();
		return retValCustomer;
	}
	
	public void createCustomer(Customer customer){
		
	}
	public void deleteCustomer(Customer customer) {
		
	}
	public void updateCustomer(Customer customer) {
		
	}
	
	@Override
	public Customer getCustomerFromEmail(String Email) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
