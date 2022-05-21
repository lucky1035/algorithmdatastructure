package linknode;

public class ReverseList {


    public ListNode reverseList(ListNode head) {

            if(head == null ){
                return null;
            }
           ListNode next =  head.next;
           //到表尾时 返回表尾
           if(next == null ){
                return head;
           }
            //将next节点的下一节点指向header
           ListNode  currentHeader = reverse(next);
           next.next = head;
           head.next = null ;
           return currentHeader;


    }

    public ListNode reverse(ListNode head) {

        ListNode next =  head.next;
        //到表尾时 返回表尾
        if(next == null ){
            return head;
        }
        //将next节点的下一节点指向header
        ListNode  currentHeader = reverse(next);
        next.next = head;
        return currentHeader;


    }




    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node = new ReverseList().reverseList(node1);
        while(true){
            if(null!=node.next){
                System.out.println(node.next.val);
                node = node.next;
            }else {
                return;
            }
        }
    }
}
