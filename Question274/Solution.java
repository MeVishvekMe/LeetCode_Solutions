class Solution {
    public int hIndex(int[] citations) {
        int[] sorted = new int[citations.length + 1];
        int i = 0;
        while(i < citations.length) {
            if(citations[i] >= citations.length) {
                sorted[citations.length]++;
            }
            else {
                sorted[citations[i]]++;
            }
            i++;
        }
        i = sorted.length - 1;
        int count = 0;
        while(i > -1) {
            count += sorted[i];
            if(i <= count) {
                return i;
            }
            i--;
        }
        return 0;
    }
}