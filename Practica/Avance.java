import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
    private List<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        upHeap(heap.size() - 1);
    }

    public T deleteMax() {
        if (heap.isEmpty()) {
            return null;
        }

        swap(0, heap.size() - 1);
        T maxItem = heap.remove(heap.size() - 1);
        downHeap(0);
        return maxItem;
    }

    private void upHeap(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex >= 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }

    private void downHeap(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            downHeap(largestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }
}
