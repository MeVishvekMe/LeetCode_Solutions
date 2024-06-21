public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while(left < right) {
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);
            if(chLeft < 48 || (chLeft > 57 && chLeft < 97) || chLeft > 122) {
                left++;
                continue;
            }
            if(chRight < 48 || (chRight > 57 && chRight < 97) || chRight > 122) {
                right--;
                continue;
            }

            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
