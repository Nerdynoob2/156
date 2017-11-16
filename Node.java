public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

	private Node<T> next;
    private T item;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public void setItem(T item ){
    	this.item = item;
    }

	@Override
	public int compareTo(Node<T> o) {
		return this.item.compareTo(o.getItem());
	}

}
