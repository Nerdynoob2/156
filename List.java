import java.util.Iterator;

public class List<T extends Comparable<T>> implements Iterable<Node<T>>{
	
	private Node<T> start;
	private Node<T> end;
	private int size;
	
	public List(Node<T> start, Node<T> end, int size){
		super();
		this.start = start;
		this.end = end;
		this.size = size;
	}

	public List() {
		super();
		this.start = null;
		this.end = null;
		this.size = 0;
	}

	//removes all nodes from list
	public void clear() {
		while(size !=0){
			this.remove(0);
		}
    }

    //adds new node to end of list
    public void addToEnd(T t) {
    	Node<T> newNode = new Node<T>(t);
    	size++;
    	if(isEmpty()){
    		start = newNode;
    		end = start;	
    	} else{
    		end.setNext(newNode);
    		end = newNode;
    	}
    }
    
    //adds new node, automatically ordering by invoice total
    public void add(T t){
    	Node<T> newNode = new Node<T>(t);
    	if(size == 0){
    		this.start = newNode;
    		this.end = newNode;
    		size++;
    		return;
    	}
    	for(Node<T> node : this){
    		if(
    			NewNode.compareTo(node) >= 0){
        		
        	}
    	}
    	
    	//if negative, go on to next
    	//otherwise, add at that position
    }

    //removes node from specified position
    public void remove(int position) {
    	if(position < 0 || position > size){
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the list.");
    	}
    	if(size == 1){
    		start = null;
    		end = null;
    		size--;
    		return;
    	}
    	Node<T> currentNode = start;
    	for(int i = 0; i< position-2; i++){
    		if(currentNode.getNext() == null){
    			return;
    		}
    		currentNode = currentNode.getNext();
    	}
    	currentNode.setNext(currentNode.getNext().getNext());
    	size--;
    	return;
    }
    
    //returns node at a specified position
	public Node<T> getNode(int position) {
    	if(position < 0 || position > size){
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the list.");
    	}
    	Node<T> currentNode = start;
    	for(int i = 0; i< position-2; i++){
    		if(currentNode.getNext() == null){
    			return null;
    		}
    		currentNode = currentNode.getNext();
    	}
    	return currentNode.getNext();
    }
    
	//returns item stored in node at a specified position
    public T getItemFromLocation(int position) {
    	if(position < 0 || position > size){
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the list.");
    	}
    	Node<T> currentNode = start;
    	for(int i = 0; i< position-1; i++){
    		if(currentNode.getNext() == null){
    			return null;
    		}
    		currentNode = currentNode.getNext();
    	}
    	return currentNode.getItem();	
    }
    
    public boolean isEmpty(){
    	return start == null;
    }

    public Node<T> getStart() {
		return start;
	}

	public void setStart(Node<T> start) {
		this.start = start;
	}

	public Node<T> getEnd() {
		return end;
	}

	public void setEnd(Node<T> end) {
		this.end = end;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public Iterator<Node<T>> iterator() {
		return new ListIterator<T>(this);
	}
	
	public List<T> getListCopy() {
		List<T> newList = new List<T>(this.getStart(), this.getEnd(), this.getSize());
		return newList;
	}


}

