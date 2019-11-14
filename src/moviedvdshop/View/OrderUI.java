package moviedvdshop.View;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import moviedvdshop.Model.MainMovieList;
import moviedvdshop.Model.Movie;
import moviedvdshop.Model.Customer;
import moviedvdshop.Model.Order;
import moviedvdshop.DataMappers.CustomerMapperDB;
import java.util.Scanner;

public class OrderUI {
	
	// får en liste med film-objekter
	
	Scanner myScanner = new Scanner(System.in);
	CustomerMapperDB myCustomerMapperDB = new CustomerMapperDB();
	Customer tmpCustomer = null;
	ArrayList<Movie> custList = new ArrayList<>();
	public void newOrderMenu() {
		System.out.println("The Order MovieDVD Menu");
		System.out.println("1) get customer phone ");
		System.out.println("2) get pickuptime ");
		System.out.println("3) get movies ");
		System.out.println("4) view order ");
		System.out.println("5) submit order ");
	}
	public void getOrderOption(int id, Order order, MainMovieList myList) throws ClassNotFoundException, SQLException {
		String phrase = "";
		switch(id){
			case 1:
				phrase = "Get customer phone ";
				System.out.println(phrase);
				String phone = myScanner.nextLine();
				tmpCustomer = myCustomerMapperDB.getCustomerFromPhone(phone);
				if (tmpCustomer != null) {
					order.setCustomerID(tmpCustomer.getCustomerid());
				} else {
					tmpCustomer = new Customer(phone);
					order.setCustomerID(tmpCustomer.getCustomerid());
				}
				break;
			case 8:
				phrase = "Get customer email ";
				System.out.println(phrase);
				String email = myScanner.nextLine();
				if (tmpCustomer != null) {
					order.setCustomerID(tmpCustomer.getCustomerid());
				} else {
					tmpCustomer = new Customer(email);
					order.setCustomerID(tmpCustomer.getCustomerid());
				}
				break;
			case 2:
				phrase = "Get pickup time";
				System.out.println(phrase);
				String pickupTime = myScanner.nextLine();
				order.setPickupTime(pickupTime);
				break;
			case 3:
				int res = -1;
				String collect = "";
				String value = "";
				phrase = "Get list of Movies";
				System.out.println(phrase);
				while (res != 0) {
					System.out.println("Next movie (0 to stop)");
					value = myScanner.nextLine();
					res = Integer.parseInt(value);
					if (res !=0) {
					Movie tmpMovie = myList.getMovieById(res);
					order.addMovie(tmpMovie);
					}
				}
				break;
			case 4:
				phrase = "Show order";
				System.out.println(phrase);
				System.out.println(order);
				break;
			case 7: phrase = "7. Submit order  "; break;
			default: phrase = "Ledetekst med id = " + id + " findes ikke!";
		}
	}

	public String getOrderValue(int id) {
		String phrase = "";
		switch(id){
			case 1: phrase = "Customer Name: "; break;
			case 2: phrase = "Customer Email: "; break;
			case 3: phrase = "Pickup time"; break;
			case 4: phrase = "3. Get list of Movies"; break;
			case 5: phrase = "4. Show order"; break;
			case 6: phrase = "5. Edit order"; break;
			case 7: phrase = "6. Submit order  "; break;
			default: phrase = "Ledetekst med id = " + id + " findes ikke!";
		}
		return phrase;
	}
	
}