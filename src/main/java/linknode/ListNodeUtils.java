package linknode;

/**
 * Definition for singly-linked list.
 */
public class ListNodeUtils {


    public static  ListNode generate(int [] a) {
        if(a.length==0){
            return null;
        }
        ListNode head = new ListNode(a[0]);
        ListNode p = head ;
        for (int i =1;i<a.length;i++){
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {

        int a [] = {1,2,3,3,4,4,5};
        ListNode node = ListNodeUtils.generate(a);

        while(true){
            if(null!=node){
                System.out.println(node.val);
                node = node.next;
            }else {
                return;
            }
        }
    }

}

