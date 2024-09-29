public class Main {
    public static void main(String[] args) {

        String[] str = {
            "ask","not","what","your",
            "country","can","do","for",
            "you","ask","what","you","can",
            "do","for","your","country"
        };
        
        System.out.println(new Solution().fullJustify(str, 16));
    }
}