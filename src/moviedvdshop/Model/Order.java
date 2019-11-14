package moviedvdshop.Model;

import java.util.ArrayList;
import moviedvdshop.Util.IdFactory;

public class Order {
	int orderID;
	int customerID;
	int employeeID;
	int archived;
	String pickupTime;
	String pickupDate;
	ArrayList<Movie> movies;
	
	public Order() {
	movies = new ArrayList<>();
		this.orderID = IdFactory.getOrderId();
	}
	
	public Order(int customerID, int employeeID,String pickupTime , String pickupDate) {
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.pickupDate = pickupDate;
		this.pickupTime = pickupTime;
		movies = new ArrayList<>();
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}
	
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
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
	/*
	
	int orderID;
	int customerID;
	int employeeID;
	int archived;
	String pickupTime;
	String pickupDate;
	ArrayList<Movie> movies;
	*/
	
	public String toString() {
		String msg = "";
		msg+= "Oid: " + orderID + ";";
		msg+= "Empid: " + employeeID + ";";
		msg+= "Arc: " + archived + ";";
		msg+= "pTime: " + pickupTime + ";";
		msg+= "pDate: " +pickupDate + ";[";
		try {
			for (Movie m : movies) {
				msg += m.getDirector() + ",";
				msg += m.getMovie_title()+ ",:";
			}
		} catch (Exception e) {
			System.out.println("No Movies yet");
		}
		msg += "]";
		return msg;
	}
}
