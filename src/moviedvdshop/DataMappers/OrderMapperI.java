package moviedvdshop.DataMappers;
import java.sql.SQLException;
import java.util.ArrayList;
import moviedvdshop.Model.Movie;
import moviedvdshop.Model.Order;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public interface OrderMapperI {
	public ArrayList<Order> getOrders(int cond) throws ClassNotFoundException, SQLException ;
	public Order getOrderById(int id) throws ClassNotFoundException, SQLException ;
	public void saveOrderToStorage(Order order) throws ClassNotFoundException, SQLException ;
	public void setOrderToArchived(Order order) throws ClassNotFoundException, SQLException ;
	public ArrayList<Movie> getMoviesFromOrder(int id) throws ClassNotFoundException, SQLException;
}