package sdk;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.peek());
//
//        System.out.println(stack.search(1));
//        System.out.println(stack.search(2));
//        System.out.println(stack.search(3));
//
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());


        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());

        System.out.println(queue.offer(1));
        System.out.println(queue.offer(3));

        System.out.println(queue.element());
        System.out.println(queue.poll());
        System.out.println(queue.poll());




    }
}
