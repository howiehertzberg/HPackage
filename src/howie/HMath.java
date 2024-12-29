package howie;

/**
 * The {@code howie.HMath} class provides mathematical utility methods.
 *
 * @author Howie Hertzberg
 */
public class HMath {

    /**
     * Returns the greatest value from an array of integers.
     *
     * @param arr the array of integers from which to find the maximum value
     * @return the maximum value among the provided integers
     * @throws IllegalArgumentException if the array is {@code null} or empty
     */
    public static int max(int[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        return max(HArray.arrayBoxInt(arr));
    }

    /**
     * Returns the greatest value from an array of doubles.
     *
     * @param arr the array of doubles from which to find the maximum value
     * @return the maximum value among the provided doubles
     * @throws IllegalArgumentException if the array is {@code null} or empty
     */
    public static double max(double[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        return max(HArray.arrayBoxDouble(arr));
    }

    /**
     * Returns the greatest value from an array of comparable elements.
     *
     * @param <T> the type of the elements in the array
     * @param arr the array of elements from which to find the maximum value
     * @return the maximum element among the provided elements
     * @throws IllegalArgumentException if the array is {@code null} or empty
     */
    public static <T extends Comparable<T>> T max(T... arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        // Iterate through elements in array
        T maxObj = arr[0];
        for(T obj : arr) {
            if(obj.compareTo(maxObj) > 0) {
                maxObj = obj; // Update maxObj if a larger object is found
            }
        }

        return maxObj;
    }

    /**
     * Returns the smallest value from an array of integers.
     *
     * @param arr the array of integers from which to find the minimum value
     * @return the minimum value among the provided integers
     * @throws IllegalArgumentException if the array is {@code null} or empty
     */
    public static int min(int[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        return min(HArray.arrayBoxInt(arr));
    }

    /**
     * Returns the smallest value from an array of doubles.
     *
     * @param arr the array of doubles from which to find the minimum value
     * @return the minimum value among the provided doubles
     * @throws IllegalArgumentException if the array is {@code null} or empty
     */
    public static double min(double[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        return min(HArray.arrayBoxDouble(arr));
    }

    /**
     * Returns the smallest value from an array of comparable elements.
     *
     * @param <T> the type of the elements in the array
     * @param arr the array of elements from which to find the minimum value
     * @return the minimum element among the provided elements
     * @throws IllegalArgumentException if the array is {@code null} or empty
     */
    public static <T extends Comparable<T>> T min(T... arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        // Iterate through elements in array
        T minObj = arr[0];
        for(T obj : arr) {
            if(obj.compareTo(minObj) < 0) {
                minObj = obj; // Update minObj if a smaller object is found
            }
        }

        return minObj;
    }

}
