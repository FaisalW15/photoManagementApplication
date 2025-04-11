package photoManagementApplication;

public class BT<T> {
	public BTNode<T> root;
	public BTNode<T> current;
	
	public BT() {
		root = current = null;
	}
public void update(T e) {
	current.data = e;
}
public boolean empty() {
	return root == null;
}
public boolean insert(relative r, T val) {
	switch (r) {
	case root:
		if(empty()) {
			root = current = new BTNode<T>(val);
			return true;
					}
		return false;
	case parent: return false;
	case leftChild: 
		if (current.left == null) {
			current.left = new BTNode<T>(val);
			current = current.left;
			return true;
		}
		else {
			return false;
		}
	case rightChild:
		if (current.right == null) {
			current.right = new BTNode<T>(val);
			current = current.right;
			return true;
		}
		else {
			return false;
		}
		default:
			return false;
		
	}
		
}

public boolean find(relative r) {
	switch(r) {
	case root:
	    current = root;
	    return true;
	case parent:
		return false;
	case leftChild:
		
		
		
	}
}
}
