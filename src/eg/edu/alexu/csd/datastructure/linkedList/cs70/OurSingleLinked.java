package eg.edu.alexu.csd.datastructure.linkedList.cs70;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * The Class Node.
 */
class Node {
  /** Variable to save the value. */
  public Object value;
  /** pointer to the next node. */
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
 * The Class OurSingleLinked.
 */
public class OurSingleLinked implements ILinkedList {

  /** The size. */
  private int size = 0;
  /** The head. */
  private Node head;
  /** The cur. */
  private Node cur;

  /**
   * Instantiates a new our single linked.
   */
  public OurSingleLinked() {
    head = null;
    cur = head;
  }

  /**
   * Inserts a specified element at the specified position in the list.
   * @param index
   *              index of the object.
   * @param element
   *              element to add.
   */
  public void add(final int index, final Object element) {
    if (index > size || element == null || index < 0) {
      throw new RuntimeException("Check your inputs");
    }
    Node newElement = new Node(element);
    if (head == null) {
      head = newElement;
    } else if (index == 0) {
      newElement.next = head;
      head = newElement;
    } else {
      cur = head;
      for (int i = 1; i < index; i++) {
        cur = cur.next;
      }
      newElement.next = cur.next;
      cur.next = newElement;
    }
    size++;
  }

  /** Inserts the specified element at the end of the list.
   * @param element
   *               element to add.
   * */
  public void add(final Object element) {
    if (element != null) {
      Node newElement = new Node(element);
      cur = head;
      if (head == null) {
        head = newElement;
      } else {
        for (int i = 0; i < size - 1; i++) {
          cur = cur.next;
        }
        newElement.next = null;
        cur.next = newElement;
      }
      size++;
    }
  }

  /** Returns the element at the specified position in this list.
   * @param index
   *              index of the element.
   *@return
   *        element we want to fetch.
   * */
  public Object get(final int index) {
    if (index >= size || index < 0) {
      throw new RuntimeException("Check your inputs");
    }
    cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur.value;
  }

  /**
   * Replaces the element at the specified position in this list
   * with the specified element.
   * @param index
   *              index of the element.
   *@param element
   *              the replacement.
   */
  public void set(final int index, final Object element) {
    cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    cur.value = element;
  }

  /** Removes all of the elements from this list. */
  public void clear() {
    head = null;
    size = 0;
  }

  /** Returns true if this list contains no elements.
   * @return true if empty.
   * */

  public boolean isEmpty() {
    return head == null;
  }

  /** Removes the element at the specified position in this list.
   * @param index
   *              index of the element to remove.
   * */
  public void remove(final int index) {
    if (index >= size || index < 0) {
      throw new RuntimeException("Check your inputs");
    }
    if (index == 0) {
      head = head.next;
    } else {
      cur = head;
      for (int i = 0; i < index - 1; i++) {
        cur = cur.next;
      }
      cur.next = (cur.next).next;
    }
    size--;
  }

  /** Returns the number of elements in this list.
   * @return size.
   * */
  public int size() {
    return size;
  }

  /**
   * Returns a view of the portion of this list between the specified
   *  fromIndex and toIndex,
   *  inclusively.
   *  @param fromIndex
   *                  the start.
   *  @param toIndex
   *                the end.
   *  @return the sublist.
   */
  public ILinkedList sublist(final int fromIndex, final int toIndex) {
    if (fromIndex >= size || toIndex >= size || fromIndex < 0 || toIndex < 0) {
      throw new RuntimeException("Check your inputs");
    }
    cur = head;
    for (int i = 0; i < fromIndex; i++) {
      cur = cur.next;
    }
    OurSingleLinked sub = new OurSingleLinked();
    for (int i = fromIndex; i <= toIndex; i++) {
      sub.add(cur.value);
      cur = cur.next;
    }
    return sub;
  }

  /**
   * Returns true if this list contains an element with the same value
   *  as the specified element.
   *  @param o1
   *            the object we want to search for.
   *  @return
   *          True of false.
   */
  public boolean contains(final Object o1) {
    if (o1 == null) {
      throw new RuntimeException("Check your inputs");
    }
    cur = head;
    for (int i = 0; i < size; i++) {
      if (o1.equals(cur.value)) {
        return true;
      }
      cur = cur.next;
    }
    return false;
  }
}
