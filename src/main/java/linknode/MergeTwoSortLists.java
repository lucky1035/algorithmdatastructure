package linknode;

public class MergeTwoSortLists {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {

        ListNode head = null;
        ListNode current = null;
        head = new ListNode(0,null);
        current =  head;
        while (p1 != null || p2 != null) {
            if(p1==null){
                head.next = p2;
                return current.next;
            }else if(p2== null) {
                head.next = p1;
                return current.next;
            }else  if (p1.val < p2.val) {
                head.next = p1;
                p1 = p1.next;
            } else {
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }


        return current;

    }


    public static void main(String[] args) {
        int[] a  = {1,2,4} ;
        int[] b  = {0} ;
        ListNodeUtils.generate(a);
        ListNode result = new MergeTwoSortLists().mergeTwoLists(null,ListNodeUtils.generate(b));

        while (result !=null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
