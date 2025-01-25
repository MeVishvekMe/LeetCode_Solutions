class Solution {
    public String intToRoman(int num) {
        // Define the values and their corresponding Roman symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // Iterate over the values and symbols arrays
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                result.append(symbols[i]); // Append the corresponding Roman symbol
                num -= values[i]; // Subtract the value from num
            }
        }

        return result.toString();
    }
}