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
		//movies = fyldMigMedFilmFraDB();
		movies = MovieMapper.movieList();
	}

	public static Movie getMovieFromDBByID(int id) throws ClassNotFoundException, SQLException {
		//movies = fyldMigMedFilmFraDB();
		Movie movie = null;
		movie = MovieMapper.getMovieFromDBByID(id);
		return movie;
	}
	
	public void fillListFromFile() {
		movies = null;
	}


	
}
