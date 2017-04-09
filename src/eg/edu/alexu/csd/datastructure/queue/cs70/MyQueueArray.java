package eg.edu.alexu.csd.datastructure.queue.cs70;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;


/**
 * The Class MyQueueArray.
 */
public class MyQueueArray implements IQueue, IArrayBased {

  /** The array. */
  private Object[] array;

  /** The size. */
  private int size = 0;

  /** The rare. */
  private int rare = 0;

  /** The front. */
  private int front = 0;

  /**
   * Instantiates a new my queue array.
   * @param arraySize the array size
   */
  public MyQueueArray(final int arraySize) {
    if (arraySize < 1) {
      throw new RuntimeException("Invalid Size");
    }
    array = new Object[arraySize];
  }

  /**
   * @param
   *        The new Object we want to add.
   */
  @Override
  public void enqueue(final Object item) {
    if (size == array.length) {
      throw new RuntimeException("Queue is full");
    }
    array[rare] = item;
    rare = (rare + 1) % array.length;
    size++;
  }

  /**
   * @return The first of the queue.
   */
  @Override
  public Object dequeue() {
    if (size == 0) {
      throw new RuntimeException("Queue is empty");
    }
    Object tmp = array[front];
    front = (front + 1) % array.length;
    size--;
    return tmp;
  }

  /**
   * @return True if queue is Empty.
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @return The current size.
   */
  @Override
  public int size() {
    return size;
  }
}
