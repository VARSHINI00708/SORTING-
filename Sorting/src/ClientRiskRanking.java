import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ": risk=" + riskScore + ", balance=" + accountBalance;
    }
}

public class ClientRiskRanking {

    // Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending Risk):");
        for (Client c : arr) {
            System.out.println(c);
        }
        System.out.println("Total Swaps: " + swaps);
    }

    // Insertion Sort (Descending by riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            // Sort by riskScore DESC, if equal → higher balance first
            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending Risk + Balance):");
        for (Client c : arr) {
            System.out.println(c);
        }
    }

    // Top 10 highest risk clients
    public static void topClients(Client[] arr, int k) {
        System.out.println("\nTop " + k + " High Risk Clients:");

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // Clone arrays for separate sorting
        Client[] bubbleArr = clients.clone();
        Client[] insertionArr = clients.clone();

        // Bubble Sort
        bubbleSort(bubbleArr);

        // Insertion Sort
        insertionSort(insertionArr);

        // Top 10 (after descending sort)
        topClients(insertionArr, 10);
    }
}