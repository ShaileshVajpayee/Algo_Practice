import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by shaileshvajpayee on 2/8/17.
 */
public class Ransom {
    public Ransom() {
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] magazine = s.nextLine().split(" ");
        String[] ransom  = s.nextLine().split(" ");

        HashMap<String,Integer> map = new HashMap<>();

        for(String i:magazine){
            if(map.containsKey(i))
                map.put(i,map.get(i) + 1);
            else
                map.put(i,1);
        }

        boolean result = true;

        for(String i:ransom){
            if(map.containsKey(i)){
                if(map.get(i) >= 2) {
                    map.put(i, map.get(i) - 1);
                }
                else{
                    map.remove(i);
                }
            }
            else{
                result = false;
                break;
            }
        }
        if(result){
                System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
