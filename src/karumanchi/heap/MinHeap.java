package karumanchi.heap;


public class MinHeap {
    // Array representation of the heap
    private int[] heap;
    private int heapSize;  // Maximum size of the heap
    private int realSize = 0; // Current number of elements in the heap

    // Constructor to initialize the heap
    public MinHeap(int heapSize) {
        this.heapSize = heapSize;
        heap = new int[heapSize + 1]; // Use 1-based indexing
        heap[0] = 0; // Placeholder for 0th index
    }


    private void swapHeapElements(int index, int parent) {
        int temp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = temp;
    }

    // Add an element to the heap
    public void add(int element) {
        realSize++;
        if (realSize > heapSize) {
            throw new RuntimeException("Heap full!");
        }

        heap[realSize] = element;
        int index = realSize;
        int parent = index/2;

        while (heap[index] < heap[parent] && index > 1) {
            swapHeapElements(index, parent);
            index = parent;
            parent = index/2;
        }
    }

    // Remove and return the top (minimum) element from the heap
    public int pop() {
        if ( realSize <= 0) {
            throw new RuntimeException("Empty Heap!");
        }

        int removedElement = heap[1];
        heap[1] = heap[realSize];
        int parent = 1;

        while (parent <= realSize/2) {
            int leftChild = parent *2;
            int rightChild = parent * 2 + 1;
            if (heap[parent] > heap[leftChild]) {
                swapHeapElements(parent, leftChild);
                parent = leftChild;
            } else if (heap[parent] > heap[rightChild]) {
                swapHeapElements(parent, rightChild);
                parent = rightChild;
            } else {
                break;
            }

        }
        return removedElement;
    }

    // Peek at the top (minimum) element without removing it
    public int peek() {
        return heap[1];
    }

    // Helper method to heapify-down from a given index
    private void heapifyDown(int index) {
        // TODO: Implement the logic for fixing the heap property downward
    }

    // Helper method to heapify-up from a given index
    private void heapifyUp(int index) {
        // TODO: Implement the logic for fixing the heap property upward
    }

    // Get the current size of the heap
    public int size() {
        return realSize;
    }

    // Print the heap as a string
    @Override
    public String toString() {
        if (realSize == 0) {
            return "No elements in the heap!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 1; i <= realSize; i++) {
            sb.append(heap[i]);
            if (i < realSize) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10); // Initialize with max size of 10
        // TODO: Add test cases and call methods to test the implementation
    }
}
