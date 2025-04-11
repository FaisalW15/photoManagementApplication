package photoManagementApplication;

public class linkedList<T> implements Lists<T> {

	public node<T> head;
	public node<T> current;
	
	public linkedList() {
		head = current = null;
	}
	
	
	
	
	public void findfirst() {
		current = head;
		
	}

	@Override
	public void findNext() {
		current = current.next;
		
	}

	@Override
	public void insert(T e) {
		node<T> temp;
		if (empty()) {
			head = current = new node<T>(e);
		}
		else{
			temp = current.next;
			current.next = new node<T>(e);
			current = current.next;
			current.next = temp;
			
		}
	}

	@Override
	public void update(T e) {
		current.data = e;
	}

	@Override
	public void remove() {
		if (current == head) {
			head = head.next;
			current = current.next;
		}
		else {
			node<T> temp = head;
			while(temp.next != current) {
				temp = temp.next;
			}
			temp.next = current.next;
			current = current.next;
		}
		if (current.next == null) {
			current = head;
		}
		else {
			current = current.next;
		}
		
	}

	@Override
	public boolean full() {
		 
	}

	@Override
	public boolean last() {
		return current.next ==null;
	}

	@Override
	public boolean empty() {
		return head==null;
	}




	@Override
	public T retrieve() {
		return current.data;
	}




	@Override
	public void findPrevious() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean first() {
		// TODO Auto-generated method stub
		return false;
	}

}
