package algorithms;


public class Iterative {
    public static int binarySearch(int[] data, int target) {
        int mid;
        int high;
        int low;

        low = 0;
        high = data.length - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            if (data[mid] < target) {
                low = mid + 1;
            } else if (data[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    public static void bubbleSort(int[] data) {
        int size = data.length;

        for (int i = 0; i < size - 1; i++)

            for (int j = 0; j < size - i - 1; j++)

                if (data[j] > data[j + 1]) {

                    swap(data, j, j + 1);
                }

    }


    public static boolean contains(int[] data, int target) {
        for (int num : data) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }


    public static int indexOf(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static void insertionSort(int[] data) {
        int i;
        int j;

        for (i = 1; i < data.length; ++i) {
            j = i;

            while (j > 0 && data[j] < data[j - 1]) {

                Iterative.swap(data, j, j - 1);
                --j;
            }
        }
    }


    public static void selectionSort(int[] data) {
        int i;
        int j;
        int indexSmallest;


        for (i = 0; i < data.length; ++i) {
            indexSmallest = i;

            for (j = i + 1; j < data.length; ++j) {

                if (data[j] < data[indexSmallest]) {
                    indexSmallest = j;
                }
            }

            swap(data, i, indexSmallest);

        }
    }


    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
