import java.util.Comparator;
import java.lang.Comparable;


/**
 *The collection class BST.
 *
 */

public class SplayBST<E extends Comparable<E>> {

   Node<E> root;
   int count;
   Comparator<? super E> ordering;

    
    /**
 	 *The natural compartor BST constructor
 	 *
 	 */
    public SplayBST() {
		root = null;
		count = 0;
		ordering = new NaturalComparator<E> ();
    }

    /**The constructor that takes a comparator given by the user
 	 *
 	 *@param o			Takes a comparator to comare values.
 	 */
    public SplayBST(Comparator<? super E> o){

    	root = null;
    	count = 0;
    	ordering = o;

    }

    /**Adds a node to the tree.
 	 *
	 *
	 *@param x          Adding the value to a new node.
	 *
	 */
    //assumes no duplicates
    public void add(E x) {
	root = splayInsert(root,x); count++;
    }



    /** Search method that searches for 2 level down, moves node containing x to the root
     *
     *@param x 				Takes a value that search it through the tree
     *
     */
    
    public Node<E> search(E x) {
 	return root = splaySearch(root,x);
     }

    /** Private method to sinsert an value to the tree
     *
     *@param h 				Takes the root of the tree
     *@param x				Inserts the value x
     */

    private Node<E> splayInsert(Node<E> h, E x) {
	if (h==null) {
		return new Node<E>(x);
	}
	else{
		//if(count%2 == 1){
			if (ordering.compare(x,h.value)<0) {

			    if (h.left == null) {
				h.left = new Node<E>(x);
				
					return rotateRight(h);
				
			    }

			    if (ordering.compare(x,h.left.value)<0) {
				h.left.left = splayInsert(h.left.left,x);
				//It had a problem here
				h = rotateRight(h);
			    }
			    else {
				h.left.right = splayInsert(h.left.right,x);
				h.left = rotateLeft(h.left);
			    }
			    return rotateRight(h);
			}

			else { //ordering.compare(x,h.value)>0  
			    if (h.right == null) {
				h.right = new Node<E>(x);
				
					return rotateLeft(h);
				
			    }

			    if (ordering.compare(x,h.right.value)>0) {
			    //It had a problem here
				h.right.right = splayInsert(h.right.right,x);
				//It had a problem here
				h = rotateLeft(h);
			    }

			    else {
				h.right.left = splayInsert(h.right.left,x);
				h.right= rotateRight(h.right);
			    }
			    return rotateLeft(h);
			}
		
	}
	}

	/** private search method that searches for 2 level down
     *
     *@param h 				Takes the root that manipulate with it
     *@param x 				Takes a value that search it through the tree
     *
     */
	// 4 cases for two levels down in the search path from the root:
    // left-left:  rotate right at root twice
    // left-right: rotate left at left child; rotate right at root
    // right-right: rotate left at root twice
    // right-left: rltate right at right child, rotate left at root
    private Node<E> splaySearch(Node<E> h, E x) {

    	if (h==null) {
			return h;
		}
		else{
			
				if (ordering.compare(x,h.value)<0) {

				    if (h.left == null) {
						
						return h;
					
				    }

				    if (ordering.compare(x,h.left.value)<0) {
					h.left.left = splaySearch(h.left.left,x);
					//It had a problem here
					if(h.left.left != null){
						h = rotateRight(h);
					}

				    }
				    else if(ordering.compare(x,h.left.value)>0){
					h.left.right = splaySearch(h.left.right,x);
					if(h.left.right != null){
						h.left = rotateLeft(h.left);
					}
				    }
				    else{



				    }
				    return rotateRight(h);
				}
				else if (ordering.compare(x,h.value)>0){
				    
				    if (h.right == null) {
						
						return h;
					
				    }

				    if (ordering.compare(x,h.right.value)>0) {
				    //It had a problem here
					h.right.right = splaySearch(h.right.right,x);
					//It had a problem here
					if(h.right.right != null){
						h = rotateLeft(h);
					}
				    }

				    else if(ordering.compare(x,h.right.value)<0){
					h.right.left = splaySearch(h.right.left,x);
					if(h.right.left != null){
						h.right= rotateRight(h.right);
					}
				    }
				    else{


				    }
				    return rotateLeft(h);



				}
				else { //ordering.compare(x,h.value) == 0 


					return h;

				}
			
		}
}
    	/*case root;
    	if(h != null && ordering.compare(x, h.value) == 0){

    		return root;

    	}
    	//case left;
    	else if(h.left != null && ordering.compare(x, h.left.value) == 0){

    		return rotateRight(h);
    	}
    	//case right;
    	else if(h.right != null && ordering.compare(x, h.right.value) == 0){

    		return rotateLeft(h);

    	}
		
		//case 1;
    	else if(h.left != null && h.left.left != null && ordering.compare(x, h.left.left.value) == 0){
    			root = rotateRight(h);
    			return rotateRight(root);

    	}
    	//case 2;
    	else if(h.left != null && h.left.right != null &&  ordering.compare(x, h.left.right.value) == 0){
    			root.left = rotateLeft(h.left);
    			return rotateRight(root);


    	}
    	//case 3;
    	else if(h.right != null && h.right.right != null && ordering.compare(x, h.right.right.value) == 0){

    			root = rotateLeft(h);
    			return rotateLeft(root);



    	}
    	//case 4;
    	else if(h.right != null && h.right.left != null && ordering.compare(x, h.right.left.value) == 0){

    			root.right = rotateRight(h.right);
    			return rotateLeft(root);

    	}
    	
    	
    	// case null;
    	else{

    		System.out.println("There is no such node.");
    		return null;


    	}
		
	
    }*/
    /**Private method rotating left of h
     *
     *@param h 			The node that's going to rotate left
     *
     */
    
