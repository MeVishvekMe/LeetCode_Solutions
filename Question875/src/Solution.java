class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Find the maximum number of bananas in a single pile (upper bound for Koko's eating speed)
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        // Binary search range: minimum speed is 1, maximum speed is maxPile
        int left = 1, right = maxPile, optimalSpeed = maxPile;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Mid represents the potential eating speed
            long totalHours = 0;

            // Calculate the total hours required at the current eating speed (mid)
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid; // Equivalent to Math.ceil(pile / (double) mid)
            }

            // If Koko needs more hours than allowed, increase the eating speed
            if (totalHours > h) {
                left = mid + 1;
            }
            // If Koko can finish in h hours or less, try a slower speed
            else {
                optimalSpeed = mid;
                right = mid - 1;
            }
        }

        return optimalSpeed;
    }
}
