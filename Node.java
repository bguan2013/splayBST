import java.util.Comparator;
import java.lang.Comparable;

/**Class of nodes
 */


class Node<E extends Comparable<E>> {
	Node<E> left;
	Node<E> right;
	E value;
	/** Regular Constructor
	 *@param x			Takes a value and store it
	*/
	public Node(E x) { 
	    left = null;
	    right = null;
	    value = x;
	}
    }