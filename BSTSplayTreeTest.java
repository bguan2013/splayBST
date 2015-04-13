/** Main test class
 *
 */
public class BSTSplayTreeTest{

	SplayBST<String> tree;


	/**Test add case left
	 *
	 *
	 */

	public void testLeft(){

		System.out.println("Testing inserting left of 1: ");
      	tree = new SplayBST<String>();
       	tree.add("2");  	
	  	System.out.println("From tree: ");
	 	tree.displayMe();
	 	tree.add("1");
	 	System.out.println("To adding 1 to the tree: ");
	 	tree.displayMe();
	 	System.out.println("Testing searching right of 2: ");
	 	tree.search("2");
	 	System.out.println("Now the tree looks like: ");
	 	tree.displayMe();
	 	System.out.println("");
	 	System.out.println("");


	}

	/**Test add case right
	 *
	 *
	 */
	public void testRight(){

		System.out.println("Testing inserting right of 2: ");
      	tree = new SplayBST<String>();
       	tree.add("1");  	
	  	System.out.println("From tree: ");
	 	tree.displayMe();
	 	tree.add("2");
	 	System.out.println("To adding 2 to the tree: ");
	 	tree.displayMe();

	 	System.out.println("Testing searching left of 1: ");
	 	tree.search("1");
	 	System.out.println("Now the tree looks like: ");
	 	tree.displayMe();
	 	System.out.println("");
	 	System.out.println("");

	}


	/**Test add case left-left
	 *
	 *
	 */
	public void testLL(){

		System.out.println("Testing inserting left-left of 1: ");
      	tree = new SplayBST<String>();
       	tree.add("2");
	  	tree.add("3");
	  	
	  	System.out.println("From tree: ");
	 	tree.displayMe();
	 	tree.add("1");
	 	System.out.println("To adding 1 to the tree: ");
	 	tree.displayMe();
	 	System.out.println("");
	 	System.out.println("");


	}
	/**Test add case left-right
	 *
	 *
	 */
	public void testLR(){

		System.out.println("Testing inserting left-right of 2: ");
		tree = new SplayBST<String>();
	 	tree.add("1");
	  	tree.add("3");
	  	System.out.println("From tree: ");
	 	tree.displayMe();
	 	tree.add("2");
	 	System.out.println("To adding 2 to the tree: ");
	 	tree.displayMe();
	 	System.out.println("");
	 	System.out.println("");
		
	}
	/**Test add case right-left
	 *
	 *
	 */
	public void testRL(){

		System.out.println("Testing inserting right-left of 3: ");
		tree = new SplayBST<String>();
	 	tree.add("4");
	  	tree.add("2");
	  	System.out.println("From tree: ");
	 	tree.displayMe();
	 	tree.add("3");
	 	System.out.println("To adding 3 to the tree: ");
	 	tree.displayMe();
	 	System.out.println("");
	 	System.out.println("");

		
	}
	/**Test add case right-right
	 *
	 *
	 */
	public void testRR(){

		System.out.println("Testing inserting right-right of 5: ");
		tree = new SplayBST<String>();
	 	tree.add("4");
	  	tree.add("3");
	  	System.out.println("From tree: ");
	 	tree.displayMe();
	 	tree.add("5");
	 	System.out.println("To adding 5 to the tree: ");
	 	tree.displayMe();
	 	System.out.println("");
	 	System.out.println("");


		
	}
	/**Test search case left-left
	 *
	 *
	 */
	public void testSearchingLL(){

		tree = new SplayBST<String>();
		tree.add("1");
	  	tree.add("2");
	  	tree.add("3");
	  	System.out.println("From tree(left-left is 1): ");
	  	tree.displayMe();
	  	System.out.println("To tree that searches for the left-left number, 1 (only showing 3 levels): ");
	  	tree.search("1");
	  	tree.displayMe();
	  	System.out.println("");
	 	System.out.println("");


	}
	/**Test search case left-right
	 *
	 *
	 */
	public void testSearchingLR(){

		tree = new SplayBST<String>();
		tree.add("3");
	  	tree.add("2");
	  	tree.add("1");
	  	tree.add("4");
	  	System.out.println("From tree (left-right is 3): ");
	  	tree.displayMe();
	  	System.out.println("To tree that searches for the right-left number, 3 (only showing 3 levels): ");
	  	tree.search("3");
	  	tree.displayMe();
	  	System.out.println("");
	 	System.out.println("");

		
	}
	/**Test search case right-left
	 *
	 *
	 */
	public void testSearchingRL(){
		

	 	tree = new SplayBST<String>();
		tree.add("2");
	  	tree.add("3");
	  	tree.add("4");
	  	tree.add("1");
	  	System.out.println("From tree( right-left is 2): ");
	  	tree.displayMe();
	  	System.out.println("To tree that searches for the left-right number, 2 (only showing 3 levels): ");
	  	tree.search("2");
	  	tree.displayMe();
	  	System.out.println("");
	 	System.out.println("");
	}

	/**Test search case right-right
	 *
	 *
	 */
	public void testSearchingRR(){

		tree = new SplayBST<String>();
		tree.add("3");
	  	tree.add("2");
	  	tree.add("1");
	  	System.out.println("From tree( right-right is 3): ");
	  	tree.displayMe();
	  	System.out.println("To tree that searches for the right-right number, 3 (only showing 3 levels): ");
	  	tree.search("3");
	  	tree.displayMe();
	  	System.out.println("");
	 	System.out.println("");
		
	}




// NOTE:  I put main in here just to give you an example of a way you can define test cases.  
// THIS SHOULD GO IN A SEPARATE TEST CLASS 
	/**Main method
	 */
    public static void main(String [] args) {
	

		
    	BSTSplayTreeTest test = new BSTSplayTreeTest();
    	System.out.println("Only displaying 3 levels of the tree......");
    	test.testLeft();
    	test.testRight();
		test.testLL();
		test.testLR();
		test.testRL();
		test.testRR();
		test.testSearchingLL();
		test.testSearchingLR();
		test.testSearchingRL();
		test.testSearchingRR();
		SplayBST<String> tree1 = new SplayBST<String>();
		tree1.add("1");
		tree1.add("2");
		tree1.add("3");
		tree1.add("4");
		tree1.add("5");
	 	tree1.displayMe();
	 	tree1.search("1");
	 	tree1.displayMe();

    }




	
}