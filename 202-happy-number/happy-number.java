import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        // Use a set to keep track of the numbers we have already seen
        Set<Integer> seen = new HashSet<>();
        
        // Continue the process until n becomes 1 or we hit a cycle
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        // If we exited because n == 1, it's a happy number
        return n == 1;
    }

    // Helper method to calculate the sum of the squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}