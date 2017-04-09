package eg.edu.alexu.csd.datastructure.queue.cs70;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class QueueTests.
 */
public class QueueTests {

  /** The x6. */
  final int x6 = 6;

  /** The list. */
  MyQueue list = new MyQueue();

  /** The array. */
  MyQueueArray array;

  /** The x1. */
  final int x1 = 1;

  /** The x2. */
  final int x2 = 2;

  /** The x3. */
  final int x3 = 3;

  /** The x4. */
  final int x4 = 4;

  /**
   * Test0.
   */
  @Test
  public void test0() {

    list.enqueue(x1);
    assertEquals(x1, list.dequeue());
    list.enqueue(x3);
    assertEquals(x3, list.dequeue());

  }

  /**
   * Test1.
   */
  @Test(expected = RuntimeException.class)
  public void test1() {

    list.enqueue(x3);
    list.enqueue(x4);
    list.enqueue(x3);
    assertEquals(x3, list.size());
    assertFalse(list.isEmpty());
    list.dequeue();
    list.dequeue();
    list.dequeue();
    list.dequeue();
  }

  /**
   * Test2.
   */
  @Test
  public void test2() {
    array = new MyQueueArray(x6);
    array.enqueue(x1);
    array.enqueue(x3);
    assertEquals(x2, array.size());
    array.dequeue();
    array.dequeue();
    assertTrue(array.isEmpty());
  }

  /**
   * Test3.
   */
  @Test(expected = RuntimeException.class)
  public void test3() {
    array = new MyQueueArray(x1);
    array.dequeue();
  }

  /**
   * Test4.
   */
  @Test(expected = RuntimeException.class)
  public void test4() {

    array = new MyQueueArray(x3);
    array.enqueue(x1);
    array.enqueue(x1);
    array.enqueue(x1);
    array.enqueue(x3);
  }
}
