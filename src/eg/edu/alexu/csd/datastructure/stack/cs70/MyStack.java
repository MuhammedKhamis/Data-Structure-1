package eg.edu.alexu.csd.datastructure.stack.cs70;

import eg.edu.alexu.csd.datastructure.stack.IStack;

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
   *              inside value.
   */
  public Node(final Object val) {
    this.value = val;
    next = null;
  }
}

/**
 * The Class MyStack.
 */
public class MyStack implements IStack {

  /** The size. */
  private int size;
  /** The head. */
  private Node head;
  /** The cur. */
  private Node cur;

  /**
   * Instantiates a new my stack.
   */
  public MyStack() {
    head = null;
    cur = head;
    size = 0;
  }

  /**
   * Inserts a specified element at the specified position in the list.
   * @param index
   *          zero-based index.
   * @param element
   *          object to insert.
   */
  @Override
  public void add(final int index, final Object element) {
    if (index > size || element == null || index < 0) {
      throw new RuntimeException("Check your inputs");
    }
    int index1 = size - index;
    Node newElement = new Node(element);
    if (head == null) {
      head = newElement;
    } else if (index1 == 0) {
      newElement.next = head;
      head = newElement;
    } else {
      cur = head;
      for (int i = 1; i < index1; i++) {
        cur = cur.next;
      }
      newElement.next = cur.next;
      cur.next = newElement;
    }
    size++;
  }

  /**
   * Removes the element at the top of stack and returns that element.
   * @return top of stack element, or through exception if empty.
   */
  @Override
  public Object pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }
    Object poped = head.value;
    head = head.next;
    size--;
    return poped;
  }

  /**
   * Get the element at the top of stack without removing it from stack.
   * @return top of stack element, or through exception if empty.
   */
  @Override
  public Object peek() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is Empty");
    }
    return head.value;
  }

  /**
   * Pushes an item onto the top of this stack.
   * @param element
   *                the new element.
   */
  @Override
  public void push(final Object element) {
    add(size, element);
  }

  /**
   * Tests if this stack is empty.
   * @return true if stack empty.
   */
  @Override
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack.
   */
  @Override
  public int size() {
    return size;
  }
}
