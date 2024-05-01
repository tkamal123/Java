import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LQueueTest {

	LQueue q;

	@Before
	public void setup() {
		q = new LQueue();
	}

	/*
	 * 2: complete the following test methods as specified.
	 */

	@Test
	public void testIsEmpty() {
		// test that q.isEmpty returns true
		assertTrue(q.isEmpty());
	}

	@Test
	public void testIsEmptyFalse() {
		// add an element to the queue "q"

		// then test that q is not an empty queue.
		q.enqueue(100);
		assertFalse(q.isEmpty());
	}

	@Test
	public void testSizeEmpty() {
		// test the size of an empty queue is 0
		assertEquals(0, q.size());
	}

	@Test
	public void testSizeNonEmpty() {
		// add an element(s) to the queue
		q.enqueue(200);
		q.enqueue(400);
		// then test the size of the queue
		assertEquals(2, q.size());
	}

	@Test
	public void testEnqueue() {
		// enqueue an element(s) to the queue
		q.enqueue(800);
		q.enqueue(500);

		// then test that the correct element is at the front
		assertEquals(800, q.front());
	}

	@Test
	public void testDequeue() {
		// enqueue multiple elements to the queue
		q.enqueue(700);
		q.enqueue(600);
		q.enqueue(300);
		q.enqueue(900);
		// then check that they are returned in the
		// correct order with dequeue.
		assertEquals(700, q.dequeue());
		assertEquals(600, q.dequeue());
		assertEquals(300, q.dequeue());
		assertEquals(900, q.dequeue());

	}

	@Test(expected = QueueException.class)
	public void testEmptyDequeue() {
		q.dequeue();
		// try to dequeue an empty queue
	}

	@Test(expected = QueueException.class)
	public void testEmptyFront() {
		q.front();
		// try to get the front value of an empty queue
	}
}
