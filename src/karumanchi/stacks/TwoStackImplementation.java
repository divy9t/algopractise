package karumanchi.stacks;


//implement a class to use one single array to implement two stacks
public class TwoStackImplementation {

    public static void main(String[] args) {

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

        twoStacks.popStackTwo();
        twoStacks.popStackOne();


        twoStacks.printStack();


    }
}
