/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package moviedvdshop.Controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import moviedvdshop.DataMappers.MovieMapperDB;
import moviedvdshop.DataMappers.MovieMapperFile;
import moviedvdshop.DataMappers.OrderMapperDB;
import moviedvdshop.DataMappers.OrderMapperFile;
import moviedvdshop.Model.Movie;
import moviedvdshop.Model.Order;
import moviedvdshop.DataMappers.OrderMapperI;

/**
 *
 * @author thor
 */
public class OrderHandler {
	private ArrayList<Order> orderList;
	private OrderMapperI myOrderMapper;
	private String storageType;
	
	public OrderHandler(String storageType) {
		
		orderList = new ArrayList<>();
		switch(storageType) {
			case "DB":
				myOrderMapper = new OrderMapperDB();
				this.storageType = "DB";
				break;
				//fillListFromDB();this.storageType = "DB";break;
			case "File":
				myOrderMapper = new OrderMapperFile();
				this.storageType = "File";
				break;
				//fillListFromFile();this.storageType = "File";break;
			default:
				myOrderMapper = new OrderMapperDB();
				this.storageType = "DB";
				break;
		}
	}
	
	
	public void fillOrdersFromStorage() throws ClassNotFoundException, SQLException {
		orderList = myOrderMapper.getOrders(0);
	}
	public void fillActiveOrdersFromStorage() throws ClassNotFoundException, SQLException {
		orderList = myOrderMapper.getOrders(1);
	}
	
	public void addOrderToList(Order myOrder) {
		orderList.add(myOrder);
	}
	
	public Order getOrderById(int id) {
		Order myOrder = null;
		//TODO: loop through list
		for (Order o : orderList) {
			if (o.getOrderID() == id) {
				myOrder = o;
				return myOrder;
			}
		}
		
		return myOrder;
	}
	public Order getOrder(Order order) {
		Order myOrder = null;
		int idx = orderList.indexOf(order);
		myOrder = orderList.get(idx);
		
		return myOrder;
	}
	public void showAllActiveOrders() {
		for (Order o: orderList) {
			if (o.getArchived()==0) {
				System.out.println(o);
			}
		}
	}
	public void showAllOrders() {
		for (Order o: orderList) {
			System.out.println(o);
		}
	}
	
	public int getSizeOfList() {
		int retVal = orderList.size();
		return retVal;
	}
	public void saveOrderToStorage(Order order) throws ClassNotFoundException, SQLException {
		myOrderMapper.saveOrderToStorage(order);
	}
	public void setOrderToArchived(Order order) throws ClassNotFoundException, SQLException {
		myOrderMapper.setOrderToArchived(order);
	}
	
}
