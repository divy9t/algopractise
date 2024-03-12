package karumanchi.stacks;

public class TwoStacks {
    Integer stackOneTop;
    Integer stackTwoTop;
    int[] stack;

    public TwoStacks(Integer length) {
        this.stackOneTop = 0;
        this.stackTwoTop = length - 1;
        this.stack = new int[length];
    }
    void pushStackOne(int value) {
        if (stackOneTop > stack.length/2) {
            System.out.println("Stack Overflow");
            return;
        }
        this.stack[this.stackOneTop] = value;
        this.stackOneTop++;
    }
    void pushStackTwo(int value) {
        if (stackTwoTop < this.stack.length/ 2 ) {
            System.out.println("Stack Overflow");
            return;
        }
        this.stack[this.stackTwoTop] = value;
        this.stackTwoTop--;
    }
    int popStackOne() {
        if ( this.stackOneTop < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        int temp = stack[stackOneTop];
        stack[stackOneTop] = 0;
        stackOneTop--;
        return temp;
    }
    int popStackTwo() {
        if ( this.stackTwoTop > stack.length) {
            System.out.println("Stack Underflow");
            return 0;
        }
        int temp = stack[stackTwoTop];
        stack[stackTwoTop] = 0;
        stackTwoTop++;
        return temp;
    }
    int peekOne() {
        return stack[stackOneTop];
    }

    int peekTwo() {
        return stack[stackTwoTop];
    }

    void printStack() {
        System.out.println("\n-----");
        System.out.println();
        System.out.print ("Value of Stack One: ");
        for (int i = 0; i <= stack.length /2 - 1; i++) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();

        System.out.print("Value of Stack Two: ");
        for (int i = stack.length - 1 ; i >= stack.length /2; i--) {
            System.out.print(stack[i] + " ");
        }
    }


}
