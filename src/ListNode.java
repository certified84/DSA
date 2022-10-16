public class ListNode {
    int value;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.value = val;
    }

    ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.value).append("->");
            node = node.next;
        }
        return sb.toString();
    }
}
