class MyNode<T> {
    private T value;
    private MyNode<T> next;

    MyNode(){}

    MyNode(T value){
        this.value = value;
        this.next = null;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getNext() {
        return next;
    }
    public boolean hasNext() {
        return next != null;
    }
}
