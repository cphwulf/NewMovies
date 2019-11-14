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
	private static int orderid;
	private static int customerid;
	

	public static void init()throws SQLException, ClassNotFoundException {
		orderid = getMaxIdFromDB("orders", "orderid");
		customerid = getMaxIdFromDB("customers","customerid");
	}


	public static int getOrderId() {
		orderid = orderid + 1;
		return orderid;
	}
	public static int getCustomerId() {
		return orderid++;
	}
	
	private static int getMaxIdFromDB(String table, String field) throws SQLException, ClassNotFoundException {
		int res = 0;
		Connection myConnector = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		myConnector = DBConnector.getConnector();
		String query = "SELECT max(" + field + ") FROM " + table;
		statement = myConnector.createStatement();
		resultSet = statement.executeQuery(query);
		resultSet.first();
		res = resultSet.getInt(1);
		return res;
	}
	
}
