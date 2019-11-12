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
		Scanner myScanner = new Scanner(System.in);
		MainMovieList myList = null;
		OrderHandler myOrderHandler = null;
	public void runProgram() throws ClassNotFoundException, SQLException {
		myList = new MainMovieList("DB");
		myOrderHandler = new OrderHandler("DB");
		int choice = 0;
		int exitValue = 9;
		
		while(choice != exitValue) {
			MainRunMenuUI.showMainMenu();
			choice = myScanner.nextInt();
			switch(choice) {
				case 1:
					MovieUI.viewMovieList(myList);
					break;
				case 2:
					System.out.println("Indtast id på film");
					int movieID = myScanner.nextInt();
					MovieUI.viewMovieById(myList.getMovieById(movieID));
					break;
				case 3:
					OrderUI.viewMovieById(myList.getMovieById(movieID));
					break;
				case 8:
					System.out.println("Switch storage from " + myList.getStorageType());
					int storageId = myScanner.nextInt();
					changeStorage(storageId);
					break;
				default:
					System.out.println("Exit");
					choice = exitValue ;
					
					
			}
		}
	}
	private void changeStorage(int id) throws ClassNotFoundException, SQLException {
		switch (id){
			case 1: myList = new MainMovieList("DB");break;
			case 2: myList = new MainMovieList("File");break;
		}
		System.out.println(myList.getStorageType());
	}
	
	
}
