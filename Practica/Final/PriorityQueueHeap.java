import java.util.ArrayList;
import java.util.NoSuchElementException;

class PriorityQueueHeap<T extends Comparable<T>> {
    private Heap<PriorityNode<T>> heap;

    public PriorityQueueHeap() {
        heap = new Heap<>();
    }

    public void enqueue(T item, int priority) {
        PriorityNode<T> node = new PriorityNode<>(item, priority);
        heap.insert(node);
    }

    public T dequeue() {
        PriorityNode<T> node = heap.remove();
        return node.getItem();
    }

    public T front() {
        PriorityNode<T> node = heap.getMax();
        return node.getItem();
    }

    public T back() {
    if (heap.isEmpty()) {
        throw new NoSuchElementException("Priority queue is empty");
    }

    PriorityNode<T> minPriorityNode = heap.getMax();

    for (int i = 0; i < heap.size(); i++) {
        PriorityNode<T> node = heap.get(i);
        if (node.getPriority() < minPriorityNode.getPriority()) {
            minPriorityNode = node;
        }
    }

    return minPriorityNode.getItem();   
}


    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private static class PriorityNode<T> implements Comparable<PriorityNode<T>> {
        private T item;
        private int priority;

        public PriorityNode(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(PriorityNode<T> other) {
            return Integer.compare(priority, other.priority);
        }
    }
}
