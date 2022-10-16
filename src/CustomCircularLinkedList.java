public class CustomCircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomCircularLinkedList() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Node<T> head() {
        return this.head;
    }

    public Node<T> tail() {
        return this.tail;
    }

    public Node<T> get(int position) {
        if (position < 0 || position >= size)
            return null;
        Node<T> node = head;
        int count = 0;
        while (count < size) {
            if (count == position)
                return node;
            node = node.next;
            count++;
        }
        return node;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (tail != null) {
            tail.next = node;
            node.next = head;
            tail = node;
            size++;
            return;
        }
        tail = node;
        head = node;
        head.next = head;
        size++;
    }

    public void insert(T value, int position) {
        if (position == 0) {
            insertHead(value);
            return;
        } else if (position < 0 || position >= size) {
            System.out.println("Index is out of bound");
            return;
        } else {
            Node<T> node = new Node<>(value);
            node.next = get(position);
            get(position - 1).next = node;
        }
        size++;
    }

    private void insertHead(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        if (tail == null)
            tail = node;
        size++;
    }

    private void insertTail(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        tail.next = node;
        tail = node;
        size++;
    }

    public void delete(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Index out of bound");
            return;
        } else if (position == 0) {
            deleteHead();
            return;
        } else {
            Node<T> node = get(position);
            Node<T> temp = get(position - 1);
            temp.next = node.next;
            node.next = null;
            if (position == size - 1)
                tail = temp;
        }
        size--;
    }

    public void delete() {
        delete(size - 1);
    }

    private void deleteHead() {
        head = head.next;
        if (head == null)
            tail = null;
        size--;
    }

    public Node<T> find(T value) {
        Node<T> node = head;
        while (node != tail) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(T value) {
        return find(value) != null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> node = head;
        if (node != null) {
            do {
                builder.append(node.value).append(" -> ");
                node = node.next;
            } while (node != head);
        }
        return builder.toString();
    }

    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node() {

        }

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}