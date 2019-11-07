/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package moviedvdshop.Model;

/**
 *
 * @author thor
 */
public class Movie {
	int movie_id;
	String movie_title;
	String director;
	String year;
	String genre_title;

	public Movie(int movie_id, String movie_title, String director, String year) {
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.director = director;
		this.year = year;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public String getDirector() {
		return director;
	}

	public String getYear() {
		return year;
	}

	public String getGenre_title() {
		return genre_title;
	}

	public void setGenre_title(String genre_title) {
		this.genre_title = genre_title;
	}



	
	
	
	
	
	
}
