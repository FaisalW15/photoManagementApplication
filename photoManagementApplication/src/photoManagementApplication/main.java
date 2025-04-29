package photoManagementApplication;

public class main {

	public static void main(String[] args) {
	
	
	BST<Integer> b1 = new BST<Integer>();

	
    b1.insert("d", 4);
    b1.insert("b", 2);
    b1.insert("a", 1);
    b1.insert("c", 3);
    b1.insert("e", 5);
    b1.insert("g", 7);
    b1.insert("f", 6);
    b1. removeKey ("a");
    b1.inOrder();
   

	}

}
