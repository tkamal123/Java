
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sunil
 *
 */
public class PriorityQueueTest {

	/*
	 * Part 1: complete
	 */

	PriorityQueue pq;

	@Before
	public void setup() {
		pq = new PriorityQueue(20);
	}

	@Test
	public void insertTestMin() {
		pq.insert(5);
		pq.insert(7);
		pq.insert(3);
		// insert a few numbers then test pq.min()
		assertEquals(3, pq.min());
	}

	@Test
	public void insertTestSize() {
		pq.insert(5);
		pq.insert(7);
		pq.insert(3);
		// insert a few numbers then test pq.size()
		assertEquals(3, pq.size());
	}

	@Test
	public void removeMinTest() {
		// step 1: add a few numbers to pq
		pq.insert(5);
		pq.insert(7);
		pq.insert(3);
		// step 2: call pq.removeMin() a few times to check
		// numbers are returned in ascending order
		assertEquals(3, pq.removeMin());
		assertEquals(5, pq.removeMin());
		assertEquals(7, pq.removeMin());
	}

	@Test(expected = PriorityQueueException.class)
	public void removeMinEmptyTest() {
		pq.removeMin();
	}
}
