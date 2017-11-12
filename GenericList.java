import java.util.Iterator;

public class GenericList<T extends Comparable<T>> implements Iterable<T>{
	
	private GenericNode<T> start;
	private GenericNode<T> end;
	private int size;

	public GenericList() {
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
    	GenericNode<T> newNode = new GenericNode<T>(t);
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
    	GenericNode<T> newNode = new GenericNode<T>(t);
    	if(size == 0){
    		this.start = newNode;
    		this.end = newNode;
    		size++;
    	}
    	newNode.compareTo( this.getGenericNode(0))
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
    	GenericNode<T> currentNode = start;
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
	private GenericNode<T> getGenericNode(int position) {
    	if(position < 0 || position > size){
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the list.");
    	}
    	GenericNode<T> currentNode = start;
    	for(int i = 0; i< position-2; i++){
    		if(currentNode.getNext() == null){
    			return null;
    		}
    		currentNode = currentNode.getNext();
    	}
    	return currentNode.getNext();
    }
    
	//returns item stored in node at a specified position
    public T getItem(int position) {
    	if(position < 0 || position > size){
    		throw new IndexOutOfBoundsException("Error: Given position is outside the range of the list.");
    	}
    	GenericNode<T> currentNode = start;
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

    public GenericNode<T> getStart() {
		return start;
	}

	public void setStart(GenericNode<T> start) {
		this.start = start;
	}

	public GenericNode<T> getEnd() {
		return end;
	}

	public void setEnd(GenericNode<T> end) {
		this.end = end;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}


}

