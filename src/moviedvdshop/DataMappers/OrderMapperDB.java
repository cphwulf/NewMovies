package moviedvdshop.DataMappers;

import java.util.ArrayList;
import moviedvdshop.Model.Order;
import moviedvdshop.Model.Movie;
import java.sql.*;
import moviedvdshop.Util.DBConnector;
/**
 *
 * @author thor
 */
public class OrderMapperDB implements OrderMapperI{
	
	
	@Override
	public void saveOrderToStorage(Order order) throws ClassNotFoundException, SQLException {
		/*
		+---------+------------+------------+------------+-----------+------------+---------------------+
		| orderid | CustomerID | EmployeeID | OrderDate  | ShipperID | pickuptime | creationtime        |
		+---------+------------+------------+------------+-----------+------------+---------------------+
		|   10248 |         90 |          5 | 2019-09-22 |         3 | 09:55:12   | 2019-11-12 09:55:03 |
		myMovie2 = new Movie(2, "Highlander", "Russell Mulchahy","1986");
		myMovie3 = new Movie(3, "Alien", "Ridley Scott", "1979");
		pickupTime = "10:30:00";
		pickupDate = "2019-11-12";
		myOrder = new Order(90, 1,pickupTime, pickupDate);
		myOrder.setOrderID(10444);
		+---------------+---------+----------+----------+
		| OrderDetailID | OrderID | movie_id | Quantity |
		+---------------+---------+----------+----------+
		|             1 |   10248 |       12 |       12 |
		|             2 |   10248 |       13 |       10 |
		|             3 |   10248 |       15 |        5 |
		
		
		*/
		Connection myConnector = null;
		Statement statement = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		myConnector = DBConnector.getConnector();
		String query = "INSERT INTO orders (orderid,customerid,employeeid,orderdate,pickuptime)";
		query += " VALUES (?,?,?,?,?)";
		pstmt = myConnector.prepareStatement(query);
		pstmt.setInt(1, order.getOrderID());
		pstmt.setInt(2, order.getCustomerID());
		pstmt.setInt(3, order.getEmployeeID());
		pstmt.setString(4, order.getPickupDate());
		pstmt.setString(5, order.getPickupTime());
		
		pstmt.executeUpdate();
		pstmt.close();
		int orderid = order.getOrderID();
		// nu film
		for (Movie m :order.getMovies()) {
			int movie_id = m.getMovie_id();
			query = "INSERT INTO order_details (orderid,movie_id)";
			query += " VALUES (?,?)";
			pstmt = myConnector.prepareStatement(query);
			pstmt.setInt(1, orderid);
			pstmt.setInt(2, movie_id);
			pstmt.executeUpdate();
			pstmt.close();
		}
		
		//lukker efter mig
		pstmt.close();
		myConnector.close();
		
	}
	
	@Override
	public ArrayList<Order> getOrders(int cond) throws ClassNotFoundException, SQLException {
		ArrayList<Order> returnList = new ArrayList<>();
		Connection myConnector = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM orders order by OrderDate desc ";
		
		myConnector = DBConnector.getConnector();
		if (cond == 1) {
			query = "SELECT * FROM orders where archived = 0 order by pickuptime asc";
		}
		statement = myConnector.createStatement();
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int orderid = resultSet.getInt("OrderID");
			int customerid = resultSet.getInt("customerid");
			int employeeid = resultSet.getInt("employeeid");
			String pickupTime = resultSet.getString("orderdate");
			String pickupDate = resultSet.getString("pickupTime");
			int archived = resultSet.getInt("archived");
			//(int customerID, int employeeID,String pickupTime , String pickupDate)
			Order tmpOrder = new Order(customerid,employeeid, pickupDate,pickupTime);
			ArrayList<Movie> tmpMovies = getMoviesFromOrder(orderid);
			for (Movie m: tmpMovies) {
				tmpOrder.addMovie(m);
			}
			tmpOrder.setArchived(archived);
			tmpOrder.setOrderID(orderid);
			returnList.add(tmpOrder);
		}
		
		resultSet.close();
		statement.close();
		myConnector.close();
		
		return returnList;
	}

	@Override
	public void setOrderToArchived(Order order) throws ClassNotFoundException, SQLException {
		String query = "UPDATE orders SET archived=1 where OrderId = ?";
		Connection myConnector = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		myConnector = DBConnector.getConnector();
		
		pstmt = myConnector.prepareStatement(query);
		int id = order.getOrderID();
		pstmt.setInt(1, id);
		 pstmt.executeUpdate();
		pstmt.close();
		myConnector.close();
	}
	

	@Override
	public ArrayList<Movie> getMoviesFromOrder(int id) throws ClassNotFoundException, SQLException {
		ArrayList<Movie> orderMovies = new ArrayList<>();
		String query = "Select od.movie_id, m.movie_title, m.price from order_details od ";
		query += " INNER JOIN movies m on od.movie_id = m.movie_id";
		query += " WHERE od.OrderId = ?";
		
		Connection myConnector = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		myConnector = DBConnector.getConnector();
		
		pstmt = myConnector.prepareStatement(query);
		pstmt.setInt(1, id);
		resultSet = pstmt.executeQuery();
		while(resultSet.next()){
			int movie_id = resultSet.getInt("movie_id");
			double price = resultSet.getDouble("price");
			String movie_title = resultSet.getString("movie_title");
			Movie tmpMovie = new Movie(movie_id, movie_title, price);
			orderMovies.add(tmpMovie);
		}
		resultSet.close();
		pstmt.close();
		myConnector.close();
		return orderMovies;
	}
	
	@Override
	public Order getOrderById(int id) throws ClassNotFoundException, SQLException {
		Order retValOrder = null;
		String query = "Select * from Orders where OrderId = ?";
		
		Connection myConnector = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		myConnector = DBConnector.getConnector();
		
		pstmt = myConnector.prepareStatement(query);
		pstmt.setInt(1, id);
		resultSet = pstmt.executeQuery();
		while(resultSet.next()){
			retValOrder = new Order(1, 2, "Kurt", "2001" );
		}
		resultSet.close();
		pstmt.close();
		myConnector.close();
		
		return retValOrder;
	}
	
}
