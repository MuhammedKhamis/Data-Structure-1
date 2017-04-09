package eg.edu.alexu.csd.datastructure.queue.cs70;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;

import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * The Class Node.
 */

class Node {
  /** value to save in. */
  public Object value;
  /** pointer to next node. */
  public Node next;

  /**
   * The Constructor.
   * @param val
   *          inside value.
   */
  public Node(final Object val) {
    this.value = val;
    next = null;
  }
}

/**
 * The Class MyQueue.
 */
public class MyQueue implements IQueue, ILinkedBased {

  /** The size. */
  private int size = 0;

  /** The head. */
  private Node head = null;

  /** The tail. */
  private Node tail = null;

  /**
   * @param item
   *            the item we want to store in queue.
   */
  @Override
  public void enqueue(final Object item) {
    if (item == null) {
      throw new RuntimeException("Can't accept null");
    }
    /** the new node. */
    Node newElement = new Node(item);
    if (head == null) {
      head = newElement;
      tail = newElement;
    } else {
      tail.next = newElement;
      tail = tail.next;
    }
    size++;
  }

  /**
   * @return The first item in the queue.
   */
  @Override
  public Object dequeue() {
    if (size == 0) {
      throw new RuntimeException("Queue is Empty");
    }
    if (size == 1) {
      Object tmp = head.value;
      head = head.next;
      tail = head;
      size--;
      return tmp;
    }
    Object tmp = head.value;
    head = head.next;
    size--;
    return tmp;
  }

  /**
   * @return True if the queue is empty.
   */
  @Override
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * @return The current size of the queue.
   */
  @Override
  public int size() {
    return size;
  }
}
