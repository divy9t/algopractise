package easy;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {

        System.out.println(nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));

    }
    public static int nonConstructibleChange(int[] coins) {
        
        int[] sortedArray = bubbleSort(coins);
        int greatestSum = 0;
        for (int coin : sortedArray){
            int nextSmallSum = greatestSum + 1;
            if (coin > nextSmallSum){
                return nextSmallSum;
            }
            greatestSum += coin;
        }
        return greatestSum + 1;
    }

    private static int[] bubbleSort(int[] coins) {
        int n = coins.length;

        for (int i=0; i < n -1; i++){
            for (int j=0; j < n - i - 1; j++){
                if (coins[j] > coins[j+1]){
                    int temp = coins[j+1];
                    coins[j+1] = coins[j];
                    coins[j] = temp;
                }
            }
        }
        return coins;
    }

}

