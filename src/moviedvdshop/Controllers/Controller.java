package moviedvdshop.Controllers;
import java.sql.SQLException;
import java.util.Scanner;
import moviedvdshop.Model.MainMovieList;
import moviedvdshop.View.MainRunMenu;
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
		MainMovieList myList = new MainMovieList();
		
		while(choice != exitValue) {
			MainRunMenu.showMainMenu();
			choice = myScanner.nextInt();
			switch(choice) {
				case 1:
					MovieUI.viewMovieList(myList);
					break;
				case 2:
					System.out.println("Indtast id på film");
					int movieID = myScanner.nextInt();
					MovieUI.viewMovieById(movieID);
					break;
				default:
					System.out.println("Exit");
					choice = exitValue ;
					
					
			}
		}
	}
	
}
