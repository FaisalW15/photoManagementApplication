package photoManagementApplication;

public class LinkedList<T> implements Lists<T> {

	public Node<T> head;
	public Node<T> current;
	
	public LinkedList() {
		head = current = null;
	}
	
	
	
	//Complexity of findfirst O(1)
	public void FindFirst() {
		current = head;
		
	}

	//Complexity of findNext O(1)
	@Override
	public void findNext() {
		current = current.next;
		
	}
	//Complexity of insert O(1)
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
	//Complexity of update O(1)
	@Override
	public void update(T e) {
		current.data = e;
	}

	//Complexity of remove O(n)
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
	//Complexity of full O(n)
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

	

	//Complexity of full O(1)
	@Override
	public boolean full() {
		return false;
		 
	}

	//Complexity of last O(1)
	@Override
	public boolean last() {
		return current.next ==null;
	}

	//Complexity of empty O(1)
	@Override
	public boolean empty() {
		return head==null;
	}


 

	//Complexity of retrieve O(1)
	@Override
	public T retrieve() {
		return current.data;
	} 

}
