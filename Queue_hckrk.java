/**
 * Created by shaileshvajpayee on 2/9/17.
 */
public class Queue_hckrk {
    private static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(!stackOldestOnTop.isEmpty()){
                return stackOldestOnTop.peek();
            }
            else{
                copy_stack();
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackOldestOnTop.isEmpty()){
                copy_stack();
            }
            return stackOldestOnTop.pop();
        }

        public void copy_stack(){
            while(!stackNewestOnTop.isEmpty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
