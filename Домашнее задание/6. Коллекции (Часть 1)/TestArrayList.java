public class TestArrayList {
    public static void main(String[] args) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        try{
            arrList.add(12);
            arrList.add(11);
            arrList.add(10);

            for (Integer integer : arrList) {
                System.out.print(integer + " ");
            }
            System.out.println();

            arrList.add(1);
            arrList.add(2);
            arrList.add(3);

            ArrayList<Integer> sublist = arrList.subList(1, 3);
            sublist.set(0, 0);
            
            for (Integer integer : sublist) {
                System.out.print(integer + " ");
            }
            System.out.println();

            System.out.println(sublist.isEmpty());
            sublist.clear();
            System.out.println(sublist.isEmpty());

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}