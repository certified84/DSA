package heap;

import java.util.Arrays;

public class CustomMinHeap implements CustomHeap {

    private int[] heap;
    private int position = 1;
    private int size = 0;

    public CustomMinHeap() {
        this.heap = new int[10];
    }

    public CustomMinHeap(int[] arr) {
//        this.heap = new int[arr.length + 1];
//        for (int i : arr) insert(i);
        heapify(arr);
    }

    @Override
    public void insert(int value) {

        if (size == heap.length - 1)
            heap = Arrays.copyOf(heap, heap.length * 2);

        heap[position] = value;
        int parentPos = position / 2;
        int tempPos = position;
        while (parentPos >= 1) {
            if (heap[parentPos] > heap[tempPos]) {
                swap(parentPos, tempPos);
                tempPos = parentPos;
                parentPos = parentPos / 2;
            } else break;
        }
        size++;
        position++;
    }

    @Override
    public int delete() {

        if (size == 0)
            throw new RuntimeException("Heap is empty");

        swap(1, --position);
        int current = heap[size--];
        int tempPos = 1, left = 2, right = 3;
        while (right <= position) {

            if (right > size) {
                if (heap[left] < heap[tempPos])
                    swap(tempPos, left);
                break;
            }

            if (heap[tempPos] < heap[left] && heap[tempPos] < heap[right])
                break;
            else if (heap[right] < heap[left] && heap[right] <= heap[tempPos]) {
                swap(tempPos, right);
                tempPos = right;
            } else {
                swap(tempPos, left);
                tempPos = left;
            }

            left = tempPos * 2;
            right = tempPos * 2 + 1;
        }
        return current;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    @Override
    public void getSort() {
        while (size > 0) delete();
    }

    @Override
    public int[] sort(int[] arr) {
        position = 1;
        size = 0;
        this.heap = new int[arr.length + 1];
        for (int i : arr) insert(i);
        while (size > 0) delete();
        return heap;
    }

    @Override
    public void heapify(int[] arr) {
        position = 1;
        size = 0;
        this.heap = new int[arr.length + 1];
        for (int i = 1; i < heap.length; i++) {
            heap[i] = arr[i - 1];
            size++;
            position++;
        }
        for (int i = arr.length; i > 0; i--) {
            int currentPos = i;
            while (true) {
                int left = currentPos * 2, right = currentPos * 2 + 1;
                if (left > size || right > size || (heap[currentPos] < heap[left] && heap[currentPos] < heap[right]))
                    break;
                else if (heap[right] < heap[left] && heap[right] < heap[currentPos]) {
                    swap(currentPos, right);
                    currentPos = right;
                } else {
                    swap(currentPos, left);
                    currentPos = left;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    @Override
    public int size() {
        return size;
    }
}
