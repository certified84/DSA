package heap;

public interface CustomHeap {

    void insert(int value);

    void delete();

    void getSort();

    int[] sort(int[] arr);

    void heapify(int[] arr);
}
