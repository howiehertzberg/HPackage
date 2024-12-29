package howie;

/**
 * The {@code howie.HArray} class provides Array utility methods.
 *
 * @author Howie Hertzberg
 */
public class HArray {

    /**
     * Converts an array of primitive integers to an array of {@link Integer} objects.
     *
     * @param arr the array of primitive integers to be boxed
     * @return the array of {@link Integer} objects corresponding to the elements in the input array
     * @throws IllegalArgumentException if the input array is {@code null}
     */
    public static Integer[] arrayBoxInt(int[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        Integer[] returnArr = new Integer[arr.length];
        // Iterate through all elements in array
        for (int i = 0; i < arr.length; i++) {
            returnArr[i] = arr[i]; // Box each int to Integer
        }

        return returnArr;
    }

    /**
     * Converts an array of primitive doubles to an array of {@link Double} objects.
     *
     * @param arr the array of primitive doubles to be boxed
     * @return the array of {@link Double} objects corresponding to the elements in the input array
     * @throws IllegalArgumentException if the input array is {@code null}
     */
    public static Double[] arrayBoxDouble(double[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        Double[] returnArr = new Double[arr.length];
        // Iterate through all elements in array
        for (int i = 0; i < arr.length; i++) {
            returnArr[i] = arr[i]; // Box each double to Double
        }

        return returnArr;
    }

}