package algorithms;

/**
 * FIXME: Complete the following famous algorithms with their method body implementations
 *        It is suggested that you type them out by memory-ish to see if you understand the
 *        algorithm.
 */

public class Recursive {

    public static int binarySearch(int[] data, int target) {
        int min = 0;
        int max = data.length - 1;
        return binarySearch(data, target, min, max);
    }

    private static int binarySearch(int[] data, int target, int min, int max) {

        int mid = (max + min) / 2;

        if (data[mid] == target) {
            return mid;
        } else if (data[mid] > target) {
            return binarySearch(data, target, min, mid - 1);
        } else
            return binarySearch(data, target, mid + 1, max);
    }


    private static int[] getFirstHalf(int[] data) {
        int[] firstArray = new int[data.length / 2];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = data[i];
        }

        return firstArray;
    }


    private static int[] getSecondHalf(int[] data) {
        int[] secondArray = new int[data.length - (data.length / 2)];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = data[i + (data.length / 2)];
        }
        return secondArray;
    }


    private static void merge(int[] data, int[] left, int[] right) {
        int iLeft = 0;
        int iRight = 0;
        int j = 0;
        while (iLeft < left.length && iRight < right.length) {
            if (left[iLeft] < right[iRight]) {
                data[j] = left[iLeft];
                iLeft++;

            } else if (left[iLeft] > right[iRight]) {
                data[j] = right[iRight];
                iRight++;
            }
            j++;
        }

        while (iLeft < left.length) {
            data[j] = left[iLeft];
            iLeft++;
            j++;
        }
        while (iRight < right.length) {
            data[j] = right[iRight];
            iRight++;
            j++;
        }
    }

    public static void mergeSort(int[] data) {

        if (data.length <= 1) {
            return;
        }
        int[] firstArray = getFirstHalf(data);
        int[] secondArray = getSecondHalf(data);


        mergeSort(firstArray);
        mergeSort(secondArray);
        merge(data, firstArray, secondArray);

    }


    private static int partition(int[] data, int low, int high) {
        int i = low - 1;
        int j = high + 1;
        int pivot = data[low];
        while (i < j) {
            i++;
            while (data[i] < pivot) {
                i++;
            }
            j--;
            while (data[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(data, i, j);
            }
        }
        return j;
    }


    public static void quickSort(int[] data) {

        quickSort(data, 0, data.length - 1);
    }


    private static void quickSort(int[] data, int min, int max) {

        if (min >= max) {
            return;
        }
        int p = partition(data, min, max);
        quickSort(data, min, p);
        quickSort(data, p + 1, max);
    }


    public static void selectionSort(int[] data) {
        selectionSort(data, 0);
    }


    private static void selectionSort(int[] data, int start) {

        if (start + 1 == (data.length - 1)) {
            return;
        }

        int indexSmallest = start;
        for (int i = start + 1; i < data.length; ++i) {

            if (data[i] < data[indexSmallest]) {
                indexSmallest = i;
            }
        }
        swap(data, start, indexSmallest);
        selectionSort(data, start + 1);

    }


    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
