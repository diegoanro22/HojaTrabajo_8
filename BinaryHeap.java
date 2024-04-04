import java.util.NoSuchElementException;

public class BinaryHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private HeapNode<E> root;
    private int size;

    public BinaryHeap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(E element) {
        if (root == null) {
            root = new HeapNode<E>(element, null); // Pasando el tipo genérico E explícitamente
            size++;
        } else {
            HeapNode<E> parent = findNode(size + 1);
            HeapNode<E> newNode = new HeapNode<E>(element, parent); // Igual aquí, pasando E explícitamente
            if ((size + 1) % 2 == 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            siftUp(newNode);
            size++;
        }
    }

    private void siftUp(HeapNode<E> node) {
        while (node.parent != null && node.element.compareTo(node.parent.element) < 0) {
            E temp = node.element;
            node.element = node.parent.element;
            node.parent.element = temp;
            node = node.parent;
        }
    }


    private HeapNode<E> findNode(int index) {
        String path = Integer.toBinaryString(index);
        HeapNode<E> node = root;
        // Empezar en el segundo caracter, ya que el primero es siempre 1 en un árbol completo
        for (int i = 1; i < path.length() - 1; i++) {
            if (path.charAt(i) == '0') {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        E removedElement = root.element;
        if (size == 1) {
            root = null;
        } else {
            // Mover el último elemento a la raíz
            HeapNode<E> lastNode = findNode(size);
            root.element = lastNode.element;
            // Eliminar la referencia del último nodo
            if ((size % 2) == 0) {
                lastNode.parent.left = null;
            } else {
                lastNode.parent.right = null;
            }
            // Restaurar las propiedades del heap
            siftDown(root);
        }
        size--;
        return removedElement;
    }

    private void siftDown(HeapNode<E> node) {
        while (node != null) {
            HeapNode<E> smallest = node;
            if (node.left != null && node.left.element.compareTo(smallest.element) < 0) {
                smallest = node.left;
            }
            if (node.right != null && node.right.element.compareTo(smallest.element) < 0) {
                smallest = node.right;
            }
            if (smallest != node) {
                E temp = node.element;
                node.element = smallest.element;
                smallest.element = temp;
                node = smallest;
            } else {
                break; // El nodo está en la posición correcta
            }
        }
    }

    @Override
    public E peek() {
        return isEmpty() ? null : root.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
}
