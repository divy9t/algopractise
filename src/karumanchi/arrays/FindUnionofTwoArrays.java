package karumanchi.arrays;

import java.util.HashMap;

public class FindUnionofTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        performLogic(arr1, arr2);
    }

    private static void performLogic(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)
            findUnionIntersection(arr1, arr2);
        else
            findUnionIntersection(arr2, arr1);
    }

    private static void findUnionIntersection(int[] arr1, int[] arr2) {
        int unionCount = 0;
        int intersectionCount = 0;

        HashMap<Integer, Integer> elementCount = new HashMap<>();

        for (int i : arr1) {
            elementCount.put(i, 1);
        }

        for (int i : arr2) {
            if (elementCount.getOrDefault(i, null) != null) {
                intersectionCount += 1;
            } else {
                elementCount.put(i , 1);
            }
        }

        unionCount = elementCount.keySet().size();

        System.out.println("Union Count: " + unionCount);
        System.out.println("Intersection Count: " + intersectionCount);

    }
}
