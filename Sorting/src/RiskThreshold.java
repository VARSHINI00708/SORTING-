import java.util.*;

public class RiskThreshold {

    // ================= LINEAR SEARCH =================
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // ================= BINARY SEARCH INSERTION POINT =================
    public static int findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid; // exact match
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // insertion index
    }

    // ================= FLOOR =================
    public static int findFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }

    // ================= CEILING =================
    public static int findCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        int target = 30;

        // Linear Search (unsorted use-case)
        linearSearch(risks, target);

        // Binary Search variants
        int insertion = findInsertionPoint(risks, target);
        int floor = findFloor(risks, target);
        int ceil = findCeiling(risks, target);

        System.out.println("\nBinary Search Results:");
        System.out.println("Insertion Point: " + insertion);
        System.out.println("Floor: " + floor);
        System.out.println("Ceiling: " + ceil);
    }
}