package moviedvdshop.DataMappers;
import java.sql.SQLException;
import moviedvdshop.Model.Customer;

/**
 *
 * @author thor
 */
public interface CustomerMapperI {
		public Customer getCustomerFromPhone(String phone) throws ClassNotFoundException, SQLException ;
		public Customer getCustomerFromEmail(String Email)throws ClassNotFoundException, SQLException ;
		public void createCustomer(Customer customer)throws ClassNotFoundException, SQLException ;
		public void deleteCustomer(Customer customer)throws ClassNotFoundException, SQLException ;
		public void updateCustomer(Customer customer)throws ClassNotFoundException, SQLException ;
}
