package moviedvdshop.DataMappers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import moviedvdshop.Model.Order;
import moviedvdshop.Model.Movie;

public class OrderMapperFile implements OrderMapperI{
	
	
	@Override
	public ArrayList<Order> getOrders(int cond) {
		ArrayList<Order> returnList = new ArrayList<>();
		/*
		`movie_id` int(11) NOT NULL AUTO_INCREMENT,
		`movie_title` varchar(100) NOT NULL,
		`director` varchar(50) NOT NULL,
		`year` year(4) NOT NULL,
		`genre_id` int(11) NOT NULL,
		int movie_id, String movie_title, String director, String year
		
		*/
		// TODO: hent fra file		Connection myConnector = null;
		File fh = new File("Data/movies.csv");
		Scanner myS;
		try {
			myS = new Scanner(fh);
			while (myS.hasNextLine()) {
				String line = myS.nextLine();
				Order tmpMovie = new Order(1,1,"kerer","1994");
				returnList.add(tmpMovie);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(MovieMapperFile.class.getName()).log(Level.SEVERE, null, ex);
		}
		return returnList;
	}
	
	public Order getOrderById(int id) {
		Order retValMovie = null;
		//TOD: Get movie from DB
		retValMovie = new Order(1,1,"kerer","1994");
		
		return retValMovie;
	}
	public void saveOrderToStorage(Order order) {
		
	}
	public void setOrderToArchived(Order order) {
		
	}
	
	public ArrayList<Movie> getMoviesFromOrder(int id) {
		
		ArrayList<Movie> retValArr = null;
		return retValArr;
	}
	
}
