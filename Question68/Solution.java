import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int total = 0;
        int carry = 0;
        int right = 0;
        while(left < words.length && right < words.length) {
            total += words[right].length();
            if(total + carry > maxWidth) {
                right--;
                int num = right - left + 1;
                int spaces = (maxWidth - total) / (num - 1);
                int i = left;
                while(i < right) {
                    sb.append(words[i]);
                    int j = 0;
                    while(j < spaces) {
                        sb.append(" ");
                        j++;
                    }
                    i++;
                }
                sb.append(words[i]);
                result.add(sb.toString());
                sb = new StringBuilder();
                System.out.println(result);
            }
            carry++;
            System.out.println(right);
            right++;
            
        }
        return null;
    }
}
