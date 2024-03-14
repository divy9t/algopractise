package karumanchi.stacks;

import java.util.HashMap;

public class MStackImplementation {

    HashMap<Integer, Integer> stackStartPointers = new HashMap<>();
    int[] stackArray;
    Integer stackSize;

    /**
     *
     *stack = 5
     * stacksize = 3
     *
     */
    public MStackImplementation( Integer stacks, Integer stackSize ) {
        this.stackArray = new int[stacks * stackSize];
        this.stackSize = stackSize;
        for ( int i = 0; i < stacks; i++)
            stackStartPointers.put(i,  i * stackArray.length/stacks);

        System.out.println("\n");
        System.out.println(stackStartPointers);
    }


    void pushInStqck(int stackNumber, int value) {
        if (isStackFull(stackNumber)) {
            System.out.println("Stack Overflow");
            return;
        }
        Integer topPointer = stackStartPointers.get(stackNumber);
        stackArray[topPointer] = value;
        stackStartPointers.put(stackNumber, topPointer + 1);
    }

    private boolean isStackFull(int stackNumber) {
        return stackStartPointers.get(stackNumber) == ((stackNumber + 1) * stackSize) - 1;
    }

    void popFromStack(int stackNum) {
        if (isStackEmpty(stackNum)) {
            System.out.println("Stack Underflow");
            return;
        }
        Integer topPointer = stackStartPointers.get(stackNum);
        System.out.println("Popped value: " + stackArray[topPointer - 1]);
        stackArray[topPointer - 1] = 0;
        stackStartPointers.put(stackNum, topPointer - 1);
    }
    int peekFromStack(int stackNum) {
        return stackArray[stackStartPointers.get(stackNum)];
    }

    private boolean isStackEmpty(int stackNum) {
        return stackStartPointers.get(stackNum) <= stackNum * stackSize;
    }
}

