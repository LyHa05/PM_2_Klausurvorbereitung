package thomas.a02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutoTest {
	Auto golf;
	Auto a6;

	@Before
	public void setUp() throws Exception {
		golf = new Auto("VW", 70, 4);
		a6 = new Auto(golf);
	}

	@Test
	public void test() {
		assertNotEquals(golf,a6);
	}
	
	@Test
	public void testToString(){
		System.out.println(a6);
	}

}
