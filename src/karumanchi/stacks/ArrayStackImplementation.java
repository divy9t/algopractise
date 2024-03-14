package karumanchi.stacks;


//implement a class to use one single array to implement two stacks
public class ArrayStackImplementation {

    public static void main(String[] args) {

        twoStackImplementation();
        mStackImplementation();


    }

    private static void mStackImplementation() {
        MStackImplementation mStackImplementation = new MStackImplementation(3, 12);

        mStackImplementation.pushInStqck(0, 1);
        mStackImplementation.pushInStqck(0, 2);
        mStackImplementation.pushInStqck(0, 3);
        mStackImplementation.pushInStqck(0, 4);
        mStackImplementation.pushInStqck(0, 5);
        mStackImplementation.pushInStqck(0, 6);
        mStackImplementation.pushInStqck(0, 7);
        mStackImplementation.pushInStqck(0, 8);
        mStackImplementation.pushInStqck(0, 9);
        mStackImplementation.pushInStqck(0, 10);
        mStackImplementation.pushInStqck(0, 11);
        mStackImplementation.pushInStqck(0, 12);

        mStackImplementation.pushInStqck(1, 31);
        mStackImplementation.pushInStqck(1, 32);
        mStackImplementation.pushInStqck(1, 33);

        mStackImplementation.popFromStack(1);
        mStackImplementation.popFromStack(1);
        mStackImplementation.popFromStack(1);
        mStackImplementation.popFromStack(1);

        printMStack(mStackImplementation);
    }

    private static void printMStack(MStackImplementation mStackImplementation) {
        System.out.println("------------");
        for (int i = 0; i < mStackImplementation.stackArray.length; i++) {
            System.out.print(" - " + mStackImplementation.stackArray[i]);
        }
    }

    private static void twoStackImplementation() {
        TwoStacks twoStacks = new TwoStacks(10);
        twoStacks.pushStackOne(1);
        twoStacks.pushStackOne(2);
        twoStacks.pushStackOne(3);
        twoStacks.pushStackOne(4);
        twoStacks.pushStackOne(5);

        twoStacks.pushStackTwo(15);
        twoStacks.pushStackTwo(16);
        twoStacks.pushStackTwo(17);
        twoStacks.pushStackTwo(18);
        twoStacks.pushStackTwo(19);


        twoStacks.printStack();
        System.out.println();

        System.out.println(twoStacks.popStackTwo());
        System.out.println(twoStacks.popStackOne());


        twoStacks.printStack();
    }
}
