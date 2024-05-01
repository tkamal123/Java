import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLinkedListTest {

	DLinkedList dll;
	
	@Before
	public void setup() {
		dll = new DLinkedList();
	}
	
	@Test
	public void testAddAtHead() {
		dll.addAtHead("A");
		assertEquals("A",(String) dll.getHeadValue());
		assertEquals("A",(String) dll.getTailValue());		
		dll.addAtHead("B");
		assertEquals("B",(String) dll.getHeadValue());
		assertEquals("A",(String) dll.getTailValue());
	}

	@Test
	public void testAddAtTail() {
		dll.addAtTail("A");
		assertEquals("A",(String) dll.getHeadValue());
		assertEquals("A",(String) dll.getTailValue());		
		dll.addAtTail("B");
		assertEquals("A",(String) dll.getHeadValue());
		assertEquals("B",(String) dll.getTailValue());
	}

	@Test
	public void testDeleteAtHeadOne() {
		dll.addAtTail("A");
		dll.deleteAtHead();
		assertNull(dll.getHeadValue());
		assertNull(dll.getTailValue());
	}

	@Test
	public void testDeleteAtHeadTwo() {	
		dll.addAtHead("A");	
		dll.addAtHead("B");
		
		assertEquals("B",(String) dll.deleteAtHead());
		assertEquals("A",(String) dll.deleteAtHead());		
	}

	@Test
	public void testDeleteAtTailTwo() {
		dll.addAtHead("B");	
		dll.addAtHead("A");
		assertEquals("A",(String) dll.getHeadValue());
		assertEquals("B",(String) dll.getTailValue());
		assertEquals("B",(String) dll.deleteAtTail());
		assertEquals("A",(String) dll.deleteAtTail());
		assertNull(dll.getHeadValue());
		assertNull(dll.getTailValue());
		//assertEquals("A",(String) dll.deleteAtTail());	
	}

	@Test
	public void testReverseEmpty() {
		dll.reverse();
		assertNull(dll.getHeadValue());
		assertNull(dll.getTailValue());
	}
	
	@Test
	public void testReverseOne() {
		dll.addAtHead("A");
		dll.reverse();
		assertEquals("A",(String) dll.getHeadValue());
		assertEquals("A",(String) dll.getTailValue());
	}
	
	@Test
	public void testReverseThree() {
		dll.addAtHead("C");	
		dll.addAtHead("B");
		dll.addAtHead("A");
		dll.reverse();
		assertEquals("C",(String) dll.getHeadValue());
		assertEquals("A",(String) dll.getTailValue());
	}

	@Test
	public void testReverseFour() {
		dll.addAtHead("D");		
		dll.addAtHead("C");	
		dll.addAtHead("B");
		dll.addAtHead("A");
		dll.reverse();
		assertEquals("D",(String) dll.deleteAtHead());
		assertEquals("C",(String) dll.deleteAtHead());
		assertEquals("B",(String) dll.deleteAtHead());
		assertEquals("A",(String) dll.deleteAtHead());
		assertNull(dll.getHeadValue());
		assertNull(dll.getTailValue());
	}
	
	@Test
	public void testReverseFive() {
		dll.addAtHead(10);	
		dll.addAtHead(8);		
		dll.addAtHead(6);	
		dll.addAtHead(4);
		dll.addAtHead(2);
		dll.reverse();
		Integer[] arr = {10,8,6,4,2};
		
		for (int i=0; i<5; i++)
		{
			assertEquals(arr[i], dll.get(i));
		}
	}
}
