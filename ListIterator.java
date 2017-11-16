import java.util.Iterator;

public class ListIterator<T extends Comparable<T>> implements Iterator<Node<T>>{

	private List<T> list;
	private int position = 0;
	
	public ListIterator(List<T> list) {
		this.list = list.getListCopy();
	}

	@Override
	public boolean hasNext() {
		if(position < list.getSize()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public Node<T> next() {
		Node<T> item = list.getNode(position);
		position++;
		return item;
	}
	
}
