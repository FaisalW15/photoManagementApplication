package photoManagementApplication;

public class BST <T> {
	
	BSTNode<T> root, current;
	int numberOfComparisons = 0;
	
	public BST() {
	
	root = current = null;
	}
	
	//Complexity of empty O(1)
	public boolean empty() {
	return root == null;
	}
	//Complexity of full O(1)
	public boolean full() {
	return false;
	
	}
	//Complexity of retrieve O(1)
	public T retrieve () {
	return current.data;
	
	 }
	
	//same as findKey but keeps track of numberOfComparisons 
	public boolean findKeyCounter(String tkey) {
		 BSTNode<T> p = root, q = root; 
		 if (empty()) {
			 return false;
		 }

		 while (p != null) {
			 
			 numberOfComparisons++;

			 q = p;    
			 if (tkey.compareTo(p.key)==0) {  
				 return true;
			 } else if (tkey.compareTo(p.key)<0)
				 p = p.left; 
			 else
				 p = p.right;  
		 }

		 return false;
	}
	//Complexity of findKey O(n)
	public boolean findKey(String tkey) {
	    BSTNode<T> p = root, q = root; // p للبحث و q لحفظ اخر نقطة وصل لها
	    if (empty())
	        return false; // الشجرة فاضية

	    while (p != null) {
	    	
	        q = p; // حفظ النود الحالية
	        if (tkey.compareTo(p.key)==0) {
	            current = p; // وجدنا المفتاح
	            return true;
	        } else if (tkey.compareTo(p.key)<0 )//if (k < current.key)
	            p = p.left; // نبحث يسار
	        else
	            p = p.right; // نبحث يمين
	    }

	    current = q; // لم نجد المفتاح، نحفظ آخر نقطة وصلنا لها
	    return false;
	}
	
	//Complexity of insert O(n) if the BST is unbalanced and if BST is balancedO(log n)
	public boolean insert(String k, T val) {
	   
		if (root == null) {
			current = root = new BSTNode<T>(k, val);
			return true;}
		
		BSTNode<T> p = current;
		if (findKey(k)) {
		current = p;
		return false;}
		
		BSTNode<T> tmp = new BSTNode<T>(k, val);
		if (k. compareTo (current.key)<0) { //if (k < current.key)
		current.left = tmp;
		} else {
		current.right = tmp;}
		
		current = tmp;
		return true;
	}
	
	//Complexity of removeKey O(n) if the BST is unbalanced and if BST is balancedO(log n)
	// Method removeKey: iterative
	public boolean removeKey(String k) {
	    // Search for k
	    String k1 = k;
	    BSTNode<T> p = root;
	    BSTNode<T> q = null; // Parent of p

	    while (p != null) {
	        if (k1.compareTo(p.key)<0) {
	            q = p;
	            p = p.left;
	        } else if (k1.compareTo(p.key)>0) {
	            q = p;
	            p = p.right;
	        } else { // Found the key

	            // Check the three cases
	            if ((p.left != null) && (p.right != null)) {
	                // Case 3: two children
	                // Search for the min in the right subtree
	                BSTNode<T> min = p.right;
	                q = p;
	                while (min.left != null) {
	                    q = min;
	                    min = min.left;
	                }
	                p.key = min.key;
	                p.data = min.data;
	                k1 = min.key;
	                p = min;
	                // Now fall back to either case 1 or 2
	            }

	            // The subtree rooted at p will change here
	            if (p.left != null) { // One child
	                p = p.left;
	            } else { // One or no children
	                p = p.right;
	            }

	            if (q == null) { // No parent for p, root must change
	                root = p;
	            } else {
	                if (k1.compareTo(q.key)<0) {
	                    q.left = p;
	                } else {
	                    q.right = p;
	                }
	            }

	            current = root;
	            return true;
	        }
	    }
	    return false; // Not found
	} 
	

	//Complexity of inOrder O(n)
	public void inOrder () {
		if(root==null) 
			System.out.println("empty");
	inOrder (root) ;
	}
	public void inOrder (BSTNode<T>p) {
		
		if(p==null) return; 
		inOrder(p.left) ;
		System.out.print(p.key+" ");
		System.out.println(p.data);
		inOrder (p.right);
	}
	public void inOrder2() {
		if (root == null)
			System.out.println("empty tree");
		else
			inOrder2((BSTNode<LinkedList<Photo>>) root);
	}
	private void inOrder2(BSTNode<LinkedList<Photo>> p) {
	    if (p == null) { 
	    	return;
	    }
	    inOrder2(p.left);
	    System.out.println("key= " + p.key);
	    displayListOfPhoto(p.data);
	    inOrder2(p.right);
	}
	public void displayListOfPhoto(LinkedList<Photo> L) {
	    if (L.empty()) {
	        System.out.println("empty list");
	    } else {
	        L.FindFirst();
	        while (!L.last()) {
	            System.out.print(L.retrieve().path + " ");
	            L.findNext();
	        }
	        System.out.println(L.retrieve().path + " ");
	        System.out.println("-----------------------------------");
	    }
	}



}
