package photoManagementApplication;

public class node<T> {
 public T data;
 public node<T> next;
 public node<T> previous;
 
 public node() {
	 data = null;
	 next = null;
	 previous = null;
 }
 public node(T val) {
	 data = val;
	 next = null;
	 previous = null;
 }
 
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public node<T> getNext(){
	return next;
}
public void setNext(node<T> next) {
	this.next = next; 
}
}
