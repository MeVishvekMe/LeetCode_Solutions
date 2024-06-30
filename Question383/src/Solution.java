public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] storage = new int[26];
        int i = 0;
        while(i < magazine.length()) {
            int current = magazine.charAt(i) - 'a';
            storage[current]++;
            i++;
        }
        i = 0;
        while(i < ransomNote.length()){
            int current = ransomNote.charAt(i) - 'a';
            if(storage[current] == 0){
                return false;
            }
            storage[current]--;
            i++;
        }
        return true;
    }
}
