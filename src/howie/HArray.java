package howie;

/**
 * The {@code howie.HArray} class provides Array utility methods.
 *
 * @author Howie Hertzberg
 */
public class HArray {

    /**
     * Merge sorts an array of integers.
     *
     * @param arr the array of integers to be sorted
     * @return the sorted array
     * @throws IllegalArgumentException if the input array is null
     */
    public static int[] mergeSort(int[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        // Base case
        if(arr.length == 1) {
            return arr;
        }

        // Split array into two halves
        int[] arrA = arrayCopy(arr, 0, arr.length / 2);
        int[] arrB = arrayCopy(arr, arr.length / 2, arr.length);

        // Recursively sort and merge halves
        arrA = mergeSort(arrA);
        arrB = mergeSort(arrB);
        return merge(arrA, arrB);
    }

    /**
     * Merge sorts an array of doubles.
     *
     * @param arr the array of doubles to be sorted
     * @return the sorted array
     * @throws IllegalArgumentException if the input array is null
     */
    public static double[] mergeSort(double[] arr) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        // Base case
        if(arr.length == 1) {
            return arr;
        }

        // Split array into two halves
        double[] arrA = arrayCopy(arr, 0, arr.length / 2);
        double[] arrB = arrayCopy(arr, arr.length / 2, arr.length);

        // Recursively sort and merge halves
        arrA = mergeSort(arrA);
        arrB = mergeSort(arrB);
        return merge(arrA, arrB);
    }


    /**
     * Merges two sorted arrays of integers into a single sorted array.
     *
     * @param arrA the first sorted array of integers to be merged
     * @param arrB the second sorted array of integers to be merged
     * @return the sorted array containing all elements from both input arrays
     * @throws IllegalArgumentException if either input array is null
     */
    public static int[] merge(int[] arrA, int[] arrB) {
        // Validate input
        if(arrA == null || arrB == null) {
            throw new IllegalArgumentException("Input arrays cannot be null.");
        }

        // Create return array
        int[] returnArr = new int[arrA.length + arrB.length];

        // Merge elements from both arrays
        int i = 0, j = 0, k = 0;
        while(i < arrA.length && j < arrB.length) {
            if(arrA[i] < arrB[j]) {
                returnArr[k++] = arrA[i++];
            } else {
                returnArr[k++] = arrB[j++];
            }
        }

        // Add remaining elements
        while(i < arrA.length) { returnArr[k++] = arrA[i++]; }
        while(j < arrB.length) { returnArr[k++] = arrB[j++]; }
        return returnArr;
    }

    /**
     * Merges two sorted arrays of doubles into a single sorted array.
     *
     * @param arrA the first sorted array of doubles to be merged
     * @param arrB the second sorted array of doubles to be merged
     * @return the sorted array containing all elements from both input arrays
     * @throws IllegalArgumentException if either input array is null
     */
    public static double[] merge(double[] arrA, double[] arrB) {
        // Validate input
        if(arrA == null || arrB == null) {
            throw new IllegalArgumentException("Input arrays cannot be null.");
        }

        // Create return array
        double[] returnArr = new double[arrA.length + arrB.length];

        // Merge elements from both arrays
        int i = 0, j = 0, k = 0;
        while(i < arrA.length && j < arrB.length) {
            if(arrA[i] < arrB[j]) {
                returnArr[k++] = arrA[i++];
            } else {
                returnArr[k++] = arrB[j++];
            }
        }

        // Add remaining elements
        while(i < arrA.length) { returnArr[k++] = arrA[i++]; }
        while(j < arrB.length) { returnArr[k++] = arrB[j++]; }
        return returnArr;
    }

