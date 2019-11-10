package moviedvdshop.View;
import java.sql.SQLException;
import moviedvdshop.Model.MainMovieList;
import moviedvdshop.Model.Movie;

public class MovieUI {

	// får en liste med film-objekter

	public static void viewMovieList(MainMovieList movieList) { 
		for (Movie m : movieList.getMovieList()) {
			System.out.println("Title" + m.getDirector());
		}
	}
	public static void viewMovieById(Movie movie) throws ClassNotFoundException, SQLException { 
		System.out.println("Movie:" + movie);
	}
	
}	