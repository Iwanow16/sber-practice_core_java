import java.util.Iterator;

public class TestArrayList {
    public static void main(String[] args) {
        
        ArrayList arrayList1 = new ArrayList();

        try{
            arrayList1.add(12);
            arrayList1.add(10);
            arrayList1.add(2, 15);
            arrayList1.add(arrayList1.size(), 19);
            
            for (Object object : arrayList1) {
                System.out.print(object + " ");
            }
            System.out.println();

            ArrayList sublist = arrayList1.subList(0, 2);
            
            arrayList1.add(13);
            sublist.set(2, 4);
            for (Object object : sublist) {
                System.out.print(object + " ");
            }
            System.out.println();

            System.out.println(sublist.contains(0));
            System.out.println(sublist.contains(12));
            System.out.println(sublist.contains(1));

            arrayList1.clear();
            System.out.println(arrayList1.isEmpty());

            sublist.add(0, 1);
            sublist.set(1, 2);
            sublist.set(2, 3);

            Iterator<Object> it = sublist.iterator();

            while(it.hasNext())
            {
                System.out.print(it.next() + " ");
            }
                        
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
