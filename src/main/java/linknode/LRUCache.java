package linknode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    int capacity;
    int length;
    Node header = new Node(null,null);
    Node tail = new Node(null,null);
    Map<Integer,Node> map ;

    public LRUCache(int capacity) {
        map = new HashMap<Integer,Node>(capacity);
        this.length = capacity;
        this.capacity = capacity;
        header.previous = null ;
        tail.next = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(null!=node){
            //从链表中移除该节点。
            node.remove();
            node.add(this.header,this.tail);
            return node.value;
        }
        return  -1;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //如果已存在，将该节点移动至链表头
        if(null !=node){
            node.value=value;
            //从链表中移除该节点。
            node.remove();
            node.add(this.header,this.tail);
        }else {
            node = new Node(key,value);
            map.put(key,node);
            if(capacity>0){
                //不存在该值且链表还有容量则继续往头部添加
                node.add(this.header,this.tail);
            }else {
                //将节点加入表头，并剔除表尾节点
                node.add(this.header,this.tail);
                Node discardNode = tail.previous;
                Node currentTail = discardNode.previous;
                tail.previous = currentTail;
                discardNode.remove();
                map.remove(discardNode.key);
            }

        }
    }


    class Node{
        public Node previous ;
        public Node next;
        public Integer value;
        public Integer key;

        public Node(Integer key , Integer value) {
            this.value = value;
            this.key = key;
        }

        public void remove() {
            Node nextNode = this.next;
            Node previousNode = this.previous;
            nextNode.previous = previousNode;
            previousNode.next = nextNode;
            capacity ++;
        }

        private void add(Node header,Node tail) {
            Node nextNode =  header.next ;
            header.next = this;
            //充值当前节点
            this.next = nextNode;
            this.previous = header;

            if(length==capacity){
                this.next = tail;
                tail.previous = this;
            }else {
                //重置被替换节点
                nextNode.previous = this;
            }
            capacity --;
        }



    }

    public static void main(String[] args) {
//        //case 1
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));      // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));
//        System.out.println(lRUCache.get(3));
//        System.out.println(lRUCache.get(4));

//        //case 8
//        LRUCache lRUCache = new LRUCache(1);
//        lRUCache.put(2, 1); // 缓存是 {1=1}
//        System.out.println(lRUCache.get(2));    // 返回 1
//        lRUCache.put(3, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2)); // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));//  返回 -2 (未找到)

        //case 12
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(2));    // 返回 1
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(4, 1); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(2));      // 返回 -1 (未找到)
    }

}
