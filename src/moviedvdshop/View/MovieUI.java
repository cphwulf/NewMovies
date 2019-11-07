package moviedvdshop.View;
public class MovieUI {

	// får en liste med film-objekter

	public static void viewMovieList(MainMovieList movieList) { 
		for (Movie m : movieList) {
			System.out.println("Title" + m.getTitle());
		}
	}
	
}	