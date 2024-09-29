import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        int left = 0;
        int right = 0;
        int wordsCount = 0;
        int spaces = 0;
        
        while(left < words.length && right < words.length) {
            wordsCount += words[right].length();
            if(wordsCount + spaces >= maxWidth) {
                if(wordsCount + spaces - 1 < maxWidth) {
                    spaces--;
                }
                else {
                    wordsCount -= words[right].length();
                    right--;
                }
                
                int spacePut = (left == right) ? (maxWidth - wordsCount) : (maxWidth - wordsCount) / (right - left);
                int extraSpaces = (left == right) ? 0 : (maxWidth - wordsCount) % (right - left);
                int i = left;
                while(i <= right) {
                    sb.append(words[i]);
                    if(sb.length() == maxWidth) {
                        break;
                    }
                    int j = 0;
                    while(j < spacePut) {
                        sb.append(" ");
                        j++;
                    }
                    if(extraSpaces != 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                    i++;
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                wordsCount = 0;
                spaces = -1;
                left = right + 1;
            }
            spaces++;
            right++;
        }
        right--;
        if(left >= words.length) {
            return result;
        }
        int i = left;
        while(i <= right) {
            sb.append(words[i]);
            sb.append(" ");
            i++;
        }
        sb.deleteCharAt(sb.length() - 1);
        i = sb.length();
        while(i < maxWidth) {
            sb.append(" ");
            i++;
        }
        result.add(sb.toString());
        return result;
    }
}
