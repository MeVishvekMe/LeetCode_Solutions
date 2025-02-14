import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProduct; // List to store the prefix product of numbers

    public ProductOfNumbers() {
        // Constructor initializes the list
        prefixProduct = new ArrayList<>();
    }

    public void add(int num) {
        // If the number is 0, reset the list because any product involving 0 is 0
        if (num == 0) {
            prefixProduct.clear(); // Reset the stored prefix products
            return;
        }

        // If the list is empty, add the number itself as the first prefix product
        if (prefixProduct.isEmpty()) {
            prefixProduct.add(num);
        } else {
            // Otherwise, multiply the last prefix product by the new number and store it
            prefixProduct.add(prefixProduct.getLast() * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProduct.size();

        // If k is greater than the size of the list, return 0 (since a 0 was added previously)
        if (k > n) {
            return 0;
        }

        // If k equals n, return the last stored prefix product
        return k == n ? prefixProduct.getLast()
                : prefixProduct.getLast() / prefixProduct.get(n - k - 1);
    }
}
