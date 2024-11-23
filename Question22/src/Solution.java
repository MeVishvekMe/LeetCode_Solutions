import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // Start the backtracking process with n open and n close parentheses available
        backTracking(n, n, result, new StringBuilder());

        return result;
    }

    public void backTracking(int open, int close, List<String> result, StringBuilder sb) {
        // Base case: When no open or close parentheses remain, add the combination to the result list
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        // If there are open parentheses left, add an open parenthesis and recurse
        if (open > 0) {
            sb.append("(");  // Add an open parenthesis
            backTracking(open - 1, close, result, sb);  // Recurse with one less open parenthesis
            sb.deleteCharAt(sb.length() - 1);  // Backtrack by removing the last character
        }

        // If there are more close parentheses than open ones, add a close parenthesis and recurse
        // Ensures the parentheses combination remains valid
        if (close > open) {
            sb.append(")");  // Add a close parenthesis
            backTracking(open, close - 1, result, sb);  // Recurse with one less close parenthesis
            sb.deleteCharAt(sb.length() - 1);  // Backtrack by removing the last character
        }
    }
}
