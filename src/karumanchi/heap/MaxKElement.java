package karumanchi.heap;

import java.util.PriorityQueue;

public class MaxKElement {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 2;
        printKHighestElement(arr, k);

    }

    private static void printKHighestElement(int[] arr, int k) {
        Heap minHeap = new Heap(
                k
        );

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (minHeap.peek() < arr[i]) {
                minHeap.pop();
                minHeap.add(arr[i]);
            }
        }

        System.out.println(minHeap.peek());

    }


    static class Heap {
        int[] heap;
        int realSize;
        int heapSize;

        public Heap(int size) {
            heapSize = size;
            heap = new int[heapSize + 1];
            heap[0] = 0;
        }

        public void add (int element) {
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

        public int peek() {
            return heap[1];
        }


        public int pop() {
            if (realSize <= 0) {
                throw new RuntimeException("Empty Heap!");
            }

            int removedElement = heap[1];
            heap[1] = heap[realSize];
            int parent = 1;

            while (parent <= realSize/2) {
                int leftChild = parent * 2;
                int rightChild = parent * 2 + 1;

                if (heap[parent] < heap[leftChild]) {
                    swapHeapElements(parent, leftChild);
                    parent = leftChild;
                } else if (heap[parent] < heap[rightChild]) {
                    swapHeapElements(parent, rightChild);
                    parent = rightChild;
                } else {
                    break;
                }
            }
            realSize--;
            return removedElement;
        }

        private void swapHeapElements(int index, int parent) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
        }


    }
}
