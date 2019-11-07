package moviedvdshop.DataMappers;

import java.sql.*;
import java.util.ArrayList;
import moviedvdshop.Model.Movie;
import moviedvdshop.Util.DBConnector;

/**
 *
 * @author thor
 */
public class MovieMapper {

	public static ArrayList<Movie> movieList() throws ClassNotFoundException, SQLException {
		/*
		movie_id	movie_title	director	year	genre_id
		1		Labyrinth	Jim Henson	1986	1
		public Movie(int movie_id, String movie_title, String director, String year
		*/
		ArrayList<Movie> returnList = new ArrayList<>();
		Connection myConn = null;
		Statement stmt = null;
		ResultSet res = null;
		// TODO: hent fra databasen
		myConn = DBConnector.getConnector();
		// skrevet en query
		String query = "SELECT * FROM movies";
		// få en statement
		stmt = myConn.createStatement();
		// få fyret en query af
		res = stmt.executeQuery(query);
		while (res.next()) {
			int movie_id = res.getInt("movie_id");
			String movie_title = res.getString("movie_title");
			String director = res.getString("director");
			//Date year = res.getDate("year");
			//TODO: convert this to java date-object OR use string in DB
			java.sql.Date dbSqlDate = res.getDate("year");
			Movie tmpMovie = new Movie(movie_id, movie_title, director, "2019");
			//System.out.println("Movie: " + tmpMovie);
			returnList.add(tmpMovie);
		}
		return returnList;
	}
	
}
