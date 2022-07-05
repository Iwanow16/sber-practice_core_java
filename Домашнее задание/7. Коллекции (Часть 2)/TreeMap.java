public class TreeMap<K, V> implements Map<K, V> {
    
    private Nodal<Entry<K, V>> node;
    private boolean isSearch = false;
    private int size;
    
    public TreeMap() {
        node = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        isSearch = false;
        return searchKey(node, key);
    }

    private boolean searchKey(Nodal<Entry<K, V>> child, K key) {
        
        if (key.equals(getKey(child))) {isSearch = true;}
        if (child.getLeft() != null && !isSearch) {searchKey(child.getLeft(), key);}
        if (child.getRight() != null && !isSearch) {searchKey(child.getRight(), key);} 
        return isSearch;
    }

    @Override
    public boolean containsValue(V value) {
        isSearch = false;
        return searchValue(node, value);
    }

    private boolean searchValue(Nodal<Entry<K, V>> child, V value) {
        
        try {
            if (value.equals(getValue(child))) {isSearch = true;}
        } catch (NullPointerException ex) {
            if (value == null) {isSearch = true;}
        }
        
        if (child.getLeft() != null && !isSearch)  {searchValue(child.getLeft(), value);}
        if (child.getRight() != null && !isSearch) {searchValue(child.getRight(), value);}
        
        return isSearch;
    }

    @Override
    public V get(K key) {
        Nodal<Entry<K, V>> child = node;
        while (true) {
            if (key.equals(getKey(child))) {return getValue(child);}
            else if (key.hashCode() < getKey(child).hashCode()) {
                child = child.getLeft();
                if (child == null) {return null;}
            } else {
                child = child.getRight();
                if (child == null) {return null;}
            }
        }
    }

    @Override
    public Entry<K, V> put(K key, V value) {
        Nodal<Entry<K, V>> newNode = new Nodal<>(new Entry<>(key, value));
        if (node == null) {
            node = newNode;
            size++;
        } else {
            Nodal<Entry<K, V>> parent;
            Nodal<Entry<K, V>> child = node;
            
            while (true) {
                parent = child;
                
                if (getKey(child).equals(key)) {
                    child.setValue(new Entry<>(key, value));
                    return newNode.getValue();
                } else if (key.hashCode() < getKey(child).hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;
                        return newNode.getValue();
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return newNode.getValue();
                    }
                }
            }
        }
        return newNode.getValue();
    }

    @Override
    public V remove(K key) {

        Nodal<Entry<K, V>> parent = node;
        Nodal<Entry<K, V>> child = node;
        boolean isLeft = true;

        while (!key.equals(getKey(child))) {
    
            parent = child;

            if (key.hashCode() < getKey(child).hashCode()) {
                isLeft = true;
                child = child.getLeft();
            } else {
                isLeft = false;
                child = child.getRight();
            }
            if (child == null)
                return null;
        }
        if (child.getLeft() == null && child.getRight() == null) {
            if (child == node) 
                node = null;
            else if (isLeft)
                parent.setLeft(null);
            else
                parent.setRight(null);
        }
        else if (child.getRight() == null) {
            if (child == node)
                node = child.getLeft();
            else if (isLeft)
                parent.setLeft(child.getLeft());
            else
                parent.setRight(child.getLeft());
        }
        else if (child.getLeft() == null) {
            if (child == node)
                node = child.getRight();
            else if (isLeft)
                parent.setLeft(child.getRight());
            else
                parent.setRight(child.getRight());
        }
        else {
            Nodal<Entry<K, V>> heir = replaceNode(child);
            if (child == node)
                node = heir;
            else if (isLeft)
                parent.setLeft(heir);
            else
                parent.setRight(heir); 
        }
        size--;
        return getValue(child);
    }

    private Nodal<Entry<K, V>> replaceNode(Nodal<Entry<K, V>> node) {
        Nodal<Entry<K, V>> parent = node;
        Nodal<Entry<K, V>> heirNode = node;
        Nodal<Entry<K, V>> child = node.getRight();

        while (child != null) {
            parent = heirNode;
            heirNode = child;
            child = child.getLeft();
        }
        if (heirNode != node.getRight()) {
            parent.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
            heirNode.setLeft(node.getLeft());
        } else {
            heirNode.setLeft(node.getLeft());
        }
        return heirNode;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        addValue(node, list);
        return list;
    }

    private void addValue(Nodal<Entry<K, V>> child, ArrayList<V> list) {
        list.add(getValue(child));
        if (child.getLeft() != null)
            addValue(child.getLeft(), list);
        if (child.getRight() != null)
            addValue(child.getRight(), list);
    }

    private K getKey(Nodal<Entry<K, V>> node) {
        return ((Entry<K, V>) node.getValue()).getKey();
    }

    private V getValue(Nodal<Entry<K, V>> node) {
        return ((Entry<K, V>) node.getValue()).getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        node = null;
        size = 0;
    }

    @Override
    public Collection<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> list = new ArrayList<>();
        addEntry(node, list);
        return list;
    }

    private void addEntry(Nodal<Entry<K, V>> child, ArrayList<Entry<K, V>> list) {
        list.add(child.getValue());
        if (child.getLeft() != null) {addEntry(child.getLeft(), list);}
        if (child.getRight() != null) {addEntry(child.getRight(), list);}
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> list = new ArrayList<>();
        rememberKey(node, list);
        return list;
    }

    private void rememberKey(Nodal<Entry<K, V>> child, ArrayList<K> list) {
        list.add(getKey(child));
        if (child.getLeft() != null) 
            rememberKey(child.getLeft(), list);
        if (child.getRight() != null) 
            rememberKey(child.getRight(), list);   
    }
}