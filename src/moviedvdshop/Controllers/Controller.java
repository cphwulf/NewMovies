package moviedvdshop.Controllers;
import java.sql.SQLException;
import java.util.Scanner;
import moviedvdshop.Model.MainMovieList;
import moviedvdshop.View.MainRunMenuUI;
import moviedvdshop.View.MovieUI;
/**
 *
 * @author thor
 */
public class Controller {
	public static void runProgram() throws ClassNotFoundException, SQLException {
		int choice = 0;
		int exitValue = 9;
		Scanner myScanner = new Scanner(System.in);
		MainMovieList movieList = new MainMovieList();
		
		while(choice != exitValue) {
			MainRunMenuUI.showMainMenu();
			choice = myScanner.nextInt();
			switch(choice) {
				case 1:
					MovieUI.viewMovieList(movieList);
					break;
				default:
					System.out.println("End");
					choice = exitValue;
			}
		}
	}
	
}
