package moviedvdshop.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import moviedvdshop.DataMappers.*;
import moviedvdshop.Model.Movie;

/**
 *
 * @author thor
 */
public class MainMovieList implements  MainMovieListI{
	private ArrayList<Movie> movies;
	private String storageType;
	public MovieMapperI movieMapper = null;
	
	public MainMovieList(String storageType) throws ClassNotFoundException, SQLException {
		movies = new ArrayList<>();
		switch(storageType) {
			case "DB":
				movieMapper = new MovieMapperDB();
				this.storageType = "DB";
				break;
				//fillListFromDB();this.storageType = "DB";break;
			case "File":
				movieMapper = new MovieMapperFile();
				this.storageType = "File";
				break;
				//fillListFromFile();this.storageType = "File";break;
			default:
				movieMapper = new MovieMapperDB();
				this.storageType = "DB";
				break;
		}
		fillList();
	}
	
	public ArrayList<Movie> getMovieList() {
		return movies;
	}

	public void fillList() throws ClassNotFoundException, SQLException { 
		movies = movieMapper.getMovieList();
	}
	
	public Movie getMovieById(int id) throws ClassNotFoundException, SQLException {
		//movies = fyldMigMedFilmFraDB();
		Movie movie = null;
		movie = movieMapper.getMovieById(id);
		return movie;
	}
	
	public String getStorageType(){
		return this.storageType;
	}
	
}
