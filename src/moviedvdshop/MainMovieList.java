package moviedvdshop;

import java.util.ArrayList;
import moviedvdshop.Model.Movie;

/**
 *
 * @author thor
 */
public class MainMovieList {
	ArrayList<Movie> movies;

	public MainMovieList() {
		movies = new ArrayList<>();

	}

	public ArrayList<Movie> getMovieList() {
		return movies;
	}

	public void fillListFromDB() {
		movies = fyldMigMedFilmFraDB();
	}
	
	public void fillListFromFile() {
		movies = fyldMigMedFilmFraFiler();
	}


	
}
