package moviedvdshop.Model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thor
 */
public interface MainMovieListI {
	public ArrayList<Movie> getMovieList();
	public Movie getMovieById(int id) throws ClassNotFoundException, SQLException;
	public String  getStorageType();
	
}
