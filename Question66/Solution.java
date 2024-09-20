class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry = 1;
        while(i > -1) {
            int number = digits[i] + carry;
            if(number / 10 == 0) {
                digits[i] += carry;
                return digits;
            }
            digits[i] = number % 10;
            carry = number / 10;
            i--;
        }
        if(carry != 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = carry;
            return arr;
        }
        return digits;
    }
}