public class HashMap<K, V> implements Map<K, V> {

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity;
    private int size;

    public HashMap(){
        this.size = 0;
        this.capacity = (int) Math.pow(2, 20);
        this.buckets = new LinkedList[capacity];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        if (size == 0) {return true;}
        return false;
    }

    @Override
    public void clear() {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        for (LinkedList<Entry<K, V>> linkedList : buckets) {
            if (linkedList != null){
                for(int i = 0; i<linkedList.size(); i++) {
                    if (((Entry<K, V>) linkedList.get(i)).getKey().equals(key)) {return true;}
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<Entry<K, V>> linkedList : buckets) {
            if (linkedList != null) {
                for (int i = 0; i < linkedList.size(); i++) {
                    Object obj  = ((Entry<K, V>) linkedList.get(i)).getValue();
                    if (obj == null && value == null) {return true;}
                    else if (obj == null) {continue;}
                    else if (obj.equals(value)) {return true;}
                }
            }   
        }
        return false;
    }

    @Override
    public Collection<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> entry = new ArrayList<>();
        for (LinkedList<Entry<K, V>> linkedList : buckets) {
            if(linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {
                    entry.add(linkedList.get(i));
                }
            }
        }
        return entry;
    }

    @Override
    public V get(K key) {
        int bucketNumber = Math.abs(key.hashCode() % buckets.length);
        LinkedList<Entry<K, V>> list = buckets[bucketNumber];
    
        for(int i = 0; i < list.size(); i++){
            if (((Entry<K, V>) list.get(i)).getKey().equals(key)) {
                return ((Entry<K, V>) list.get(i)).getValue();
            }
        }
        return null;
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Entry<K, V>> linkedList : buckets) {
            if(linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {
                    keys.add(((Entry<K, V>) linkedList.get(i)).getKey());
                }
            }
        }
        return keys;
    }

    @Override
    public Entry<K, V> put(K key, V value) {
        int bucketNumber = key.hashCode() % buckets.length;
        var list = buckets[bucketNumber];

        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(((Entry<K, V>) list.get(i)).getKey().equals(key)){
                    ((Entry<K, V>) list.get(i)).setValue(value);
                    return new Entry<>(key, value);
                }
            }
        } else {list = new LinkedList<Entry<K, V>>();}
        size++;
        list.addLast(new Entry<>(key, value));
        buckets[bucketNumber] = list;
        return new Entry<>(key, value);
    }

    @Override
    public V remove(K key) {
        for (LinkedList<Entry<K, V>> linkedList : buckets) {
            if(linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {
                    if(((Entry<K, V>)linkedList.get(i)).getKey().equals(key)){
                        size--;
                        return ((Entry<K, V>) linkedList.remove(i)).getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> vals = new ArrayList<>();
        for (LinkedList<Entry<K, V>> linkedList : buckets) {
            if(linkedList != null){
                for (int i = 0; i < linkedList.size(); i++) {
                    vals.add(((Entry<K, V>) linkedList.get(i)).getValue());
                }
            }
        }
        return vals;
    }
}