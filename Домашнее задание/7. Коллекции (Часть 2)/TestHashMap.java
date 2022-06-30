public class TestHashMap {
    public static void main(String[] args) {
        
        HashMap<Integer, String> hashMap = new HashMap<>();
        
        /* Добавление элементов */
        hashMap.put(1, "1");
        hashMap.put(3, "2");
        hashMap.put(9, "3");

        /* Вывод значений */
        for (String el : hashMap.values())
            System.out.print(el + " ");
        System.out.println();

        /* Вывод ключей */
        for (Integer el : hashMap.keySet())
            System.out.print(el + " ");
        System.out.println();

        /* Вывод пар ключ-значение */
        for (var el : hashMap.entrySet())
            System.out.print(el + " ");
        System.out.println();

        /* Проверка на наличее ключа */
        System.out.println(hashMap.containsKey(9));
        System.out.println(hashMap.containsKey(0));

        /* Удаление элементов */
        System.out.println(hashMap.remove(1));

        /* Вывод оставшихся значений */
        for (String el : hashMap.values())
            System.out.print(el + " ");
        System.out.println();

        /* Проверка на пустоту */
        System.out.println(hashMap.isEmpty());
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }
}
