public class Node<E> {
    protected E value;
    protected Node<E> next;

    public Node() {

    }

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        String next;
        if (this.next == null)
            next = null;
        else next = String.valueOf(this.next.value);
        return "Value: " + value + " Next: " + next;
    }
}
