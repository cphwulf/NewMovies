/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedvdshop.Util;

import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thor
 */
public class IdFactoryTest {
	IdFactory myIdFactory;
	
	
	@Before
	public void setUp() throws SQLException, ClassNotFoundException {
		myIdFactory = new IdFactory();
	}

	@Test
	public void testgetOrderId() {
		int actual = myIdFactory.getOrderId();
		int expected = 10457;
		assertEquals(expected, actual);
	}
	
}
