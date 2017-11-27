import java.util.Iterator;

public class MyList<T extends Comparable<T>> implements Iterable<Node<T>>{
	
	private Node<T> start;
	private Node<T> end;
	private int size;
	
	public MyList(Node<T> start, Node<T> end, int size){
		super();
		this.start = start;
		this.end = end;
		this.size = size;
	}

	public MyList() {
		super();
		this.start = null;
		this.end = null;
		this.size = 0;
	}

	//removes all nodes from MyList
	public void clear() {
		while(size !=0){
			this.remove(0);
		}
    }
    
    //adds new node, automatically ordering by invoice total
    public int add(T t){
    	Node<T> newNode = new Node<T>(t);
    	if(size == 0){
    		this.start = newNode;
    		this.end = newNode;
    		size++;
    		return 1;
    	}
    	Node<T> currentNode = this.start;
    	for(int i=0; i<this.size-1; i++){
    		if(newNode.compareTo(currentNode.getNext()) <= 0) {
    			//add newNode to the next position
    			newNode.setNext(currentNode.getNext());
    			currentNode.setNext(newNode);
    			size++;
    			return 1;
    			
    		}
    		else{
    			currentNode = currentNode.getNext();
    		}
    	}
    	//add to end if previous if statement does not trigger
    	this.end.setNext(newNode);
    	this.end = newNode;
    	size++;
    	return 0;
    }

    //removes node from specified position
    public void remove(int position) {
    	if(position < 0 || position > size){
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the MyList.");
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
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the MyList.");
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
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the MyList.");
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
	
	public MyList<T> getMyListCopy() {
		MyList<T> newMyList = new MyList<T>(this.getStart(), this.getEnd(), this.getSize());
		return newMyList;
	}


}

