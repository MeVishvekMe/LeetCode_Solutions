class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Pointers for word1 and word2
        int ptr1 = 0;
        int ptr2 = 0;

        // Using StringBuilder since it lets you create mutable strings
        StringBuilder sb = new StringBuilder();

        // Loop to alternatively add characters from both words
        while(ptr1 < word1.length() && ptr2 < word2.length()) {
            sb.append(word1.charAt(ptr1));
            sb.append(word2.charAt(ptr2));
            ptr1++;
            ptr2++;
        }

        // Appending remaining words
        while(ptr1 < word1.length()) {
            sb.append(word1.charAt(ptr1));
            ptr1++;
        }

        // Appending remaining words
        while(ptr2 < word2.length()) {
            sb.append(word2.charAt(ptr2));
            ptr2++;
        }

        // Convert and return the string
        return sb.toString();
    }
}