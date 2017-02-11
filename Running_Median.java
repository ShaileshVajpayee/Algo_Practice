import java.util.Scanner;

/**
 * Created by shaileshvajpayee on 2/10/17.
 */
public class Running_Median {
    public Running_Median() {
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        Min_Heap heap = new Min_Heap(n);

    }
}

class Min_Heap{
    int capacity;
    int size;
    int[] elements;

    public Min_Heap(int capacity) {
        this.capacity = capacity;
        size = 0;
        elements = new int[capacity];
    }

    public int left_child_index(int parent_index){return 2*parent_index+1;}
    public int right_child_index(int parent_index){return 2*parent_index+2;}
    public int parent_index(int child_index){return (child_index-1)/2;}

    public boolean hasLeftChild(int index){return left_child_index(index) < size;}
    public boolean hasRightChild(int index){return right_child_index(index) < size;}
    public boolean hasParent(int index){return parent_index(index) > = 0;}

    public int left_child(int index){return elements[left_child_index(index)];}
    public int rigtht_child(int index){return elements[right_child_index(index)];}
    public int parent(int index){return elements[parent_index(index)];}

    public void swap(int i1,int i2){
        int temp = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = temp;
    }

    public int root(){return elements[0];}

    public int get_Min(){
        int element = elements[0];
        return element;
    }

    public void bubble_up(){

    }

}