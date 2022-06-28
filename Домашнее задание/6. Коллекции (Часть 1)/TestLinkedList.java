import java.util.NoSuchElementException;
import java.util.Iterator;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        try{
            linkedList.add(0, 1);
            linkedList.add(2);
            linkedList.add(linkedList.size(), 3);
            linkedList.add(4);

            for (Object object : linkedList) {
                System.out.print(object + " ");
            }
            System.out.println();

            LinkedList sublist = linkedList.subList(1, 3);

            for (Object object : sublist) {
                System.out.print(object + " ");
            }
            System.out.println();

            System.out.println(sublist.getFirst());
            System.out.println(sublist.getLast());
            System.out.println(sublist.indexOf(3));
            System.out.println(sublist.pollFirst());
            System.out.println(sublist.pollLast());
            
            sublist.add(5);
            sublist.add(6);
            sublist.add(7);
            sublist.add(8);
            sublist.add(9);
            sublist.add(10);

            System.out.println(sublist.removeFirst());
            System.out.println(sublist.removeLast());
            System.out.println(sublist.remove(0));

            System.out.println(sublist.contains(0));
            System.out.println(sublist.contains(7));

            for (Object object : sublist) {
                System.out.print(object + " ");
            }
            System.out.println();

            sublist.clear();
            System.out.println(sublist.isEmpty());

            Iterator<Object> it = linkedList.iterator();

            while(it.hasNext())
            {
                System.out.print(it.next() + " ");
            }

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }
}
