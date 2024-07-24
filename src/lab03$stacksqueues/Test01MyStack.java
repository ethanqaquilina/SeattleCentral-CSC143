package lab03$stacksqueues;

import utils.MyQueue;
import utils.MyStack;

public class Test01MyStack {

    public static void intro() {
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t S T A C K    Q U E U E");
        System.out.println(" \t T E S T    P R O G R A M");
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();
    }


    public static void myStackPrintTest() {
        System.out.println("==========  M Y   S T A C K   T E S T  ==========");
        System.out.println();
        System.out.println();

        // Testing stack methods pop and push
        MyStack<String> stack = new MyStack<>();
        System.out.println(stack);
        stack.push("Red");
        System.out.println(stack);
        stack.push("Orange");
        System.out.println(stack);
        stack.push("Yellow");
        System.out.println(stack);
        stack.push("Green");
        System.out.println(stack);
        stack.push("Blue");
        System.out.println(stack);
        stack.push("Indigo");
        System.out.println(stack);
        stack.push("Violet");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println();
        System.out.println();

        // Testing size method
        System.out.println("==========  M Y   S T A C K   T E S T   S I Z E  ==========");
        System.out.println();
        System.out.println();
        stack.push("Red");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Green");
        stack.push("Blue");
        stack.push("Indigo");
        stack.push("Violet");
        System.out.println(stack);
        System.out.println();
        System.out.println("Size should be 7 : " + stack.size());
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
        System.out.println("Removed all elements.");
        System.out.println();
        System.out.println(stack);
        System.out.println();
        System.out.println("Size should be 0 : " + stack.size());
        System.out.println();
        System.out.println();

        // Testing size method
        System.out.println("==========  M Y   S T A C K   T E S T   E M P T Y  ==========");
        System.out.println();
        System.out.println();
        System.out.println("Should equal [] : " + stack);
        System.out.println("Should equal true : " + stack.isEmpty());
        System.out.println();
        System.out.println();

        // Testing peek method
        System.out.println("==========  M Y   S T A C K   T E S T   P E E K  ==========");
        System.out.println();
        System.out.println();
        stack.push("Red");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("Orange");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("Yellow");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("Green");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("Blue");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("Indigo");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("Violet");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println();
        System.out.println();

    }
    public static void myQueuePrintTest(){
            System.out.println("==========  M Y   Q U E U E   T E S T  ==========");
            System.out.println();
            System.out.println();

            // Testing queue methods add and remove
            MyQueue<String> queue = new MyQueue<>();
            System.out.println(queue);
            queue.add("Red");
            System.out.println(queue);
            queue.add("Orange");
            System.out.println(queue);
            queue.add("Yellow");
            System.out.println(queue);
            queue.add("Green");
            System.out.println(queue);
            queue.add("Blue");
            System.out.println(queue);
            queue.add("Indigo");
            System.out.println(queue);
            queue.add("Violet");
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            queue.remove();
            System.out.println(queue);
            System.out.println();
            System.out.println();

            // Testing size method
            System.out.println("==========  M Y   Q U E U E  T E S T   S I Z E  ==========");
            System.out.println();
            System.out.println();
            queue.add("Red");
            queue.add("Orange");
            queue.add("Yellow");
            queue.add("Green");
            queue.add("Blue");
            queue.add("Indigo");
            queue.add("Violet");
            System.out.println("Added all elements.");
            System.out.println();
            System.out.println(queue);
            System.out.println();
            System.out.println("Size should equal 7 : " + queue.size());
            System.out.println();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            System.out.println("Removed all elements.");
            System.out.println();
            System.out.println(queue);
            System.out.println();
            System.out.println("Size should equal 0 : " + queue.size());
            System.out.println();
            System.out.println();

            // Testing size method
            System.out.println("==========  M Y   S T A C K   T E S T   E M P T Y  ==========");
            System.out.println();
            System.out.println();
            System.out.println("Should equal [] : " + queue);
            System.out.println("Should equal true : " + queue.isEmpty());
            System.out.println();
            System.out.println();

            // Testing peek method
            System.out.println("==========  M Y   S T A C K   T E S T   P E E K  ==========");
            System.out.println();
            System.out.println();
            queue.add("Red");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            queue.add("Orange");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            queue.add("Yellow");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            queue.add("Green");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            queue.add("Blue");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            queue.add("Indigo");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            queue.add("Violet");
            System.out.println(queue.peek());
            System.out.println(queue.remove());
            System.out.println();
            System.out.println();


    }


    public static void main(String[] args) {
        intro();
        System.out.println();

        myStackPrintTest();
        myQueuePrintTest();

    }

}
