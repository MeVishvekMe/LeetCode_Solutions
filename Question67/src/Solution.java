public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int bit1 = (i >= 0) ? (a.charAt(i) - '0') : 0;
            int bit2 = (j >= 0) ? (b.charAt(j) - '0') : 0;
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if(carry == 1)
            result.append('1');
        return result.reverse().toString();
    }
}
