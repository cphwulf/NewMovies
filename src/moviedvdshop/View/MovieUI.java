package moviedvdshop.View;
import moviedvdshop.Model.Movie;
import moviedvdshop.Model.MainMovieList;

public class MovieUI {

	// får en liste med film-objekter

	public static void viewMovieList(MainMovieList movieList) { 
		for (Movie m : movieList.getMovieList()) {
			System.out.println(m);
		}
	}
	
}	