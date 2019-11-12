package moviedvdshop.View;
import java.sql.SQLException;
import moviedvdshop.Model.MainMovieList;
import moviedvdshop.Model.Movie;

public class OrderUI {

	// får en liste med film-objekter

	public static void viewOrderMenu() { 
		System.out.println("The Order MovieDVD Menu");
		
		System.out.println("The Order MovieDVD Menu");
		System.out.println("The Order MovieDVD Menu");
		System.out.println("The Order MovieDVD Menu");

	}
	public static void viewMovieById(Movie movie) throws ClassNotFoundException, SQLException { 
		System.out.println("Movie:" + movie);
	}
	
}