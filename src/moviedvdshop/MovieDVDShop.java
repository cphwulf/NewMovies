/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedvdshop;
import moviedvdshop.Controllers.Controller;
import moviedvdshop.Util.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**

 * @author thor
 */
public class MovieDVDShop {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		/*
		Connection myConnector = null;
		Statement statement = null;
		ResultSet resultSet = null;

		myConnector = DBConnector.getConnector();
		String query = "SELECT * FROM movies";
		statement = myConnector.createStatement();
		resultSet = statement.executeQuery(query);


		//lukker efter mig
		resultSet.close();
		statement.close();
		myConnector.close();
*/



		

		Controller controller = new Controller();
		controller.runProgram();
	}
	
}