    /**
     * Performs a binary search on a sorted array of integers to find the index of a specific element.
     *
     * @param arr the sorted array of integers to be searched
     * @param target the element to search for
     * @return the index of the element, or -1 if it is not found
     * @throws IllegalArgumentException if the input array is null
     */
    public static int binarySearch(int[] arr, int target) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Performs a binary search on a sorted array of doubles to find the index of a specific element.
     *
     * @param arr the sorted array of doubles to be searched
     * @param target the element to search for
     * @return the index of the element, or -1 if it is not found
     * @throws IllegalArgumentException if the input array is null
     */
    public static int binarySearch(double[] arr, double target) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Performs a binary search on a sorted array of comparable objects to find the index of a specific element.
     *
     * @param arr the sorted array of comparable objects to be searched
     * @param target the element to search for
     * @return the index of the element, or -1 if it is not found
     * @throws IllegalArgumentException if the input array is null
     */
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T target) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Copies a portion of an array of integers into a new array.
     *
     * @param arr the input array of integers to be copied from
     * @param a the starting index (inclusive) of the input array to be copied from
     * @param b the ending index (exclusive) of the input array to be copied from
     * @return the array containing elements from index {@code a} (inclusive) to {@code b} (exclusive) of the input array
     * @throws IllegalArgumentException if the input array is null, the indices are not within
     * the bounds on the input array, or the start index is greater than the end index.
     */
    public static int[] arrayCopy(int[] arr, int a, int b) {
        // Validate input
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (a < 0 || b > arr.length) {
            throw new IllegalArgumentException("Indices must be within bounds of input array.");
        }
        if(a > b) {
            throw new IllegalArgumentException("Start index cannot be greater than end index.");
        }

        // Create and populate new array
        int[] returnArr = new int[b-a+1];
        for(int i = a; i < b; i++) {
            returnArr[i-a] = arr[i];
        }

        return returnArr;
    }

    /**
     * Copies a portion of an array of doubles into a new array.
     *
     * @param arr the input array of doubles to be copied from
     * @param a the starting index (inclusive) of the input array to be copied from
     * @param b the ending index (exclusive) of the input array to be copied from
     * @return the array containing elements from index {@code a} (inclusive) to {@code b} (exclusive) of the input array
     * @throws IllegalArgumentException if the input array is null, the indices are not within
     * the bounds on the input array, or the start index is greater than the end index.
     */
    public static double[] arrayCopy(double[] arr, int a, int b) {
        // Validate input
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (a < 0 || b > arr.length) {
            throw new IllegalArgumentException("Indices must be within bounds of input array.");
        }
        if(a > b) {
            throw new IllegalArgumentException("Start index cannot be greater than end index.");
        }

        // Create and populate new array
        double[] returnArr = new double[b-a+1];
        for(int i = a; i < b; i++) {
            returnArr[i-a] = arr[i];
        }

        return returnArr;
    }

    /**
     * Checks if an array of integers contains a specified element.
     *
     * @param arr the array of integers to search
     * @param item the integer to look for in the array
     * @return {@code true} if the array contains the integer, {@code false} otherwise
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static boolean contains(int[] arr, int item) {
        return indexOf(boxInteger(arr), item) != -1;
    }

    /**
     * Checks if an array of doubles contains a specified value.
     *
     * @param arr the array of doubles to search
     * @param item the double to look for in the array
     * @return {@code true} if the array contains the double, {@code false} otherwise
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static boolean contains(double[] arr, double item) {
        return indexOf(boxDouble(arr), item) != -1;
    }

    /**
     * Checks if an array of objects contains a specified element.
     *
     * @param <T> the type of objects held in the array
     * @param arr the array of elements to search
     * @param item the object to search for in the array
     * @return {@code true} if the array contains the object, {@code false} otherwise
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static <T> boolean contains(T[] arr, double item) {
        return indexOf(arr, item) != -1;
    }

    /**
     * Finds the index of the first occurrence of a specified element in an array of integers.
     *
     * @param arr the array of integers to search
     * @param item the integer to search for in the array
     * @return the index of the first occurrence of the integer, or -1 if it is not found
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static int indexOf(int[] arr, int item) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        return indexOf(boxInteger(arr), item);
    }

    /**
     * Finds the index of the first occurrence of a specified element in an array of doubles.
     *
     * @param arr the array of doubles to search
     * @param item the double to search for in the array
     * @return the index of the first occurrence of the double, or -1 if it is not found
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static int indexOf(double[] arr, int item) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        return indexOf(boxDouble(arr), item);
    }

    /**
     * Finds the index of the first occurrence of a specified element in an array of objects.
     *
     * @param <T> the type of objects held in the array
     * @param arr the array of elements to search
     * @param item the object to search for in the array
     * @return the index of the first occurrence of the object, or -1 if the item is not found
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public static <T> int indexOf(T[] arr, T item) {
        // Validate input
        if(arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if(arr.length == 0) {
            throw new IllegalArgumentException("Input array must contain at least one element.");
        }

        // Iterate through elements in array
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == item) {
                return i;
            }
        }

        return -1; // No matching elements
    }

    /**
     * Converts an array of primitive integers to an array of {@link Integer} elements.
     *
     * @param arr the array of primitive integers to be boxed
     * @return the array of {@link Integer} elements corresponding to the elements in the input array
     * @throws IllegalArgumentException if the input array is {@code null}
     */
    public static Integer[] boxInteger(int[] arr) {
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
     * Converts an array of primitive doubles to an array of {@link Double} elements.
     *
     * @param arr the array of primitive doubles to be boxed
     * @return the array of {@link Double} elements corresponding to the elements in the input array
     * @throws IllegalArgumentException if the input array is {@code null}
     */
    public static Double[] boxDouble(double[] arr) {
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