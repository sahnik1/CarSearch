package Backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InterfaceTest {
	private String test1;
	private String test2;
	private String test3;
	private String test4;
	private String test5;
	private String test6;
	
	@Before
	public void setUp() throws Exception {
		test1=Interface.getWeb(1999,"Ford","Mustang");
		test2=Interface.getWeb(2019,"Nissan","Sentra");
		test3=Interface.getWeb(2016,"Toyota","Highlander");
		test4=Interface.getWeb(2019,"Ford","Ecosport");
		test5=Interface.getWeb(2014,"Toyota","Corolla");
		test6=Interface.getWeb(007,"Batman","Batmobile");
	}

	@Test
	public void testGetWeb() {
		assertTrue(test1.equals("Not Rated"));
		assertTrue(test2.equals("4"));
		assertTrue(test3.equals("5"));
		assertTrue(test4.equals("4"));
		assertTrue(test5.equals("5"));
		assertTrue(test6.equals("Error"));
	}

}
