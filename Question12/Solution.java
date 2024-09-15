public class Solution {
    public String intToRoman(int num) {
        int[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = 12;
        StringBuilder result = new StringBuilder();
        while(i > -1) {
            int count = num / numbers[i];
            if(count > 0) {
                int j = 0;
                while(j < count) {
                    result.append(symbols[i]);
                    j++;
                }
                num %= numbers[i];
            }
            i--;
        }
        return result.toString();
    }
}
