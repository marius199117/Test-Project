package Algorithms_Tests;

public class SmallestDistanceProblem {
    public static int findIndexWithSmallestDistance(int[] array) {
        if (array == null || array.length < 2) {
            // Not enough elements in the array
            return -1;
        }

        int minDistance = Integer.MAX_VALUE;
        int indexOfMinDistance = -1;

        for (int i = 0; i < array.length - 1; i++) {
            int currentDistance = Math.abs(array[i] - array[i + 1]);

            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                indexOfMinDistance = i;
            }
        }

        return indexOfMinDistance;
    }

    public static void main(String[] args) {
        int[] array = {4, 8, 6, 1, 2, 9, 4};
        int index = findIndexWithSmallestDistance(array);

        System.out.println("Index of the first number in the pair with smallest distance: " + index);
    }
}