    private Node<E> rotateLeft(Node<E> h) {
	Node<E> x = h.right;
	h.right = x.left;
	x.left = h;
	System.out.println("Rotating left!");
	return x;
    }
    /**Private method rotating right of h
     *
     *@param h 			The node that's going to rotate right
     *
     */
    private Node<E> rotateRight(Node<E> h) {
	Node<E> x = h.left;
	h.left = x.right;
	x.right = h;
	System.out.println("Rotating right!");
	return x;
    }
    /**Prints out the 5 nodes that are inserted in the tree
     *
     *
     */
    public void displayMe(){

    	if(root != null){
    		System.out.println("   " + root.value + "   ");
    		if(root.left != null && root.right != null){
    			System.out.println(" " + root.left.value + "   " + root.right.value);

    			//1,2
    			if(root.left.left != null && root.left.right != null){
    			System.out.println(root.left.left.value + " " + root.left.right.value);
    			
    			}
    			//1
    			else if(root.left.left != null && root.left.right == null && root.right.left == null && root.right.right == null){
    				System.out.println(root.left.left.value);

    			}
    			//2
	    		else if(root.left.left == null && root.left.right != null && root.right.left == null && root.right.right == null){
	    			System.out.println("  " + root.left.right.value);

	    		}
	    		//3,4
	    		else if(root.right.left != null && root.right.right != null){
	    			System.out.println("    "+root.right.left.value + " " + root.right.right.value);
	    			
	    		}
	    		//3
	    		else if(root.left.left == null && root.left.right == null && root.right.left != null && root.right.right == null){
	    			System.out.println("    " + root.right.left.value);

	    		}
	    		//4
	    		else if(root.left.left == null && root.left.right == null && root.right.left == null && root.right.right != null){
	    			System.out.println("      " + root.right.right.value);

	    		}
	    		//1,3
	    		else if(root.left.left != null && root.right.left != null){
	    			System.out.println(root.left.left.value + " " + root.right.left.value);
	    			
	    		}
	    		//1,4
	    		else if(root.left.left != null && root.right.right != null){
	    			System.out.println(root.left.left.value + "     " + root.right.right.value);

	    		}
	    		//2,4
	    		else if(root.left.right != null && root.right.right != null){
	    			System.out.println("  " + root.left.right.value + "   " + root.right.right.value);

	    		}
	    		//2,3
	    		else if(root.left.right != null && root.right.left != null){
	    			System.out.println("  " + root.left.right.value + " " + root.right.left.value);

	    		}

    		}
    		//only has left
    		else if(root.left != null && root.right == null){
    			System.out.println(" " + root.left.value);

    			//1,2
    			if(root.left.left != null && root.left.right != null){
	    			System.out.println(root.left.left.value + " " + root.left.right.value);
	    			
	    		}
	    		//1
	    		else if(root.left.left != null && root.left.right == null){
	    			System.out.println(root.left.left.value);

	    		}
	    		//2
	    		else if(root.left.left == null && root.left.right != null){
	    			System.out.println("  " + root.left.right.value);

	    		}

    		}
    		//only has right
    		else if(root.left == null && root.right != null){
    			System.out.println("     " + root.right.value);
    			
    			//3.4
    			if(root.right.left != null && root.right.right != null){
	    			System.out.println("    " + root.right.left.value + "  " + root.right.right.value);
	    			
	    		}
	    		//3
	    		else if(root.right.left != null && root.right.right == null){
	    			System.out.println("    " + root.right.left.value);

	    		}
	    		//4
	    		else if(root.right.left == null && root.right.right != null){
	    			System.out.println("      " + root.right.right.value);

	    		}

    		}
    		else{
    			return;
    		}

    	}


    }
    
    
    

}