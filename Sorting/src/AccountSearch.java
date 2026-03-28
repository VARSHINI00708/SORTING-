import java.util.*;

public class AccountSearch {

    // ================= LINEAR SEARCH =================
    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // ================= BINARY SEARCH =================
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Search Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Search Comparisons: " + comparisons);
        return -1;
    }

    // ================= COUNT OCCURRENCES =================
    public static int countOccurrences(String[] arr, String target) {
        int count = 0;

        for (String s : arr) {
            if (s.equals(target)) count++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search (unsorted)
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");
        for (String s : logs) System.out.print(s + " ");

        // Binary Search
        int index = binarySearch(logs, "accB");
        System.out.println("\nBinary Search Index: " + index);

        // Count occurrences
        int count = countOccurrences(logs, "accB");
        System.out.println("Count of accB: " + count);
    }
}