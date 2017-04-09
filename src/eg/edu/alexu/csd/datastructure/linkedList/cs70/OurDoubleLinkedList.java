package eg.edu.alexu.csd.datastructure.linkedList.cs70;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *  Nodes of the linked list.
 */

class NodeD {
  /** value to save in. */
  public Object value;
  /** pointer to the next node. */
  public NodeD next;
  /** pointer to the previous node. */
  public NodeD pre;

  /**
   * The Constructor.
   * @param val
   *              inside value.
   */
  public NodeD(final Object val) {
    this.value = val;
    next = null;
    pre = null;
  }
}

/**
 * The Class OurDoubleLinkedList.
 */
public class OurDoubleLinkedList implements ILinkedList {

  /** The size. */
  private int size = 0;
  /** The head. */
  private NodeD head;
  /** The cur. */
  private NodeD cur;

  /**
   * Instantiates a new our double linked list.
   */
  public OurDoubleLinkedList() {
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
    NodeD newElement = new NodeD(element);
    if (head == null) {
      head = newElement;
    } else if (index == 0) {
      newElement.next = head;
      head.pre = newElement;
      head = newElement;
    } else {
      cur = head;
      for (int i = 1; i < index; i++) {
        cur = cur.next;
      }
      newElement.next = cur.next;
      cur.next = newElement;
      (cur.next).pre = newElement;
      newElement.pre = cur;
    }
    size++;
  }

  /** Inserts the specified element at the end of the list.
   * @param element
   *               element to add.
   * */
  public void add(final Object element) {
    if (element != null) {
      NodeD newElement = new NodeD(element);
      cur = head;
      if (head == null) {
        head = newElement;
      } else {
        for (int i = 0; i < size - 1; i++) {
          cur = cur.next;
        }
        newElement.next = null;
        newElement.pre = cur;
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
   * Replaces the element at the specified position in this list.
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

  /** Removes all of the elements from this list.*/
  public void clear() {
    head = null;
    size = 0;
  }

  /** Returns true if this list contains no elements.
   * @return true if empty.
   * */
  public boolean isEmpty() {
    return head == null || size == 0;
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
      head.pre = null;
    } else {
      cur = head;
      for (int i = 0; i < index - 1; i++) {
        cur = cur.next;
      }
      if (index + 1 != size) {
        ((cur.next).next).pre = cur;
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
