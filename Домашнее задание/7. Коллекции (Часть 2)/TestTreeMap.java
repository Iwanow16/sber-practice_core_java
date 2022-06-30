public class TestTreeMap {
    public static void main(String[] args) {
        
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        /* Добавление элементов */
        treeMap .put(9, "1");
        treeMap .put(8, "2");
        treeMap .put(7, "3");

        /* Вывод значений */
        for (String el : treeMap.values())
            System.out.print(el + " ");
        System.out.println();

        /* Вывод ключей */
        for (Integer el : treeMap.keySet())
            System.out.print(el + " ");
        System.out.println();

        /* Вывод пар ключ-значение */
        for (var el : treeMap.entrySet())
            System.out.print(el + " ");
        System.out.println();

        /* Проверка на наличее ключа */
        System.out.println(treeMap.containsKey(9));
        System.out.println(treeMap.containsKey(0));

        /* Удаление элементов */
        System.out.println(treeMap.remove(8));

        /* Вывод оставшихся значений */
        for (String el : treeMap.values())
            System.out.print(el + " ");
        System.out.println();

        /* Проверка на пустоту */
        System.out.println(treeMap.isEmpty());
        treeMap.clear();
        System.out.println(treeMap.isEmpty());
    }
}
