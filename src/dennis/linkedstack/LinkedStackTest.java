package dennis.linkedstack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedStackTest {
	LinkedStack<Integer> ls;
	@Before
	public void setUp() throws Exception {
		ls = new LinkedStack<>();
		for(int i=1; i<=5; i++){
			ls.push(i);
		}
	}

	@Test
	public void testPushPop() {
		assertEquals((Integer) 5, ls.pop());
		ls.push(6);
		assertEquals((Integer) 6, ls.pop());
		assertEquals((Integer) 4, ls.pop());
		
	}
	@Test
	public void testSize(){
		assertEquals(5, ls.size());
		ls.pop();
		assertEquals(4, ls.size());
	}

}
