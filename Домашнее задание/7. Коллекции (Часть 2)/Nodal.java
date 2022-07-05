public class Nodal<E> {
    
    private E value;
    private Nodal<E> left;
    private Nodal<E> right;

    public Nodal(E value) {
        this.value = value;
        right = null;
        left = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Nodal<E> getLeft() {
        return left;
    }

    public void setLeft(Nodal<E> left) {
        this.left = left;
    }

    public Nodal<E> getRight() {
        return right;
    }

    public void setRight(Nodal<E> right) {
        this.right = right;
    }
}