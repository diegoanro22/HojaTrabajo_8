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
            throw new NoSuchElementException("Esta vacio");
        }
        E valueToRemove = root.element;
    
        if (size == 1) {
            root = null;
        } else {
            HeapNode<E> lastNode = findNode(size);
            root.element = lastNode.element; 
            
            if (lastNode.parent != null) {
                if (lastNode.parent.left == lastNode) {
                    lastNode.parent.left = null;
                } else {
                    lastNode.parent.right = null;
                }
            }
    
            siftDown(root);
        }
    
        size--;
        return valueToRemove;
    }

    public void siftDown(HeapNode<E> node) {
        while (node.left != null) { 
            HeapNode<E> smallerChild = node.left;
            if (node.right != null && node.right.element.compareTo(node.left.element) < 0) {
                smallerChild = node.right;
            }
            if (smallerChild.element.compareTo(node.element) < 0) {
                E temp = node.element;
                node.element = smallerChild.element;
                smallerChild.element = temp;
                node = smallerChild;
            } else {
                break; 
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
