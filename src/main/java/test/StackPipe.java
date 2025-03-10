package test;

class StackPipe<T> {
    private Node<T> top; // 栈顶指针
    private Node<T> bottom; // 队列底部指针

    public StackPipe() {
        this.top = null;
        this.bottom = null;
    }

    // 将新的数据压入栈顶
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (top == null) {
            top = newNode;
            bottom = newNode;
        } else {
            newNode.setDown(top); // 新节点的 down 指向当前栈顶
            top.setUp(newNode); // 当前栈顶的 up 指向新节点
            top = newNode; // 更新栈顶为新节点
        }
    }

    // 以栈的方法取出一个数
    public T pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is null");
        }
        T data = top.getData(); // 获取栈顶数据
        if (top == bottom) { // 如果只有一个节点
            top = null;
            bottom = null;
        } else {
            top = top.getDown(); // 更新栈顶为下一个节点
            if (top != null) {
                top.setUp(null); // 清除新栈顶的 up 引用
            }
        }
        return data;
    }

    // 以队列的方法取出一个数
    public T pop2() {
        if (bottom == null) {
            throw new IllegalStateException("Queue is null");
        }
        T data = bottom.getData(); // 获取队列底部数据
        if (top == bottom) { // 如果只有一个节点
            top = null;
            bottom = null;
        } else {
            bottom = bottom.getUp(); // 更新队列底部为上一个节点
            if (bottom != null) {
                bottom.setDown(null); // 清除新底部的 down 引用
            }
        }
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        StackPipe<Integer> stackPipe = new StackPipe<>();

        // 压入数据
        stackPipe.push(1);
        stackPipe.push(2);
        stackPipe.push(3);

        // 使用 pop 取数（栈方式）
        System.out.println("Pop (stack): " + stackPipe.pop()); // 输出 3
        // 使用 pop2 取数（队列方式）
        System.out.println("Pop2 (queue): " + stackPipe.pop2()); // 输出 1

    }
}
