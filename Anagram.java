import java.util.Scanner;

/**
 * Created by shaileshvajpayee on 2/7/17.
 */
public class Anagram {
    public Anagram() {

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] freq = new int[26];
        char[] s1 = s.nextLine().toCharArray();
        char[] s2 = s.nextLine().toCharArray();
        for(char c:s1)
            freq[c - 97]++;
        for(char c:s2)
            freq[c-97]--;
        int count = 0;
        for(int i:freq) {
            if (i != 0) count+=Math.abs(i);
        }
        System.out.println(count);
    }
}
