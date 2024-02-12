package easy;

public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(4));

    }
    public boolean divisorGame(int n) {
        return divisorGame(n, true);
    }
    public boolean divisorGame(int n, boolean aliceTurn) {
        if (n <= 1)
            return !aliceTurn;
        return divisorGame(n-1, !aliceTurn);
    }

}
