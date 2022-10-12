public class CustomDoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomDoublyLinkedList() {
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

    public void insert(T value, int position) {
        if (position == 0) {
            insertHead(value);
            return;
        } else if (position < 0 || position >= size) {
            System.out.println("Index is out of bound");
            return;
        } else if (position == size - 1) {
            insertTail(value);
            return;
        } else {
            Node<T> next = get(position);
            Node<T> prev = next.prev;
            Node<T> node = new Node<>(value, next, prev);
            prev.next = node;
            next.prev = node;
        }
        size++;
    }

    private void insertHead(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        if (head != null)
            head.prev = node;
        head = node;
        if (tail == null)
            tail = node;
        size++;
    }

    private void insertTail(T value) {
        Node<T> node = new Node<>(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public void delete(int position) {
        if (position >= size) {
            System.out.println("Index out of bound");
            return;
        } else if (position == 0) {
            deleteHead();
            return;
        } else if (position == size - 1) {
            deleteTail();
            return;
        } else {
            Node<T> node = get(position);
            Node<T> temp = get(position - 1);
            temp.next = node.next;
            temp.next.prev = temp;
            node.next = null;
            node.prev = null;
            if (position == size - 1)
                tail = temp;
        }
        size--;
    }

    private void deleteHead() {
        head = head.next;
        if (head == null)
            tail = null;
        size--;
    }

    private void deleteTail() {
        tail.prev.next = null;
        tail = tail.prev;
        size--;
    }

    public Node<T> find(T value) {
        Node<T> node = head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            builder.append(temp.value).append(" -> ");
            temp = temp.next;
        }
        builder.append("END");
        return builder.toString();
    }

    private class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node() {

        }

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            String next;
            String prev;
            if (this.next == null)
                next = null;
            else next = String.valueOf(this.next.value);
            if (this.prev == null)
                prev = null;
            else prev = String.valueOf(this.prev.value);
            return "Value: " + value + " Next: " + next + " Prev: " + prev;
        }
    }
}