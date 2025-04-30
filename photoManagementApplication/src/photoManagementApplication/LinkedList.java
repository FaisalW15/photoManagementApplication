package photoManagementApplication;

public class LinkedList<T> implements Lists<T> {

	public Node<T> head;
	public Node<T> current;
	
	public LinkedList() {
		head = current = null;
	}
	
	
	
	
	public void findFirst() {
		current = head;
		
	}

	@Override
	public void findNext() {
		current = current.next;
		
	}

	@Override
	public void insert(T e) {
		Node<T> temp;
		if (empty()) {
			head = current = new Node<T>(e);
		}
		else{
			temp = current.next;
			current.next = new Node<T>(e);
			current = current.next;
			current.next = temp;
			
		}
	}

	@Override
	public void update(T e) {
		current.data = e;
	}

	@Override
	public void remove () {
		if (current == head) { 
			head = head.next;
		} 
		else {
		Node<T> tmp = head; 
		while (tmp.next != current)
		tmp = tmp.next;
		tmp.next = current.next;
		} 
		if (current.next == null) 
			current = head;
		else
		current = current.next;
		 } 
	
	// added helping methods
	public void display() {
	    if (head == null) {
	        System.out.println("empty list");
	    }
	    Node<T> p = head;
	    while (p != null) {
	        System.out.print(p.data + " ");
	        p = p.next;
	    }
	}

	

	@Override
	public boolean full() {
		return false;
		 
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

}
