import java.util.Arrays;
import java.util.Stack;

public class CustomMaxHeap {

    private int[] heap;
    private final Stack<Integer> stack;
    private int position = 1;
    private int size = 0;

    public CustomMaxHeap() {
        this.heap = new int[10];
        this.stack = new Stack<>();
        Arrays.fill(heap, -1);
    }

    public void insert(int value) {

        if (size == heap.length - 1) {
            heap = Arrays.copyOf(heap, heap.length * 2);
            Arrays.fill(heap, position, heap.length, -1);
        }

        heap[position] = value;
        int parentPos = position / 2;
        int tempPos = position;
        while (parentPos >= 1) {
            if (heap[parentPos] < heap[tempPos]) {
                swap(parentPos, tempPos);
                tempPos = parentPos;
                parentPos = parentPos / 2;
            } else break;
        }
        size++;
        position++;
    }

    public void delete() {

        if (size == 0)
            throw new RuntimeException("Heap is empty");

        int i = heap[0];
        swap(1, --position);
        stack.push(heap[position]);
        heap[position] = -1;
        int tempPos = 1, left = 2, right = 3;
        while (right <= position) {
            if (heap[tempPos] > heap[left] && heap[tempPos] > heap[right])
                break;
            else if (heap[right] < heap[left]) {
                if (heap[left] == -1) break;
                swap(tempPos, left);
                tempPos = left;
            } else {
                if (heap[right] == -1) {
                    swap(tempPos, left);
                    break;
                }
                swap(tempPos, right);
                tempPos = right;
            }

            left = tempPos * 2;
            right = tempPos * 2 + 1;
        }
        size--;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void getSort() {
        while (size > 0) {
            delete();
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
