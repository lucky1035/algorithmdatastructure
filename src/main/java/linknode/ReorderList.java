package linknode;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode slowIndex = head;
        ListNode fastIndex =head;
        ListNode midIndex = null;
        while(null!=fastIndex && null!=fastIndex.next){
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next.next;
        }
        midIndex = slowIndex;
        ListNode l2 = midIndex.next;
        midIndex.next = null;
        ListNode reverselist= this.reverseList(l2);

        this.merge(head,reverselist);


//        while (null!=slowIndex.next){
//            stack.add(slowIndex.next);
//            slowIndex = slowIndex.next;
//        }
//        ListNode tmp = null;
//        while(!stack.empty()){
//            tmp = head.next;
//            ListNode next = stack.pop();
//            head.next = next;
//            next.next = tmp;
//            head = head.next.next;
//        }



    }

    private void merge(ListNode l1, ListNode l2) {

        while (l1!=null&&l2!=null){
            ListNode l1next = l1.next;
            ListNode l2next = l2.next;
            l1.next=l2;
            l2.next= l1next;
            l1 = l1.next.next;
            l2 = l2next;
        }
    }

    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode current = node;
        while(null!=current){
            ListNode nextTmp = current.next ;
            current.next = prev;
            prev=current;
            current =nextTmp ;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        new ReorderList().reorderList(node1);

        while(true){
            if(null!=node1){
                System.out.println(node1.val);
                node1 = node1.next;
            }else {
                return;
            }
        }
    }

}
