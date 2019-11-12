package moviedvdshop.Model;

import java.util.ArrayList;

public class Order {
	int orderID;
	int customerID;
	int employeeID;
	int archived;
	String pickupTime;
	String pickupDate;
	ArrayList<Movie> movies;


	public Order(int customerID, int employeeID,String pickupTime , String pickupDate) {
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.pickupDate = pickupDate;
		this.pickupTime = pickupTime;
		movies = new ArrayList<>();
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public void setArchived(int archive) {
		this.archived = archive;
	}

	public int getArchived() {
		return archived;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}


	public int getOrderID() {
		return orderID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public String getPickupDate() {
		return pickupDate;
	}
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	public int getNumsOfMovies() {
		int retVal = movies.size();
		return retVal;
	}
}
