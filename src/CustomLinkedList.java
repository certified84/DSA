import java.io.NotActiveException;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
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

    public Node<T> getRecurse(int position) {
        if (position < 0 || position >= size)
            return null;
        if (position == 0)
            return head;
        return getRecurse(--position).next;
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
            tail = node;
            size++;
            return;
        }
        insertHead(value);
    }

    public void insertRecurse(T value, int position) {
        if (position == 0)
            insertHead(value);
        else if (position < 0 || position >= size) {
            System.out.println("Index is out of bound");
        } else {
            Node<T> node = new Node<>(value);
            Node<T> prev = getRecurse(position - 1);
            node.next = prev.next;
            prev.next = node;
            size++;
        }
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

    protected void insertTail(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        if (tail == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
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

    protected T deleteHead() {
        T prev = head.value;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return prev;
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

    public boolean contains(T value) {
        return find(value) != null;
    }

    public void reverse() {
        Node<T> node = tail;
        int pos = size - 2;
        while (pos >= 0) {
            node.next = get(pos);
            pos--;
        }
    }

    public void removeDuplicates() {
        Node<T> current = head;
        while (current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
                size--;
                continue;
            }
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            builder.append(((Node<T>) temp).value).append(" -> ");
            temp = temp.next;
        }
        builder.append("END");
        return builder.toString();
    }
}