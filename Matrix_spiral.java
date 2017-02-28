import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shaileshvajpayee on 2/28/17.
 */

/**
 * For example: 3 3 1 2 3 4 5 6 7 8 9 gives 1 2 3 6 9 8 7 4 5
 */
public class Matrix_spiral {
    public Matrix_spiral(){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int row = Integer.parseInt(input.charAt(0) + "");
        int col = Integer.parseInt(input.charAt(2) + "");
        ArrayList<Integer> a = new ArrayList<>();
        String[] arr = input.split(" ");
        int c = 1;
        List<ArrayList<Integer>> l = new LinkedList<>();
        System.out.println(row + " " + col);
        int k = 2;
        for(int i = 0; i <= row-1;i++){
            for(int j = 0; j <= col -1 ; j++){
                a.add(Integer.parseInt(arr[k]));
                k++;
                //System.out.println(i + " " + j);
            }
            l.add(a);
            a = new ArrayList<>();
        }


        ArrayList<Integer> result = spiralOrder(l);
        for(int i:result){
            System.out.print(i + " ");
        }
    }


    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int row = a.size() - 1;
        int col = a.get(0).size() - 1;
        int r = 0;
        int c = col;
        int col_low_limit = 0;
        int row_limit = 0;
        int row_upper_limit = row;
        int dir = 0; // right
        ArrayList<Integer> i = new ArrayList<Integer>();
        int counter = 0;
        int total_elements = (row + 1)*(col+1);
        while(counter < total_elements){
            if(dir == 0){
                i = a.get(r);
                for(int j = col_low_limit; j <= c; j++){
                    result.add(i.get(j));
                    counter++;
                }
                dir = 1;// bottom
                r++;
                row_limit++;
            }
            else if(dir == 1){
                while(r <= row_upper_limit){
                    i = a.get(r);
                    result.add(i.get(c));
                    counter++;
                    r++;
                }
                dir = 2; // left
                c--;
                row_upper_limit--;
                r = row_upper_limit;
            }
            else if(dir == 2){
                for(int j = c; j >= col_low_limit; j--){
                    result.add(i.get(j));
                    counter++;
                }
                dir = 3; // top
            }
            else if(dir == 3){
                while(r >= row_limit){
                    i = a.get(r);
                    result.add(i.get(col_low_limit));
                    counter++;
                    r--;
                }
                r++;
                dir = 0;
                col_low_limit++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Matrix_spiral m = new Matrix_spiral();
    }
}
