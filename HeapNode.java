public class HeapNode<E> {
    E element;
    HeapNode<E> left;
    HeapNode<E> right;
    HeapNode<E> parent; // referencia al nodo padre

    public HeapNode(E element, HeapNode<E> parent) {
        this.element = element;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
    

    public E getElement() {
        return this.element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public HeapNode<E> getLeft() {
        return this.left;
    }

    public void setLeft(HeapNode<E> left) {
        this.left = left;
    }

    public HeapNode<E> getRight() {
        return this.right;
    }

    public void setRight(HeapNode<E> right) {
        this.right = right;
    }

    public HeapNode<E> getParent() {
        return this.parent;
    }

    public void setParent(HeapNode<E> parent) {
        this.parent = parent;
    }

    
}