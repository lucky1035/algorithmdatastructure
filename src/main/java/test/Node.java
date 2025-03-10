package test;

public class Node<T> {
    private T data;

    // 指向上方节点引用
    private Node<T> up;

    // 指向下方节点引用
    private Node<T> down;

    // 构造方法：初始化节点数据， 默认为 null
    public Node(T data) {
        this.data = data;
        this.up = null;
        this.down = null;
    }

    // 获取数据
    public T getData() {
        return data;
    }

    // 设置节点数据
    public void setData(T data) {
        this.data = data;
    }

    // 获取上方节点
    public Node<T> getUp() {
        return up;
    }

    // 设置上方节点
    public void setUp(Node<T> up) {
        this.up = up;
    }

    // 获取下方节点
    public Node<T> getDown() {
        return down;
    }

    // 设置下方节点
    public void setDown(Node<T> down) {
        this.down = down;
    }

}