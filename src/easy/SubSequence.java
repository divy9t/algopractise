package easy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class SubSequence {
    public static void main(String[] args) {
        System.out.println(isValidSubsequence(
                Arrays.asList(5,1,22,25,6,-1,8,10),
                Arrays.asList(1,6,-1,10)
        ));

    }
    public static boolean isValidSubsequence(
            List<Integer> array, List<Integer> sequence
    ) {
        int arrayIdx = 0;
        int seqIdx = 0;

        while (arrayIdx < array.size() && seqIdx < sequence.size()){
            if (Objects.equals(array.get(arrayIdx), sequence.get(seqIdx)))
                seqIdx++;
            arrayIdx++;
        }
        return seqIdx == sequence.size();
    }
}
