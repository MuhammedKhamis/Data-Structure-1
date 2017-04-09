package eg.edu.alexu.csd.datastructure.linkedList.cs70;

/**
 * The Class teeeesssst.
 */
public class Teeeesssst {

  /**
   * The main method.
   * @param args the arguments.
   */
  public static void main(final String[] args) {
    // TODO Auto-generated method stub
    OurDoubleLinkedList xlist = new OurDoubleLinkedList();
    if (xlist.isEmpty()) {
      System.out.println("YES");
    }
    final int x1 = 1;
    final Integer ynum = new Integer(5);
    final Integer znum = new Integer(1);
    String ustring = new String("sad");
    xlist.add(ustring);
    xlist.add(znum);
    xlist.add(ynum);
    xlist.remove(x1);
    if (xlist.isEmpty()) {
      System.out.println("YES");
    } else {
      System.out.println(xlist.get(0));
    }
  }
}
