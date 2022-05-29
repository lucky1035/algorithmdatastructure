package linknode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(null==head){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next !=null){
            if(p.next.next!=null&& p.next.val == p.next.next.val){
                ListNode next = findNextTarget(p);
                p.next = next;
            }else {
                p = p.next;
            }
        }
        return newHead.next;
    }

    /**
     * 2,3,3,4
     *node = 2 找到下一个不重复的节点  target = 4
     * @return
     */
    private ListNode findNextTarget(ListNode node){
        ListNode next = node.next;
        if(next==null){
            return null;
        }
        boolean hasMuilt = false;
        while(next.next != null){
            if(next.val !=next.next.val){
                return hasMuilt?next.next:next;
            }else {
                hasMuilt = true;
                next = next.next;
            }
        }
        return hasMuilt?null:next;
    }

    public static void main(String[] args) {

        int a [] = {1,1};
        ListNode head = ListNodeUtils.generate(a);
        ListNode node =  new DeleteDuplicates().deleteDuplicates(head);
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
