package moviedvdshop.Controllers;
import java.util.Scanner;
import moviedvdshop.View.MainRunMenu;

/**
 *
 * @author thor
 */
public class Controller {
	public static void runProgram() {
		int choice = 0;
		int exitValue = 9;
		Scanner myScanner = new Scanner(System.in);

		while(choice != exitValue) {
			MainRunMenu.showMainMenu();
			choice = myScanner.nextInt();
		}
	}
	
}
