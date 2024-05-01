import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	LinkedList l;

	@Before
	public void setup() {
		l = new LinkedList();
	}

	/*
	 * Part 1: implement these methods
	 */
	@Test
	public void testSizeEmpty() {
		// test l.size() for an empty linked list
		// checks the size of l (linkedList)
		assertEquals(0, l.size());
	}

	@Test
	public void testSizeMany() {
		// test l.size() after adding some numbers to the linked list
		// l adds head 100 and 200
		l.addAtHead(100);
		l.addAtTail(200);
		System.out.println(l);
		// checks twice with l length
		assertEquals(2, l.size());
	}

	@Test
	public void testSizeTwice() {
		// test l.size() twice after adding some numbers to the linked list
		l.addAtHead(100);
		l.addAtTail(200);

		assertEquals(2, l.size());
		l.addAtHead(100);
		l.addAtTail(200);

		assertEquals(4, l.size());
	}

	@Test
	public void testTotalEmpty() {
		// test l.total() for an empty linked list
		assertEquals(0, l.size());
	}

	@Test
	public void testTotalMany() {
		// test l.total() after adding some numbers to the linked list
		l.addAtHead(100);
		l.addAtTail(200);

		assertEquals(300, l.total());
	}

	@Test
	public void testTotalTwice() {
		// test l.total() twice after adding some numbers to the linked list
		l.addAtHead(100);
		l.addAtTail(200);

		assertEquals(300, l.total());
		l.addAtHead(100);
		l.addAtTail(200);

		assertEquals(600, l.total());
	}

	/*
	 * Optional part
	 */

	// @Test
	// public void testReverse() {
	// l.addAtHead(5);
	// l.addAtHead(2);
	// l.addAtHead(10);
	// l.reverse();
	// assertEquals(5, l.removeAtHead());
	// assertEquals(2, l.removeAtHead());
	// assertEquals(10, l.removeAtHead());
	// }

}
