package heap;

public interface CustomHeap {

    void insert(int value);

    int delete();

    void getSort();

    int[] sort(int[] arr);

    void heapify(int[] arr);

    int size();
}
