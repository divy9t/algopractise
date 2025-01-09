package karumanchi.heap.final450;

public class HeapFromArray {
    int[] heap;
    int heapSize;
    int realSize;

    public HeapFromArray(int heapSize, int realSize) {
        this.heap = new int[heapSize + 1];
        heap[0] = 0;
        this.heapSize = heapSize;
        this.realSize = 0;
    }

    public void add( int element ) {
        realSize++;

        if (realSize > heapSize) {
            throw new RuntimeException("Heap is full");
        }

        heap[realSize] = element;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = realSize;
        int parent = index / 2;

        while (heap[parent] > heap[index] && index > 0) {
            swapElement(parent,index);
            index = parent;
            parent = index / 2;
        }

    }

    public int poll() {
        if (realSize <= 0) {
            throw new RuntimeException("Heap is empty");
        }

        int minElement = heap[1];
        heap[1] = heap[realSize];
        realSize--;

        int parent = 1;


        while (parent < realSize/2) {
            int left = 2 * parent;
            int right = left + 1;

            if (heap[parent] > heap[left]) {
                swapElement(parent, left);
                parent = left;
            } else if (heap[parent] > heap[right]) {
                swapElement(parent, right);
                parent = right;
            } else {
                break;
            }
        }

        return minElement;

    }


    public int peek() {
        return heap[1];
    }

    private void swapElement(int parent, int index) {
        int temp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = temp;
    }

    public static void main(String[] args) {
        HeapFromArray heap = new HeapFromArray(5, 0);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.add(0);
        System.out.println(heap.peek());
        heap.poll();
        System.out.println(heap.peek());

    }
}
