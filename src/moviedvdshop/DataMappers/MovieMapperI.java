package moviedvdshop.DataMappers;

import java.sql.SQLException;
import java.util.ArrayList;
import moviedvdshop.Model.Movie;

/**
 *
 * @author thor
 */
public interface MovieMapperI {
	public ArrayList<Movie> getMovieList() throws ClassNotFoundException, SQLException ;
	public Movie getMovieById(int id) throws ClassNotFoundException, SQLException ;
}