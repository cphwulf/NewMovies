package moviedvdshop.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thor
 */
public class IdFactory {
	int orderid;
	
	public IdFactory() throws SQLException, ClassNotFoundException {
		this.orderid = getMaxIdFromDB();
	}
	public int getOrderId() {
		return orderid;
	}
	
	private int getMaxIdFromDB() throws SQLException, ClassNotFoundException {
		int res = 0;
		Connection myConnector = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		myConnector = DBConnector.getConnector();
		String query = "SELECT max(orderid) FROM orders";
		statement = myConnector.createStatement();
		resultSet = statement.executeQuery(query);
		resultSet.first();
		res = resultSet.getInt(1);
		return res;
	}
	
}
