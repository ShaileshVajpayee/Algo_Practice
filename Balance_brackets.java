import java.util.Scanner;
import java.util.Stack;

/**
 * Created by shaileshvajpayee on 2/8/17.
 */
public class Balance_brackets {
    public Balance_brackets() {
    }

    public static boolean balanced(String s){
        Stack<String> stack = new Stack<>();
        char c;
        char top;
        for(int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if(c=='['||c=='{'||c=='('){
                stack.push(c+"");
            }
            else if(stack.isEmpty()){
                return false;
            }
            else{
                top = stack.peek().charAt(0);
                if(c=='}' && top == '{'||c==']' && top == '['||c==')' && top == '('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            if(i == s.length() - 1 && stack.isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int exp = Integer.parseInt(s.nextLine());
        for(int i= 0;i<exp;i++){
            System.out.println((balanced(s.nextLine()))?"Yes":"No");
        }
    }
}
