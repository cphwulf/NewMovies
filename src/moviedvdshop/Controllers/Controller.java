package moviedvdshop.Controllers;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import moviedvdshop.Model.MainMovieList;
import moviedvdshop.Model.Order;
import moviedvdshop.Model.Movie;
import moviedvdshop.View.MainRunMenuUI;
import moviedvdshop.View.MovieUI;
import moviedvdshop.View.OrderUI;
import moviedvdshop.Util.IdFactory;

/*
System.out.println("************************************************");
System.out.println("Velkommen til CPH DVD Shop");
System.out.println("Muligheder:");
System.out.println("1. Vis Film");
System.out.println("2. Vis bestemt Film fra kortet");
System.out.println("3. Bestil film");
System.out.println("4. Vis bestilling");
System.out.println("8. Skift storage ");
System.out.println("9. Afslut");
System.out.println("************************************************");
*
*/
public class Controller {
	Scanner myScanner = new Scanner(System.in);
	MainMovieList myList = null;
	OrderHandler myOrderHandler = null;
	
	public void runProgram() throws ClassNotFoundException, SQLException {
		IdFactory.init();
		myList = new MainMovieList("DB");
		myOrderHandler = new OrderHandler("DB");
		myOrderHandler.fillActiveOrdersFromStorage();
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
					createNewOrder();
					break;
				case 4:
					myOrderHandler.showAllActiveOrders();
					break;
				case 5:
					myOrderHandler.showAllOrders();
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
	
	private void createNewOrder() throws ClassNotFoundException, SQLException {
		// TODO: sproguafh skiftsprog menu
		Order order = new Order();
		OrderUI myOrderUI = new OrderUI();
		myOrderUI.newOrderMenu();
		int choice = 0;
		while (choice != 7){
			System.out.println("Enter choice: ");
			choice = myScanner.nextInt();
			myOrderUI.getOrderOption(choice,order,myList);
		}
		myOrderHandler.saveOrderToStorage(order);
		myOrderHandler.fillActiveOrdersFromStorage();
		//OrderHandler.createOrderFromHashMap(myOptions);
		System.out.println("Done saving order" + order.getOrderID());
	}
	
}
