package moviedvdshop.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import moviedvdshop.DataMappers.MovieMapper;
import moviedvdshop.Model.Movie;

/**
 *
 * @author thor
 */
public class MainMovieList {
	ArrayList<Movie> movies;

	public MainMovieList() throws ClassNotFoundException, SQLException {
		movies = new ArrayList<>();
		fillListFromDB();

	}

	public ArrayList<Movie> getMovieList() {
		return movies;
	}

	public void fillListFromDB() throws ClassNotFoundException, SQLException {
		//movies = MovieMapper.fyldMigMedFilmFraDB();
		movies = MovieMapper.movieList();
	}
	
	/*
	public void fillListFromFile() {
		movies = MovieFileMapper.movieList();
	}
*/


	
}
